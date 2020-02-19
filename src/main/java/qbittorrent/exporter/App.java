package qbittorrent.exporter;

import com.sun.net.httpserver.HttpServer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.Gauge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.api.ApiException;
import qbittorrent.api.model.Torrent;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static final String GAUGE_NAME_PREFIX = "qbittorrent_";
    private static final String USERNAME_ENV_KEY = "QBITTORRENT_USERNAME";
    private static final String PASSWORD_ENV_KEY = "QBITTORRENT_PASSWORD";
    private static final String HOST_ENV_KEY = "QBITTORRENT_HOST";
    private static final String PORT_ENV_KEY = "QBITTORRENT_PORT";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "adminadmin";
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PORT = "8080";
    private static final int METRICS_PORT = 17871;

    public static void main(String[] args) {
        String username = System.getenv(USERNAME_ENV_KEY);
        String password = System.getenv(PASSWORD_ENV_KEY);
        String host = System.getenv(HOST_ENV_KEY);
        String port = System.getenv(PORT_ENV_KEY);

        if (username == null) {
            LOGGER.warn("Environment variable " + USERNAME_ENV_KEY + " is not available. Using default...");
            username = DEFAULT_USERNAME;
        }

        if (password == null) {
            LOGGER.warn("Environment variable " + PASSWORD_ENV_KEY + " is not available. Using default...");
            password = DEFAULT_PASSWORD;
        }

        if (host == null) {
            LOGGER.warn("Environment variable " + HOST_ENV_KEY + " is not available. Using default...");
            host = DEFAULT_HOST;
        }

        if (port == null) {
            LOGGER.warn("Environment variable " + PORT_ENV_KEY + " is not available. Using default...");
            port = DEFAULT_PORT;
        }

        final ApiClient client = new ApiClient(host, port);
        client.login(username, password);
        LOGGER.info("Your qBittorrent version is " + client.getVersion() + ".");

        Gauge dlSpeedTotal = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "download_speed_bytes_total")
            .help("The total current download speed of all torrents (in bytes)")
            .create();

        Gauge upSpeedTotal = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "upload_speed_bytes_total")
            .help("The total current upload speed of all torrents (in bytes)")
            .create();

        List<Gauge> gauges = new ArrayList<>();
        Gauge dlSpeed = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "download_speed_bytes")
            .labelNames("name")
            .help("The current download speed of torrents (in bytes)")
            .create();
        gauges.add(dlSpeed);

        Gauge upSpeed = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "upload_speed_bytes")
            .labelNames("name")
            .help("The current upload speed of torrents (in bytes)")
            .create();
        gauges.add(upSpeed);

        Gauge progress = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "progress")
            .labelNames("name")
            .help("The current progress of torrents")
            .create();
        gauges.add(progress);

        Gauge downloadedBytesTotal = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "downloaded_bytes_total")
            .labelNames("name")
            .help("The current total download amount of torrents (in bytes)")
            .create();
        gauges.add(downloadedBytesTotal);

        Gauge downloadedBytesSession = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "downloaded_bytes_session")
            .labelNames("name")
            .help("The current session download amount of torrents (in bytes)")
            .create();
        gauges.add(downloadedBytesSession);

        Gauge uploadedBytesTotal = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "uploaded_bytes_total")
            .labelNames("name")
            .help("The current total upload amount of torrents (in bytes)")
            .create();
        gauges.add(uploadedBytesTotal);

        Gauge uploadedBytesSession = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "uploaded_bytes_session")
            .labelNames("name")
            .help("The current session upload amount of torrents (in bytes)")
            .create();
        gauges.add(uploadedBytesSession);

        Gauge timeActive = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "time_active")
            .labelNames("name")
            .help("The total active time (in seconds)")
            .create();
        gauges.add(timeActive);

        Gauge state = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "state")
            .labelNames("name")
            .help("The current state of torrents")
            .create();
        gauges.add(state);

        Gauge version = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "version")
            .labelNames("version")
            .help("The current qBittorrent version")
            .create();
        gauges.add(version);

        Gauge seeders = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "seeders")
            .labelNames("name")
            .help("The current number of seeders for each torrent")
            .create();
        gauges.add(seeders);

        Gauge leechers = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "leechers")
            .labelNames("name")
            .help("The current number of leechers for each torrent")
            .create();
        gauges.add(leechers);

        Gauge ratio = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "ratio")
            .labelNames("name")
            .help("The current ratio each torrent")
            .create();
        gauges.add(ratio);

        Gauge amountLeft = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "amount_left_bytes")
            .labelNames("name")
            .help("The amount remaining for each torrent (in bytes)")
            .create();
        gauges.add(amountLeft);

        Gauge size = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "size_bytes")
            .labelNames("name")
            .help("The size for each torrent (in bytes)")
            .create();
        gauges.add(size);

        Gauge totalTorrents = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "total_torrents")
            .help("The total number of torrents")
            .create();
        gauges.add(totalTorrents);

        Gauge info = Gauge.build()
            .name(GAUGE_NAME_PREFIX + "info")
            // Labels are named this way for displaying them in a table with Grafana.
            // Columns can't be ordered and are ordered by name when using Prometheus
            // as a datasource. You can override the column names in the table Column
            // Style configuration.
            // see https://github.com/grafana/grafana/issues/5082
            .labelNames("_01_name", "_08_state", "_07_size", "_02_progress", "_05_seeders", "_06_leechers", "_03_dl_speed", "_04_up_speed", "_09_amount_left", "_10_time_active")
            .help("All info for torrents")
            .create();
        gauges.add(info);

        PrometheusMeterRegistry prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        for (Gauge gauge : gauges) {
            gauge.register(prometheusRegistry.getPrometheusRegistry());
        }

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(METRICS_PORT), 0);
            server.createContext("/metrics", httpExchange -> {
                LOGGER.info("Beginning prometheus metrics collection...");
                long current = System.nanoTime();
                try {
                    for (Gauge gauge : gauges) {
                        gauge.clear();
                    }

                    version.labels(client.getVersion()).set(1);

                    List<Torrent> torrents = client.getTorrents();
                    totalTorrents.set(torrents.size());

                    for (Torrent torrent : torrents) {
                        dlSpeed.labels(torrent.getName()).set(torrent.getDlspeed());
                        upSpeed.labels(torrent.getName()).set(torrent.getUpspeed());
                        downloadedBytesTotal.labels(torrent.getName()).set(torrent.getDownloaded());
                        downloadedBytesSession.labels(torrent.getName()).set(torrent.getDownloadedSession());
                        uploadedBytesTotal.labels(torrent.getName()).set(torrent.getUploaded());
                        uploadedBytesSession.labels(torrent.getName()).set(torrent.getUploadedSession());
                        progress.labels(torrent.getName()).set(torrent.getProgress());
                        timeActive.labels(torrent.getName()).set(torrent.getTimeActive());
                        seeders.labels(torrent.getName()).set(torrent.getNumSeeds());
                        leechers.labels(torrent.getName()).set(torrent.getNumLeechs());
                        ratio.labels(torrent.getName()).set(torrent.getRatio());
                        amountLeft.labels(torrent.getName()).set(torrent.getAmountLeft());
                        size.labels(torrent.getName()).set(torrent.getSize());
                        info.labels(
                            torrent.getName(),
                            torrent.getState(),
                            String.valueOf(torrent.getSize()),
                            String.valueOf(torrent.getProgress()),
                            String.valueOf(torrent.getNumSeeds()),
                            String.valueOf(torrent.getNumLeechs()),
                            String.valueOf(torrent.getDlspeed()),
                            String.valueOf(torrent.getUpspeed()),
                            String.valueOf(torrent.getAmountLeft()),
                            String.valueOf(torrent.getTimeActive())).set(1);
                    }

                    dlSpeedTotal.set(torrents.stream().mapToDouble(Torrent::getDlspeed).sum());
                    upSpeedTotal.set(torrents.stream().mapToDouble(Torrent::getUpspeed).sum());

                    List<String> states = torrents.stream().map(Torrent::getState).distinct().collect(Collectors.toList());
                    for (String s : states) {
                        state.labels(s).set(torrents.stream().filter(t -> t.getState().equals(s)).count());
                    }

                    String response = prometheusRegistry.scrape();
                    httpExchange.sendResponseHeaders(200, response.getBytes().length);
                    try (OutputStream os = httpExchange.getResponseBody()) {
                        os.write(response.getBytes());
                    }

                    LOGGER.info("Completed in " + (System.nanoTime() - current) / 1_000_000 + "ms");
                } catch (ApiException e) {
                    LOGGER.error("An error occurred calling API", e);
                }
            });

            new Thread(server::start).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
