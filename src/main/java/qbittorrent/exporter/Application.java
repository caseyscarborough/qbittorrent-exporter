package qbittorrent.exporter;

import io.vertx.core.http.HttpServerResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import qbittorrent.exporter.handler.QbtHttpHandler;

@Path("")
public class Application {

    @Inject
    QbtHttpHandler qbtHttpHandler;

    @GET
    public void metrics(HttpServerResponse serverResponse) {
        qbtHttpHandler.handleRequest(serverResponse);
    }
}
