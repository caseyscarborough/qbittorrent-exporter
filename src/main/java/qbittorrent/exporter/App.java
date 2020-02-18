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

    private static final String USERNAME_ENV_KEY = "QBITTORRENT_USERNAME";
    private static final String PASSWORD_ENV_KEY = "QBITTORRENT_PASSWORD";
    private static final String HOST_ENV_KEY = "QBITTORRENT_HOST";
    private static final String PORT_ENV_KEY = "QBITTORRENT_PORT";
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "adminadmin";
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_PORT = "8080";
    private static final int METRICS_PORT = 17871;

    public static void main(String[] args) throws IOException {
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

        List<Gauge> gauges = new ArrayList<>();
        Gauge dlSpeed = Gauge.build()
            .name("qbittorrent_download_speed_bytes")
            .labelNames("name")
            .help("The current download speed of torrents (in bytes)")
            .create();
        gauges.add(dlSpeed);

        Gauge upSpeed = Gauge.build()
            .name("qbittorrent_upload_speed_bytes")
            .labelNames("name")
            .help("The current upload speed of torrents (in bytes)")
            .create();
        gauges.add(upSpeed);

        Gauge progress = Gauge.build()
            .name("qbittorrent_progress")
            .labelNames("name")
            .help("The current progress of torrents")
            .create();
        gauges.add(progress);

        Gauge downloadedBytesTotal = Gauge.build()
            .name("qbittorrent_downloaded_bytes_total")
            .labelNames("name")
            .help("The current total download amount of torrents (in bytes)")
            .create();
        gauges.add(downloadedBytesTotal);

        Gauge downloadedBytesSession = Gauge.build()
            .name("qbittorrent_downloaded_bytes_session")
            .labelNames("name")
            .help("The current session download amount of torrents (in bytes)")
            .create();
        gauges.add(downloadedBytesSession);

        Gauge uploadedBytesTotal = Gauge.build()
            .name("qbittorrent_uploaded_bytes_total")
            .labelNames("name")
            .help("The current total upload amount of torrents (in bytes)")
            .create();
        gauges.add(uploadedBytesTotal);

        Gauge uploadedBytesSession = Gauge.build()
            .name("qbittorrent_uploaded_bytes_session")
            .labelNames("name")
            .help("The current session upload amount of torrents (in bytes)")
            .create();
        gauges.add(uploadedBytesSession);

        Gauge timeActive = Gauge.build()
            .name("qbittorrent_time_active")
            .labelNames("name")
            .help("The total active time (in seconds)")
            .create();
        gauges.add(timeActive);

        Gauge state = Gauge.build()
            .name("qbittorrent_state")
            .labelNames("name")
            .help("The current state of torrents")
            .create();
        gauges.add(state);

        Gauge version = Gauge.build()
            .name("qbittorrent_version")
            .labelNames("version")
            .help("The current qBittorrent version")
            .create();
        gauges.add(version);

        Gauge seeders = Gauge.build()
            .name("qbittorrent_seeders")
            .labelNames("name")
            .help("The current number of seeders for each torrent")
            .create();
        gauges.add(seeders);

        Gauge leechers = Gauge.build()
            .name("qbittorrent_leechers")
            .labelNames("name")
            .help("The current number of leechers for each torrent")
            .create();
        gauges.add(leechers);

        Gauge ratio = Gauge.build()
            .name("qbittorrent_ratio")
            .labelNames("name")
            .help("The current ratio each torrent")
            .create();
        gauges.add(ratio);

        Gauge amountLeft = Gauge.build()
            .name("qbittorrent_amount_left_bytes")
            .labelNames("name")
            .help("The amount remaining for each torrent (in bytes)")
            .create();
        gauges.add(amountLeft);

        Gauge size = Gauge.build()
            .name("qbittorrent_size_bytes")
            .labelNames("name")
            .help("The size for each torrent (in bytes)")
            .create();
        gauges.add(size);

        Gauge totalTorrents = Gauge.build()
            .name("qbittorrent_total_torrents")
            .help("The total number of torrents")
            .create();
        gauges.add(totalTorrents);

        Gauge info = Gauge.build()
            .name("qbittorrent_info")
            // Labels are named this way for displaying them in a table with Grafana.
            // Columns can't be ordered and are ordered by name when using Prometheus
            // as a datasource. You can override the column names in the table Column
            // Style configuration.
            // see https://github.com/grafana/grafana/issues/5082
            .labelNames("_01_name", "_08_state", "_07_size", "_02_progress", "_05_seeders", "_06_leechers", "_03_dl_speed", "_04_up_speed")
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
                            String.valueOf(torrent.getUpspeed())).set(1);
                    }

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
