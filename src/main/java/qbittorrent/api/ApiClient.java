package qbittorrent.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.model.MainData;
import qbittorrent.api.model.Preferences;
import qbittorrent.api.model.Torrent;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public class ApiClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);

    private final String baseUrl;
    private final HttpClient client;
    private final Gson gson;
    private boolean loggedIn = false;
    private String authCookie;

    public ApiClient(String host, String port) {
        this.baseUrl = "http://" + host + ":" + port;

        LOGGER.info("Using qBittorrent url " + baseUrl);
        client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .build();
        gson = new Gson();
    }

    public void login(String username, String password) {
        LOGGER.info("Logging in user " + username);
        final String data = "username=" + username + "&password=" + password;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/api/v2/auth/login?" + data))
            .header("Referer", baseUrl)
            .headers("Origin", baseUrl)
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new ApiException("Could not log in: (" + response.statusCode() + ") " + response.body());
            }

            HttpHeaders headers = response.headers();
            Optional<String> setCookie = headers.firstValue("Set-Cookie");

            if (setCookie.isEmpty()) {
                throw new ApiException("Could not get auth cookie from qBittorrent");
            }

            String setCookieValue = setCookie.get();
            if (!setCookieValue.contains("SID=")) {
                throw new ApiException("Could not get auth cookie from qBittorrent");
            }

            authCookie = setCookie.get().split(";")[0].split("=")[1];
            loggedIn = true;
        } catch (IOException | InterruptedException e) {
            throw new ApiException("Could not log in", e);
        }
    }

    public MainData getMainData() {
        return getRequest("/sync/maindata", new TypeToken<>() {
        });
    }

    public Preferences getPreferences() {
        return getRequest("/app/preferences", new TypeToken<>() {
        });
    }

    public String getVersion() {
        return getRequest("/app/version");
    }

    public List<Torrent> getTorrents() {
        return getRequest("/torrents/info", new TypeToken<>() {
        });
    }

    private String getRequest(String apiUrl) {
        LOGGER.info("Making request to " + apiUrl + "...");

        if (!loggedIn) {
            throw new ApiException("You must log in to retrieve torrents");
        }

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + "/api/v2" + apiUrl))
            .header("Referer", baseUrl)
            .header("Cookie", "SID=" + authCookie)
            .GET()
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new ApiException("An error occurred calling " + apiUrl + ": (" + response.statusCode() + ") " + response.body());
            }
        } catch (IOException | InterruptedException e) {
            throw new ApiException("Could not get torrent list", e);
        }
    }

    private <T> T getRequest(String apiUrl, TypeToken<T> token) {
        String json = getRequest(apiUrl);
        return gson.fromJson(json, token.getType());
    }
}
