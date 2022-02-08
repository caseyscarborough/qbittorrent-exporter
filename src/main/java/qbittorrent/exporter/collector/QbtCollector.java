package qbittorrent.exporter.collector;

import io.prometheus.client.Collector;
import io.prometheus.client.Gauge;
import qbittorrent.api.model.Torrent;

import java.util.ArrayList;
import java.util.List;

public class QbtCollector extends Collector implements QbtMetrics {

    private static final String GAUGE_NAME_PREFIX = "qbittorrent_";

    // region App Metrics

    private final Gauge appVersion = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_version")
        .labelNames("version")
        .help("The current qBittorrent version")
        .create();

    private final Gauge appMaxActiveDownloads = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_max_active_downloads")
        .help("The max number of downloads allowed")
        .create();

    private final Gauge appMaxActiveUploads = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_max_active_uploads")
        .help("The max number of active uploads allowed")
        .create();

    private final Gauge appMaxActiveTorrents = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_max_active_torrents")
        .help("The max number of active torrents allowed")
        .create();

    private final Gauge appDownloadRateLimitBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_download_rate_limit_bytes")
        .help("The global download rate limit (in bytes)")
        .create();

    private final Gauge appUploadRateLimitBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_upload_rate_limit_bytes")
        .help("The global upload rate limit (in bytes)")
        .create();

    private final Gauge appAlternateDownloadRateLimitBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_alt_download_rate_limit_bytes")
        .help("The alternate download rate limit (in bytes)")
        .create();

    private final Gauge appAlternateUploadRateLimitBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_alt_upload_rate_limit_bytes")
        .help("The alternate upload rate limit (in bytes)")
        .create();

    private final Gauge appAlternateRateLimitsEnabled = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_alt_rate_limits_enabled")
        .help("If alternate rate limits are enabled")
        .create();

    // endregion

    // region Torrent Metrics

    private final Gauge torrentDownloadSpeedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_download_speed_bytes")
        .labelNames("name")
        .help("The current download speed of torrents (in bytes)")
        .create();

    private final Gauge torrentUploadSpeedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_upload_speed_bytes")
        .labelNames("name")
        .help("The current upload speed of torrents (in bytes)")
        .create();

    private final Gauge torrentEta = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_eta")
        .labelNames("name")
        .help("The current ETA for each torrent (in seconds)")
        .create();

    private final Gauge torrentProgress = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_progress")
        .labelNames("name")
        .help("The current progress of torrents")
        .create();

    private final Gauge torrentTimeActive = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_time_active")
        .labelNames("name")
        .help("The total active time (in seconds)")
        .create();

    private final Gauge torrentStates = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_states")
        .labelNames("name")
        .help("The current state of torrents")
        .create();

    private final Gauge torrentSeeders = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_seeders")
        .labelNames("name")
        .help("The current number of seeders for each torrent")
        .create();

    private final Gauge torrentLeechers = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_leechers")
        .labelNames("name")
        .help("The current number of leechers for each torrent")
        .create();

    private final Gauge torrentRatio = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_ratio")
        .labelNames("name")
        .help("The current ratio each torrent")
        .create();

    private final Gauge torrentAmountLeftBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_amount_left_bytes")
        .labelNames("name")
        .help("The amount remaining for each torrent (in bytes)")
        .create();

    private final Gauge torrentSizeBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_size_bytes")
        .labelNames("name")
        .help("The size for each torrent (in bytes)")
        .create();

    private final Gauge torrentInfo = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_info")
        .labelNames(
            "name",
            "state",
            "size",
            "progress",
            "seeders",
            "leechers",
            "dl_speed",
            "up_speed",
            "amount_left",
            "time_active",
            "eta",
            "uploaded",
            "uploaded_session",
            "downloaded",
            "downloaded_session",
            "max_ratio",
            "ratio"
        )
        .help("All info for torrents")
        .create();

    private final Gauge torrentSessionUploadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_session_uploaded_bytes")
        .labelNames("name")
        .help("The current session upload amount of torrents (in bytes)")
        .create();

    private final Gauge torrentSessionDownloadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_session_downloaded_bytes")
        .labelNames("name")
        .help("The current session download amount of torrents (in bytes)")
        .create();

