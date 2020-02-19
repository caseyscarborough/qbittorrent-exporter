package qbittorrent.exporter.collector;

import qbittorrent.api.model.Torrent;

public interface QbtMetrics {
    void clear();
    void setAppVersion(String version);
    void setTorrentDownloadSpeedBytes(String name, double value);
    void setTorrentUploadSpeedBytes(String name, double value);
    void setTorrentProgress(String name, double value);
    void setTorrentTimeActive(String name, double value);
    void setTorrentStates(String name, long value);
    void setTorrentSeeders(String name, int value);
    void setTorrentLeechers(String name, int value);
    void setTorrentRatio(String name, double value);
    void setTorrentAmountLeftBytes(String name, double value);
    void setTorrentSizeBytes(String name, double value);
    void setTorrentInfo(Torrent torrent);
    void setTorrentSessionDownloadedBytes(String name, double value);
    void setTorrentSessionUploadedBytes(String name, double value);
    void setTorrentTotalDownloadedBytes(String name, double value);
    void setTorrentTotalUploadedBytes(String name, double value);
    void setTotalDownloadedBytes(double value);
    void setTotalUploadedBytes(double value);
    void setTotalDownloadSpeedBytes(double value);
    void setTotalUploadSpeedBytes(double value);
    void setTotalTorrents(int value);
}
