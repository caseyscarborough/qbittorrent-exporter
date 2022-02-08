package qbittorrent.exporter;

import io.undertow.Undertow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.exporter.handler.QbtHttpHandler;

import static io.undertow.Handlers.path;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private static final String USERNAME_ENVIRONMENT = "QBITTORRENT_USERNAME";
    private static final String USERNAME_DEFAULT = "admin";
    private static final String PASSWORD_ENVIRONMENT = "QBITTORRENT_PASSWORD";
    private static final String PASSWORD_DEFAULT = "adminadmin";
    private static final String HOST_ENVIRONMENT = "QBITTORRENT_HOST";
    private static final String HOST_DEFAULT = "localhost";
    private static final String PORT_ENVIRONMENT = "QBITTORRENT_PORT";
    private static final String PORT_DEFAULT = "8080";
    private static final String PROTOCOL_ENVIRONMENT = "QBITTORRENT_PROTOCOL";
    private static final String PROTOCOL_DEFAULT = "http";
    private static final String BASE_URL_ENVIRONMENT = "QBITTORRENT_BASE_URL";
    private static final String METRICS_HOST = "0.0.0.0";
    private static final String METRICS_PATH = "/metrics";
    private static final int METRICS_PORT = 17871;

    public static void main(String[] args) {
        final String username = getEnvironment(USERNAME_ENVIRONMENT, USERNAME_DEFAULT);
        final String password = getEnvironment(PASSWORD_ENVIRONMENT, PASSWORD_DEFAULT);
        final String host = getEnvironment(HOST_ENVIRONMENT, HOST_DEFAULT);
        final String port = getEnvironment(PORT_ENVIRONMENT, PORT_DEFAULT);
        final String protocol = getEnvironment(PROTOCOL_ENVIRONMENT, PROTOCOL_DEFAULT);
        final String baseUrl = getEnvironment(BASE_URL_ENVIRONMENT, String.format("%s://%s:%s", protocol, host, port));

        final ApiClient client = new ApiClient(baseUrl);
        client.login(username, password);
        LOGGER.info("Your qBittorrent version is {}.", client.getVersion());
        try {
            final QbtHttpHandler handler = new QbtHttpHandler(client);
            final Undertow server = Undertow.builder()
                .setIoThreads(2)
                .setWorkerThreads(10)
                .addHttpListener(METRICS_PORT, METRICS_HOST)
                .setHandler(path().addPrefixPath(METRICS_PATH, handler))
                .build();
            server.start();
            String url = String.format("http://%s:%s%s", METRICS_HOST, METRICS_PORT, METRICS_PATH);
            LOGGER.info("Server is listening for connections at {}", url);
        } catch (Exception e) {
            LOGGER.error("Unable to start HTTP server", e);
        }
    }

    private static String getEnvironment(final String key, final String fallback) {
        final String value = System.getenv(key);
        if (value != null && !value.isBlank()) {
            LOGGER.debug("Environment variable {} found with value '{}'.", key, value);
            return value;
        }
        LOGGER.debug("Environment variable {} was not found. Using default value '{}'.", key, fallback);
        return fallback;
    }
}