    private final Gauge torrentTotalDownloadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_total_downloaded_bytes")
        .labelNames("name")
        .help("The current total download amount of torrents (in bytes)")
        .create();

    private final Gauge torrentTotalUploadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "torrent_total_uploaded_bytes")
        .labelNames("name")
        .help("The current total upload amount of torrents (in bytes)")
        .create();

    // endregion

    // region Global Metrics

    private final Gauge globalAlltimeDownloadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_alltime_downloaded_bytes")
        .help("The all-time total download amount of torrents (in bytes)")
        .create();

    private final Gauge globalAlltimeUploadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_alltime_uploaded_bytes")
        .help("The all-time total upload amount of torrents (in bytes)")
        .create();

    private final Gauge globalSessionDownloadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_session_downloaded_bytes")
        .help("The total download amount of torrents for this session (in bytes)")
        .create();

    private final Gauge globalSessionUploadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_session_uploaded_bytes")
        .help("The total upload amount of torrents for this session (in bytes)")
        .create();

    private final Gauge globalDownloadSpeedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_download_speed_bytes")
        .help("The current download speed of all torrents (in bytes)")
        .create();

    private final Gauge globalUploadSpeedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_upload_speed_bytes")
        .help("The total current upload speed of all torrents (in bytes)")
        .create();

    private final Gauge globalRatio = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_ratio")
        .help("The current global ratio of all torrents")
        .create();

    private final Gauge totalTorrents = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "global_torrents")
        .help("The total number of torrents")
        .create();

    // endregion

    private List<Gauge> getMetrics() {
        return List.of(
            appVersion,
            torrentDownloadSpeedBytes,
            torrentUploadSpeedBytes,
            torrentEta,
            torrentProgress,
            torrentTimeActive,
            torrentStates,
            torrentSeeders,
            torrentLeechers,
            torrentRatio,
            torrentAmountLeftBytes,
            torrentSizeBytes,
            torrentInfo,
            torrentSessionDownloadedBytes,
            torrentSessionUploadedBytes,
            torrentTotalDownloadedBytes,
            torrentTotalUploadedBytes,
            appMaxActiveDownloads,
            appMaxActiveUploads,
            appMaxActiveTorrents,
            appDownloadRateLimitBytes,
            appUploadRateLimitBytes,
            appAlternateDownloadRateLimitBytes,
            appAlternateUploadRateLimitBytes,
            appAlternateRateLimitsEnabled,
            globalAlltimeDownloadedBytes,
            globalAlltimeUploadedBytes,
            globalSessionDownloadedBytes,
            globalSessionUploadedBytes,
            globalDownloadSpeedBytes,
            globalUploadSpeedBytes,
            globalRatio,
            totalTorrents
        );
    }

    // region QbtMetrics methods

    @Override
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> samples = new ArrayList<>();
        for (Gauge gauge : getMetrics()) {
            samples.addAll(gauge.collect());
        }
        return samples;
    }

    @Override
    public void clear() {
        for (Gauge gauge : getMetrics()) {
            gauge.clear();
        }
    }

    @Override
    public void setAppVersion(String version) {
        appVersion.labels(version).set(1);
    }

    @Override
    public void setTorrentDownloadSpeedBytes(String name, double value) {
        torrentDownloadSpeedBytes.labels(name).set(value);
    }

    @Override
    public void setTorrentUploadSpeedBytes(String name, double value) {
        torrentUploadSpeedBytes.labels(name).set(value);
    }

    @Override
    public void setTorrentEta(String name, double value) {
        torrentEta.labels(name).set(value);
    }

    @Override
    public void setTorrentProgress(String name, double value) {
        torrentProgress.labels(name).set(value);
    }

    @Override
    public void setTorrentTimeActive(String name, double value) {
        torrentTimeActive.labels(name).set(value);
    }

    @Override
    public void setTorrentStates(String name, long value) {
        torrentStates.labels(name).set(value);
    }

    @Override
    public void setTorrentSeeders(String name, int value) {
        torrentSeeders.labels(name).set(value);
    }

    @Override
    public void setTorrentLeechers(String name, int value) {
        torrentLeechers.labels(name).set(value);
    }

    @Override
    public void setTorrentRatio(String name, double value) {
        torrentRatio.labels(name).set(value);
    }

    @Override
    public void setTorrentAmountLeftBytes(String name, double value) {
        torrentAmountLeftBytes.labels(name).set(value);
    }

    @Override
    public void setTorrentSizeBytes(String name, double value) {
        torrentSizeBytes.labels(name).set(value);
    }

    @Override
    public void setTorrentInfo(Torrent torrent) {
        torrentInfo.labels(
            torrent.getName(),
            torrent.getState(),
            String.valueOf(torrent.getSize()),
            String.valueOf(torrent.getProgress()),
            String.valueOf(torrent.getNumSeeds()),
            String.valueOf(torrent.getNumLeechs()),
            String.valueOf(torrent.getDownloadSpeed()),
            String.valueOf(torrent.getUploadSpeed()),
            String.valueOf(torrent.getAmountLeft()),
            String.valueOf(torrent.getTimeActive()),
            String.valueOf(torrent.getEta()),
            String.valueOf(torrent.getUploaded()),
            String.valueOf(torrent.getUploadedSession()),
            String.valueOf(torrent.getDownloaded()),
            String.valueOf(torrent.getDownloadedSession()),
            String.valueOf(torrent.getMaxRatio()),
            String.valueOf(torrent.getRatio())
        ).set(1);
    }

    @Override
    public void setTorrentSessionDownloadedBytes(String name, double value) {
        torrentSessionDownloadedBytes.labels(name).set(value);
    }

    @Override
    public void setTorrentSessionUploadedBytes(String name, double value) {
        torrentSessionUploadedBytes.labels(name).set(value);
    }

    @Override
    public void setTorrentTotalDownloadedBytes(String name, double value) {
        torrentTotalDownloadedBytes.labels(name).set(value);
    }

    @Override
    public void setTorrentTotalUploadedBytes(String name, double value) {
        torrentTotalUploadedBytes.labels(name).set(value);
    }

    @Override
    public void setTotalTorrents(int value) {
        totalTorrents.set(value);
    }

    @Override
    public void setAppMaxActiveDownloads(double value) {
        appMaxActiveDownloads.set(value);
    }

    @Override
    public void setAppMaxActiveUploads(double value) {
        appMaxActiveUploads.set(value);
    }

    @Override
    public void setAppMaxActiveTorrents(double value) {
        appMaxActiveTorrents.set(value);
    }

    @Override
    public void setAppDownloadRateLimitBytes(double value) {
        appDownloadRateLimitBytes.set(value);
    }

    @Override
    public void setAppUploadRateLimitBytes(double value) {
        appUploadRateLimitBytes.set(value);
    }

    @Override
    public void setAppAlternateDownloadRateLimitBytes(double value) {
        appAlternateDownloadRateLimitBytes.set(value);
    }

    @Override
    public void setAppAlternateUploadRateLimitBytes(double value) {
        appAlternateUploadRateLimitBytes.set(value);
    }

    @Override
    public void setAppAlternateRateLimitsEnabled(boolean enabled) {
        appAlternateRateLimitsEnabled.set(enabled ? 1 : 0);
    }

    @Override
    public void setGlobalAlltimeDownloadedBytes(double value) {
        globalAlltimeDownloadedBytes.set(value);
    }

    @Override
    public void setGlobalAlltimeUploadedBytes(double value) {
        globalAlltimeUploadedBytes.set(value);
    }

    @Override
    public void setGlobalSessionDownloadedBytes(double value) {
        globalSessionDownloadedBytes.set(value);
    }

    @Override
    public void setGlobalSessionUploadedBytes(double value) {
        globalSessionUploadedBytes.set(value);
    }

    @Override
    public void setGlobalDownloadSpeedBytes(double value) {
        globalDownloadSpeedBytes.set(value);
    }

    @Override
    public void setGlobalUploadSpeedBytes(double value) {
        globalUploadSpeedBytes.set(value);
    }

    @Override
    public void setGlobalRatio(double value) {
        globalRatio.set(value);
    }

    // endregion
}
