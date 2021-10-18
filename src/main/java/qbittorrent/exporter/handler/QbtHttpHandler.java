package qbittorrent.exporter.handler;

import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.api.model.MainData;
import qbittorrent.api.model.Preferences;
import qbittorrent.api.model.ServerState;
import qbittorrent.api.model.Torrent;
import qbittorrent.exporter.collector.QbtCollector;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class QbtHttpHandler implements HttpHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(QbtHttpHandler.class);

    private final PrometheusMeterRegistry registry;
    private final QbtCollector collector;
    private final ApiClient client;

    public QbtHttpHandler(final ApiClient client) throws IOException {
        this.client = client;
        this.registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        this.collector = new QbtCollector();
        this.registry.getPrometheusRegistry().register(collector);
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        LOGGER.info("Beginning prometheus metrics collection...");
        long current = System.nanoTime();
        try {
            List<Torrent> torrents = client.getTorrents();
            Preferences preferences = client.getPreferences();
            MainData data = client.getMainData();
            ServerState serverState = data.getServerState();
            collector.clear();
            collector.setAppVersion(client.getVersion());
            collector.setTotalTorrents(torrents.size());
            collector.setGlobalAlltimeDownloadedBytes(serverState.getAlltimeDl());
            collector.setGlobalAlltimeUploadedBytes(serverState.getAlltimeUl());
            collector.setGlobalSessionDownloadedBytes(serverState.getDlInfoData());
            collector.setGlobalSessionUploadedBytes(serverState.getUpInfoData());
            collector.setGlobalDownloadSpeedBytes(serverState.getDlInfoSpeed());
            collector.setGlobalUploadSpeedBytes(serverState.getUpInfoSpeed());
            collector.setGlobalRatio(Double.parseDouble(serverState.getGlobalRatio()));
            collector.setAppDownloadRateLimitBytes(serverState.getDlRateLimit());
            collector.setAppUploadRateLimitBytes(serverState.getUpRateLimit());
            collector.setAppAlternateDownloadRateLimitBytes(preferences.getAltDlLimit());
            collector.setAppAlternateUploadRateLimitBytes(preferences.getAltUpLimit());
            collector.setAppAlternateRateLimitsEnabled(serverState.isUseAltSpeedLimits());
            collector.setAppMaxActiveDownloads(preferences.getMaxActiveDownloads());
            collector.setAppMaxActiveUploads(preferences.getMaxActiveUploads());
            collector.setAppMaxActiveTorrents(preferences.getMaxActiveTorrents());

            for (Torrent torrent : torrents) {
                collector.setTorrentDownloadSpeedBytes(torrent.getName(), torrent.getDownloadSpeed());
                collector.setTorrentUploadSpeedBytes(torrent.getName(), torrent.getUploadSpeed());
                collector.setTorrentTotalDownloadedBytes(torrent.getName(), torrent.getDownloaded());
                collector.setTorrentSessionDownloadedBytes(torrent.getName(), torrent.getDownloadedSession());
                collector.setTorrentTotalUploadedBytes(torrent.getName(), torrent.getUploaded());
                collector.setTorrentSessionUploadedBytes(torrent.getName(), torrent.getUploadedSession());
                collector.setTorrentEta(torrent.getName(), torrent.getEta());
                collector.setTorrentProgress(torrent.getName(), torrent.getProgress());
                collector.setTorrentTimeActive(torrent.getName(), torrent.getTimeActive());
                collector.setTorrentSeeders(torrent.getName(), torrent.getNumSeeds());
                collector.setTorrentLeechers(torrent.getName(), torrent.getNumLeechs());
                collector.setTorrentRatio(torrent.getName(), torrent.getRatio());
                collector.setTorrentAmountLeftBytes(torrent.getName(), torrent.getAmountLeft());
                collector.setTorrentSizeBytes(torrent.getName(), torrent.getSize());
                collector.setTorrentInfo(torrent);
            }

            List<String> states = torrents.stream().map(Torrent::getState).distinct().collect(Collectors.toList());
            for (String state : states) {
                long count = torrents.stream().filter(t -> t.getState().equals(state)).count();
                collector.setTorrentStates(state, count);
            }

            LOGGER.info("Completed in " + (System.nanoTime() - current) / 1_000_000 + "ms");
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain;charset=utf-8");
            exchange.getResponseSender().send(registry.scrape());
        } catch (Exception e) {
            LOGGER.error("An error occurred calling API", e);
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
            exchange.setStatusCode(500);
            exchange.getResponseSender().send("An error occurred. " + e.getMessage());
        }
    }
}
