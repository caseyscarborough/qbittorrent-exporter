package qbittorrent.exporter;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.exporter.collector.QbtCollector;
import qbittorrent.exporter.handler.QbtHttpHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

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

        PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        QbtCollector collector = new QbtCollector();
        HttpHandler handler = new QbtHttpHandler(client, registry, collector);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(METRICS_PORT), 0);
            server.createContext("/metrics", handler);
            new Thread(server::start).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
