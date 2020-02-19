package qbittorrent.api.model;

import com.google.gson.annotations.SerializedName;

public class MainData {

    @SerializedName("server_state")
    private ServerState serverState;

    public ServerState getServerState() {
        return serverState;
    }

    public void setServerState(ServerState serverState) {
        this.serverState = serverState;
    }

    @Override
    public String toString() {
        return
            "Response{" +
                "server_state = '" + serverState + '\'' +
                "}";
    }
}
