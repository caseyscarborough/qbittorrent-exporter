package qbittorrent.exporter.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.api.ApiException;
import qbittorrent.api.model.MainData;
import qbittorrent.api.model.Preferences;
import qbittorrent.api.model.ServerState;
import qbittorrent.api.model.Torrent;
import qbittorrent.exporter.collector.QbtCollector;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class QbtHttpHandler implements HttpHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(QbtHttpHandler.class);

    private final PrometheusMeterRegistry registry;
    private final QbtCollector collector;
    private final ApiClient client;

    public QbtHttpHandler(ApiClient client,
                          PrometheusMeterRegistry registry,
                          QbtCollector collector) {
        this.client = client;
        this.registry = registry;
        this.collector = collector;
        registry.getPrometheusRegistry().register(collector);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
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

            String response = registry.scrape();
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }

            LOGGER.info("Completed in " + (System.nanoTime() - current) / 1_000_000 + "ms");
        } catch (ApiException e) {
            LOGGER.error("An error occurred calling API", e);
        } catch (Exception e) {
            LOGGER.error("An unhandled error occurred", e);
        }
    }
}
