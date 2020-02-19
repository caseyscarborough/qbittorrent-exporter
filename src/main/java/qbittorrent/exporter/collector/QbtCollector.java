package qbittorrent.exporter.collector;

import io.prometheus.client.Collector;
import io.prometheus.client.Gauge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbittorrent.api.model.Torrent;

import java.util.ArrayList;
import java.util.List;

public class QbtCollector extends Collector implements QbtMetrics {

    private static final Logger LOGGER = LoggerFactory.getLogger(QbtCollector.class);
    private static final String GAUGE_NAME_PREFIX = "qbittorrent_";

    // region App Metrics

    private final Gauge appVersion = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "app_version")
        .labelNames("version")
        .help("The current qBittorrent version")
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
        // Labels are named this way for displaying them in a table with Grafana.
        // Columns can't be ordered and are ordered by name when using Prometheus
        // as a datasource. You can override the column names in the table Column
        // Style configuration.
        // see https://github.com/grafana/grafana/issues/5082
        .labelNames("_01_name", "_08_state", "_07_size", "_02_progress", "_05_seeders", "_06_leechers", "_03_dl_speed", "_04_up_speed", "_09_amount_left", "_10_time_active")
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

    // region Total Metrics

    private final Gauge totalDownloadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "total_downloaded_bytes")
        .help("The current total download amount of torrents (in bytes)")
        .create();

    private final Gauge totalUploadedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "total_uploaded_bytes")
        .help("The current total upload amount of torrents (in bytes)")
        .create();

    private final Gauge totalDownloadSpeedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "total_download_speed_bytes")
        .help("The total current download speed of all torrents (in bytes)")
        .create();

    private final Gauge totalUploadSpeedBytes = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "total_upload_speed_bytes")
        .help("The total current upload speed of all torrents (in bytes)")
        .create();

    private final Gauge totalTorrents = Gauge.build()
        .name(GAUGE_NAME_PREFIX + "total_torrents")
        .help("The total number of torrents")
        .create();

    // endregion

    private List<Gauge> getMetrics() {
        List<Gauge> output = new ArrayList<>();
        output.add(appVersion);
        output.add(torrentDownloadSpeedBytes);
        output.add(torrentUploadSpeedBytes);
        output.add(torrentProgress);
        output.add(torrentTimeActive);
        output.add(torrentStates);
        output.add(torrentSeeders);
        output.add(torrentLeechers);
        output.add(torrentRatio);
        output.add(torrentAmountLeftBytes);
        output.add(torrentSizeBytes);
        output.add(torrentInfo);
        output.add(torrentSessionDownloadedBytes);
        output.add(torrentSessionUploadedBytes);
        output.add(torrentTotalDownloadedBytes);
        output.add(torrentTotalUploadedBytes);
        output.add(totalDownloadedBytes);
        output.add(totalUploadedBytes);
        output.add(totalDownloadSpeedBytes);
        output.add(totalUploadSpeedBytes);
        output.add(totalTorrents);
        return output;
    }

    @Override
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> mfs = new ArrayList<>();
        for (Gauge gauge : getMetrics()) {
            mfs.addAll(gauge.collect());
        }
        return mfs;
    }

    // region QbtMetrics methods

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
            String.valueOf(torrent.getTimeActive())).set(1);
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
    public void setTotalDownloadedBytes(double value) {
        totalDownloadedBytes.set(value);
    }

    @Override
    public void setTotalUploadedBytes(double value) {
        totalUploadedBytes.set(value);
    }

    @Override
    public void setTotalDownloadSpeedBytes(double value) {
        totalDownloadSpeedBytes.set(value);
    }

    @Override
    public void setTotalUploadSpeedBytes(double value) {
        totalUploadSpeedBytes.set(value);
    }

    @Override
    public void setTotalTorrents(int value) {
        totalTorrents.set(value);
    }

    // endregion
}
