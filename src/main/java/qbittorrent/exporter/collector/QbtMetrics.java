package qbittorrent.exporter.collector;

import qbittorrent.api.model.Torrent;

public interface QbtMetrics {
    void clear();

    void setAppVersion(String version);

    void setAppMaxActiveDownloads(double value);

    void setAppMaxActiveUploads(double value);

    void setAppMaxActiveTorrents(double value);

    void setAppDownloadRateLimitBytes(double value);

    void setAppUploadRateLimitBytes(double value);

    void setAppAlternateDownloadRateLimitBytes(double value);

    void setAppAlternateUploadRateLimitBytes(double value);

    void setAppAlternateRateLimitsEnabled(boolean enabled);

    void setTorrentDownloadSpeedBytes(String name, double value);

    void setTorrentUploadSpeedBytes(String name, double value);

    void setTorrentEta(String name, double value);

    void setTorrentProgress(String name, double value);

    void setTorrentTimeActive(String name, double value);

    void setTorrentStates(String name, long value);

    void setTorrentSeeders(String name, long value);

    void setTorrentLeechers(String name, long value);

    void setTorrentRatio(String name, double value);

    void setTorrentAmountLeftBytes(String name, double value);

    void setTorrentSizeBytes(String name, double value);

    void setTorrentInfo(Torrent torrent);

    void setTorrentSessionDownloadedBytes(String name, double value);

    void setTorrentSessionUploadedBytes(String name, double value);

    void setTorrentTotalDownloadedBytes(String name, double value);

    void setTorrentTotalUploadedBytes(String name, double value);

    void setGlobalAlltimeDownloadedBytes(double value);

    void setGlobalAlltimeUploadedBytes(double value);

    void setGlobalSessionDownloadedBytes(double value);

    void setGlobalSessionUploadedBytes(double value);

    void setGlobalDownloadSpeedBytes(double value);

    void setGlobalUploadSpeedBytes(double value);

    void setGlobalRatio(double value);

    void setTotalTorrents(long value);
}
