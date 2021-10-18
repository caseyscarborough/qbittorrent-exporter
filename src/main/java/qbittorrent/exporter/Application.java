package qbittorrent.exporter;

import io.undertow.Undertow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.exporter.handler.QbtHttpHandler;

import java.io.IOException;

import static io.undertow.Handlers.path;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

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
        try {
            final QbtHttpHandler handler = new QbtHttpHandler(client);
            final Undertow server = Undertow.builder()
                .setIoThreads(2)
                .setWorkerThreads(10)
                .addHttpListener(METRICS_PORT, "127.0.0.1")
                .setHandler(path().addPrefixPath("/metrics", handler))
                .build();
            server.start();
            LOGGER.info("Server is listening for connections at http://127.0.0.1:" + METRICS_PORT + "/metrics");
        } catch (IOException e) {
            LOGGER.error("Unable to start HTTP server", e);
        }
    }
}
