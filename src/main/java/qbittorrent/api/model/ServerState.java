package qbittorrent.api.model;

import com.google.gson.annotations.SerializedName;

public class ServerState {

    @SerializedName("refresh_interval")
    private long refreshInterval;

    @SerializedName("dht_nodes")
    private long dhtNodes;

    @SerializedName("total_peer_connections")
    private long totalPeerConnections;

    @SerializedName("average_time_queue")
    private long averageTimeQueue;

    @SerializedName("free_space_on_disk")
    private long freeSpaceOnDisk;

    @SerializedName("total_queued_size")
    private long totalQueuedSize;

    @SerializedName("dl_info_data")
    private long dlInfoData;

    @SerializedName("queueing")
    private boolean queueing;

    @SerializedName("connection_status")
    private String connectionStatus;

    @SerializedName("alltime_ul")
    private long alltimeUl;

    @SerializedName("up_info_speed")
    private long upInfoSpeed;

    @SerializedName("read_cache_overload")
    private String readCacheOverload;

    @SerializedName("global_ratio")
    private String globalRatio;

    @SerializedName("dl_rate_limit")
    private long dlRateLimit;

    @SerializedName("write_cache_overload")
    private String writeCacheOverload;

    @SerializedName("queued_io_jobs")
    private long queuedIoJobs;

    @SerializedName("total_buffers_size")
    private long totalBuffersSize;

    @SerializedName("read_cache_hits")
    private String readCacheHits;

    @SerializedName("use_alt_speed_limits")
    private boolean useAltSpeedLimits;

    @SerializedName("up_info_data")
    private long upInfoData;

    @SerializedName("total_wasted_session")
    private long totalWastedSession;

    @SerializedName("up_rate_limit")
    private long upRateLimit;

    @SerializedName("alltime_dl")
    private long alltimeDl;

    @SerializedName("dl_info_speed")
    private long dlInfoSpeed;

