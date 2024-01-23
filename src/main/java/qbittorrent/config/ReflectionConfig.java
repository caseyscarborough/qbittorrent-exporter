package qbittorrent.config;

import io.quarkus.runtime.annotations.RegisterForReflection;
import qbittorrent.api.model.MainData;
import qbittorrent.api.model.Preferences;
import qbittorrent.api.model.ServerState;
import qbittorrent.api.model.Torrent;

/**
 * Registration of classes used in GSON Object mapping
 */
@RegisterForReflection(targets = {
    MainData.class,
    Preferences.class,
    ServerState.class,
    Torrent.class
})
public class ReflectionConfig {
}
