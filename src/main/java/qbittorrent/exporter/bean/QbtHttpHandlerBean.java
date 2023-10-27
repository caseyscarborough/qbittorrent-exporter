package qbittorrent.exporter.bean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.ApiClient;
import qbittorrent.exporter.handler.QbtHttpHandler;

/**
 * Bean definition for {@link QbtHttpHandler}.
 *
 * @author <a href="mailto:vincevillamora@gmail.com">Vince Villamora</a>
 */
@ApplicationScoped
public class QbtHttpHandlerBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(QbtHttpHandlerBean.class);

    @ConfigProperty(name = "qbittorrent.exporter.username")
    private String username;

    @ConfigProperty(name = "qbittorrent.exporter.password")
    private String password;

    @ConfigProperty(name = "qbittorrent.exporter.host")
    private String host;

    @ConfigProperty(name = "qbittorrent.exporter.port")
    private String port;

    @ConfigProperty(name = "qbittorrent.exporter.protocol")
    private String protocol;

    @ConfigProperty(name = "qbittorrent.exporter.baseUrl")
    private String baseUrl;

    @ConfigProperty(name = "qbittorrent.exporter.locale")
    private String locale;

    /**
     * Creates a {@link QbtHttpHandler} instance using the default configurations
     *
     * @return {@link QbtHttpHandler} instance
     */
    @Produces
    QbtHttpHandler qbtHttpHandler() {
        final ApiClient client = new ApiClient(baseUrl, username, password);
        try {
            return new QbtHttpHandler(client, locale);
        } catch (Exception e) {
            LOGGER.error("Unable to create HTTP handler", e);
            return null;
        }
    }
}