    public long getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(long refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public long getDhtNodes() {
        return dhtNodes;
    }

    public void setDhtNodes(long dhtNodes) {
        this.dhtNodes = dhtNodes;
    }

    public long getTotalPeerConnections() {
        return totalPeerConnections;
    }

    public void setTotalPeerConnections(long totalPeerConnections) {
        this.totalPeerConnections = totalPeerConnections;
    }

    public long getAverageTimeQueue() {
        return averageTimeQueue;
    }

    public void setAverageTimeQueue(long averageTimeQueue) {
        this.averageTimeQueue = averageTimeQueue;
    }

    public long getFreeSpaceOnDisk() {
        return freeSpaceOnDisk;
    }

    public void setFreeSpaceOnDisk(long freeSpaceOnDisk) {
        this.freeSpaceOnDisk = freeSpaceOnDisk;
    }

    public long getTotalQueuedSize() {
        return totalQueuedSize;
    }

    public void setTotalQueuedSize(long totalQueuedSize) {
        this.totalQueuedSize = totalQueuedSize;
    }

    public long getDlInfoData() {
        return dlInfoData;
    }

    public void setDlInfoData(long dlInfoData) {
        this.dlInfoData = dlInfoData;
    }

    public boolean isQueueing() {
        return queueing;
    }

    public void setQueueing(boolean queueing) {
        this.queueing = queueing;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public long getAlltimeUl() {
        return alltimeUl;
    }

    public void setAlltimeUl(long alltimeUl) {
        this.alltimeUl = alltimeUl;
    }

    public long getUpInfoSpeed() {
        return upInfoSpeed;
    }

    public void setUpInfoSpeed(long upInfoSpeed) {
        this.upInfoSpeed = upInfoSpeed;
    }

    public String getReadCacheOverload() {
        return readCacheOverload;
    }

    public void setReadCacheOverload(String readCacheOverload) {
        this.readCacheOverload = readCacheOverload;
    }

    public String getGlobalRatio() {
        return globalRatio;
    }

    public void setGlobalRatio(String globalRatio) {
        this.globalRatio = globalRatio;
    }

    public long getDlRateLimit() {
        return dlRateLimit;
    }

    public void setDlRateLimit(long dlRateLimit) {
        this.dlRateLimit = dlRateLimit;
    }

    public String getWriteCacheOverload() {
        return writeCacheOverload;
    }

    public void setWriteCacheOverload(String writeCacheOverload) {
        this.writeCacheOverload = writeCacheOverload;
    }

    public long getQueuedIoJobs() {
        return queuedIoJobs;
    }

    public void setQueuedIoJobs(long queuedIoJobs) {
        this.queuedIoJobs = queuedIoJobs;
    }

    public long getTotalBuffersSize() {
        return totalBuffersSize;
    }

    public void setTotalBuffersSize(long totalBuffersSize) {
        this.totalBuffersSize = totalBuffersSize;
    }

    public String getReadCacheHits() {
        return readCacheHits;
    }

    public void setReadCacheHits(String readCacheHits) {
        this.readCacheHits = readCacheHits;
    }

    public boolean isUseAltSpeedLimits() {
        return useAltSpeedLimits;
    }

    public void setUseAltSpeedLimits(boolean useAltSpeedLimits) {
        this.useAltSpeedLimits = useAltSpeedLimits;
    }

    public long getUpInfoData() {
        return upInfoData;
    }

    public void setUpInfoData(long upInfoData) {
        this.upInfoData = upInfoData;
    }

    public long getTotalWastedSession() {
        return totalWastedSession;
    }

    public void setTotalWastedSession(long totalWastedSession) {
        this.totalWastedSession = totalWastedSession;
    }

    public long getUpRateLimit() {
        return upRateLimit;
    }

    public void setUpRateLimit(long upRateLimit) {
        this.upRateLimit = upRateLimit;
    }

    public long getAlltimeDl() {
        return alltimeDl;
    }

    public void setAlltimeDl(long alltimeDl) {
        this.alltimeDl = alltimeDl;
    }

    public long getDlInfoSpeed() {
        return dlInfoSpeed;
    }

    public void setDlInfoSpeed(long dlInfoSpeed) {
        this.dlInfoSpeed = dlInfoSpeed;
    }

    @Override
    public String toString() {
        return
            "ServerState{" +
                "refresh_interval = '" + refreshInterval + '\'' +
                ",dht_nodes = '" + dhtNodes + '\'' +
                ",total_peer_connections = '" + totalPeerConnections + '\'' +
                ",average_time_queue = '" + averageTimeQueue + '\'' +
                ",free_space_on_disk = '" + freeSpaceOnDisk + '\'' +
                ",total_queued_size = '" + totalQueuedSize + '\'' +
                ",dl_info_data = '" + dlInfoData + '\'' +
                ",queueing = '" + queueing + '\'' +
                ",connection_status = '" + connectionStatus + '\'' +
                ",alltime_ul = '" + alltimeUl + '\'' +
                ",up_info_speed = '" + upInfoSpeed + '\'' +
                ",read_cache_overload = '" + readCacheOverload + '\'' +
                ",global_ratio = '" + globalRatio + '\'' +
                ",dl_rate_limit = '" + dlRateLimit + '\'' +
                ",write_cache_overload = '" + writeCacheOverload + '\'' +
                ",queued_io_jobs = '" + queuedIoJobs + '\'' +
                ",total_buffers_size = '" + totalBuffersSize + '\'' +
                ",read_cache_hits = '" + readCacheHits + '\'' +
                ",use_alt_speed_limits = '" + useAltSpeedLimits + '\'' +
                ",up_info_data = '" + upInfoData + '\'' +
                ",total_wasted_session = '" + totalWastedSession + '\'' +
                ",up_rate_limit = '" + upRateLimit + '\'' +
                ",alltime_dl = '" + alltimeDl + '\'' +
                ",dl_info_speed = '" + dlInfoSpeed + '\'' +
                "}";
    }
}
