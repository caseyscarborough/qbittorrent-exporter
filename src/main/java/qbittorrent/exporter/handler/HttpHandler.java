package qbittorrent.exporter.handler;

import io.vertx.core.http.HttpServerResponse;

/**
 * Interface for extending HTTP handlers
 */
public interface HttpHandler {

    void handleRequest(HttpServerResponse serverResponse);
}
