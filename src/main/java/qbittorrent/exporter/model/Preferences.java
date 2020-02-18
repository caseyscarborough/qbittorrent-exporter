package qbittorrent.exporter.model;

import com.google.gson.annotations.SerializedName;

public class Preferences {

    @SerializedName("embedded_tracker_port")
    private int embeddedTrackerPort;

    @SerializedName("limit_lan_peers")
    private boolean limitLanPeers;

    @SerializedName("max_ratio_enabled")
    private boolean maxRatioEnabled;

    @SerializedName("web_ui_domain_list")
    private String webUiDomainList;

    @SerializedName("proxy_password")
    private String proxyPassword;

    @SerializedName("alternative_webui_path")
    private String alternativeWebuiPath;

    @SerializedName("announce_to_all_trackers")
    private boolean announceToAllTrackers;

    @SerializedName("send_buffer_watermark")
    private int sendBufferWatermark;

    @SerializedName("torrent_changed_tmm_enabled")
    private boolean torrentChangedTmmEnabled;

    @SerializedName("dl_limit")
    private int dlLimit;

    @SerializedName("autorun_program")
    private String autorunProgram;

    @SerializedName("async_io_threads")
    private int asyncIoThreads;

    @SerializedName("resolve_peer_countries")
    private boolean resolvePeerCountries;

    @SerializedName("web_ui_clickjacking_protection_enabled")
    private boolean webUiClickjackingProtectionEnabled;

    @SerializedName("bypass_auth_subnet_whitelist_enabled")
    private boolean bypassAuthSubnetWhitelistEnabled;

    @SerializedName("rss_auto_downloading_enabled")
    private boolean rssAutoDownloadingEnabled;

    @SerializedName("temp_path_enabled")
    private boolean tempPathEnabled;

    @SerializedName("pex")
    private boolean pex;

    @SerializedName("incomplete_files_ext")
    private boolean incompleteFilesExt;

    @SerializedName("send_buffer_low_watermark")
    private int sendBufferLowWatermark;

    @SerializedName("preallocate_all")
    private boolean preallocateAll;

    @SerializedName("dyndns_username")
    private String dyndnsUsername;

    @SerializedName("current_network_interface")
    private String currentNetworkInterface;

    @SerializedName("autorun_enabled")
    private boolean autorunEnabled;

    @SerializedName("scheduler_days")
    private int schedulerDays;

    @SerializedName("limit_tcp_overhead")
    private boolean limitTcpOverhead;

    @SerializedName("mail_notification_ssl_enabled")
    private boolean mailNotificationSslEnabled;

    @SerializedName("proxy_peer_connections")
    private boolean proxyPeerConnections;

    @SerializedName("dyndns_enabled")
    private boolean dyndnsEnabled;

    @SerializedName("enable_super_seeding")
    private boolean enableSuperSeeding;

    @SerializedName("random_port")
    private boolean randomPort;

    @SerializedName("anonymous_mode")
    private boolean anonymousMode;

    @SerializedName("rss_max_articles_per_feed")
    private int rssMaxArticlesPerFeed;

    @SerializedName("ip_filter_enabled")
    private boolean ipFilterEnabled;

    @SerializedName("mail_notification_smtp")
    private String mailNotificationSmtp;

    @SerializedName("web_ui_https_cert_path")
    private String webUiHttpsCertPath;

    @SerializedName("enable_coalesce_read_write")
    private boolean enableCoalesceReadWrite;

    @SerializedName("banned_IPs")
    private String bannedIPs;

    @SerializedName("schedule_to_hour")
    private int scheduleToHour;

    @SerializedName("rss_processing_enabled")
    private boolean rssProcessingEnabled;

    @SerializedName("save_path")
    private String savePath;

    @SerializedName("save_path_changed_tmm_enabled")
    private boolean savePathChangedTmmEnabled;

    @SerializedName("encryption")
    private int encryption;

    @SerializedName("proxy_auth_enabled")
    private boolean proxyAuthEnabled;

    @SerializedName("ip_filter_path")
    private String ipFilterPath;

    @SerializedName("web_ui_csrf_protection_enabled")
    private boolean webUiCsrfProtectionEnabled;

    @SerializedName("max_ratio_act")
    private int maxRatioAct;

    @SerializedName("mail_notification_email")
    private String mailNotificationEmail;

    @SerializedName("proxy_username")
    private String proxyUsername;

    @SerializedName("web_ui_address")
    private String webUiAddress;

    @SerializedName("max_connec")
    private int maxConnec;

    @SerializedName("announce_ip")
    private String announceIp;

    @SerializedName("export_dir_fin")
    private String exportDirFin;

    @SerializedName("add_trackers")
    private String addTrackers;

    @SerializedName("dht")
    private boolean dht;

    @SerializedName("send_buffer_watermark_factor")
    private int sendBufferWatermarkFactor;

    @SerializedName("web_ui_username")
    private String webUiUsername;

    @SerializedName("current_interface_address")
    private String currentInterfaceAddress;

    @SerializedName("slow_torrent_dl_rate_threshold")
    private int slowTorrentDlRateThreshold;

    @SerializedName("max_seeding_time")
    private int maxSeedingTime;

    @SerializedName("web_ui_host_header_validation_enabled")
    private boolean webUiHostHeaderValidationEnabled;

    @SerializedName("dont_count_slow_torrents")
    private boolean dontCountSlowTorrents;

    @SerializedName("schedule_from_hour")
    private int scheduleFromHour;

    @SerializedName("use_https")
    private boolean useHttps;

    @SerializedName("proxy_type")
    private int proxyType;

    @SerializedName("disk_cache")
    private int diskCache;

    @SerializedName("max_ratio")
    private int maxRatio;

    @SerializedName("rss_refresh_interval")
    private int rssRefreshInterval;

    @SerializedName("web_ui_port")
    private int webUiPort;

    @SerializedName("upload_slots_behavior")
    private int uploadSlotsBehavior;

    @SerializedName("limit_utp_rate")
    private boolean limitUtpRate;

    @SerializedName("bittorrent_protocol")
    private int bittorrentProtocol;

    @SerializedName("disk_cache_ttl")
    private int diskCacheTtl;

    @SerializedName("dyndns_password")
    private String dyndnsPassword;

    @SerializedName("bypass_local_auth")
    private boolean bypassLocalAuth;

    @SerializedName("upload_choking_algorithm")
    private int uploadChokingAlgorithm;

    @SerializedName("enable_os_cache")
    private boolean enableOsCache;

    @SerializedName("ip_filter_trackers")
    private boolean ipFilterTrackers;

    @SerializedName("schedule_from_min")
    private int scheduleFromMin;

    @SerializedName("queueing_enabled")
    private boolean queueingEnabled;

    @SerializedName("category_changed_tmm_enabled")
    private boolean categoryChangedTmmEnabled;

    @SerializedName("max_seeding_time_enabled")
    private boolean maxSeedingTimeEnabled;

    @SerializedName("max_uploads_per_torrent")
    private int maxUploadsPerTorrent;

    @SerializedName("socket_backlog_size")
    private int socketBacklogSize;

    @SerializedName("web_ui_upnp")
    private boolean webUiUpnp;

    @SerializedName("proxy_port")
    private int proxyPort;

    @SerializedName("bypass_auth_subnet_whitelist")
    private String bypassAuthSubnetWhitelist;

    @SerializedName("listen_port")
    private int listenPort;

    @SerializedName("mail_notification_sender")
    private String mailNotificationSender;

    @SerializedName("upnp")
    private boolean upnp;

    @SerializedName("create_subfolder_enabled")
    private boolean createSubfolderEnabled;

    @SerializedName("alt_up_limit")
    private int altUpLimit;

    @SerializedName("max_active_downloads")
    private int maxActiveDownloads;

    @SerializedName("slow_torrent_inactive_timer")
    private int slowTorrentInactiveTimer;

    @SerializedName("max_active_uploads")
    private int maxActiveUploads;

    @SerializedName("lsd")
    private boolean lsd;

    @SerializedName("utp_tcp_mixed_mode")
    private int utpTcpMixedMode;

    @SerializedName("auto_delete_mode")
    private int autoDeleteMode;

    @SerializedName("outgoing_ports_min")
    private int outgoingPortsMin;

    @SerializedName("slow_torrent_ul_rate_threshold")
    private int slowTorrentUlRateThreshold;

    @SerializedName("web_ui_https_key_path")
    private String webUiHttpsKeyPath;

    @SerializedName("enable_multi_connections_from_same_ip")
    private boolean enableMultiConnectionsFromSameIp;

    @SerializedName("proxy_torrents_only")
    private boolean proxyTorrentsOnly;

    @SerializedName("locale")
    private String locale;

    @SerializedName("alternative_webui_enabled")
    private boolean alternativeWebuiEnabled;

    @SerializedName("max_connec_per_torrent")
    private int maxConnecPerTorrent;

    @SerializedName("alt_dl_limit")
    private int altDlLimit;

    @SerializedName("recheck_completed_torrents")
    private boolean recheckCompletedTorrents;

    @SerializedName("enable_upload_suggestions")
    private boolean enableUploadSuggestions;

    @SerializedName("mail_notification_password")
    private String mailNotificationPassword;

    @SerializedName("save_resume_data_interval")
    private int saveResumeDataInterval;

    @SerializedName("schedule_to_min")
    private int scheduleToMin;

    @SerializedName("dyndns_service")
    private int dyndnsService;

    @SerializedName("dyndns_domain")
    private String dyndnsDomain;

    @SerializedName("temp_path")
    private String tempPath;

    @SerializedName("proxy_ip")
    private String proxyIp;

    @SerializedName("announce_to_all_tiers")
    private boolean announceToAllTiers;

    @SerializedName("max_uploads")
    private int maxUploads;

    @SerializedName("enable_embedded_tracker")
    private boolean enableEmbeddedTracker;

    @SerializedName("mail_notification_enabled")
    private boolean mailNotificationEnabled;

    @SerializedName("web_ui_session_timeout")
    private int webUiSessionTimeout;

    @SerializedName("file_pool_size")
    private int filePoolSize;

    @SerializedName("start_paused_enabled")
    private boolean startPausedEnabled;

    @SerializedName("add_trackers_enabled")
    private boolean addTrackersEnabled;

    @SerializedName("checking_memory_use")
    private int checkingMemoryUse;

    @SerializedName("mail_notification_auth_enabled")
    private boolean mailNotificationAuthEnabled;

    @SerializedName("up_limit")
    private int upLimit;

    @SerializedName("scheduler_enabled")
    private boolean schedulerEnabled;

    @SerializedName("auto_tmm_enabled")
    private boolean autoTmmEnabled;

    @SerializedName("outgoing_ports_max")
    private int outgoingPortsMax;

    @SerializedName("max_active_torrents")
    private int maxActiveTorrents;

    @SerializedName("mail_notification_username")
    private String mailNotificationUsername;

    @SerializedName("export_dir")
    private String exportDir;

    public int getEmbeddedTrackerPort() {
        return embeddedTrackerPort;
    }

    public void setEmbeddedTrackerPort(int embeddedTrackerPort) {
        this.embeddedTrackerPort = embeddedTrackerPort;
    }

    public boolean isLimitLanPeers() {
        return limitLanPeers;
    }

    public void setLimitLanPeers(boolean limitLanPeers) {
        this.limitLanPeers = limitLanPeers;
    }

    public boolean isMaxRatioEnabled() {
        return maxRatioEnabled;
    }

    public void setMaxRatioEnabled(boolean maxRatioEnabled) {
        this.maxRatioEnabled = maxRatioEnabled;
    }

    public String getWebUiDomainList() {
        return webUiDomainList;
    }

    public void setWebUiDomainList(String webUiDomainList) {
        this.webUiDomainList = webUiDomainList;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public String getAlternativeWebuiPath() {
        return alternativeWebuiPath;
    }

    public void setAlternativeWebuiPath(String alternativeWebuiPath) {
        this.alternativeWebuiPath = alternativeWebuiPath;
    }

    public boolean isAnnounceToAllTrackers() {
        return announceToAllTrackers;
    }

    public void setAnnounceToAllTrackers(boolean announceToAllTrackers) {
        this.announceToAllTrackers = announceToAllTrackers;
    }

    public int getSendBufferWatermark() {
        return sendBufferWatermark;
    }

    public void setSendBufferWatermark(int sendBufferWatermark) {
        this.sendBufferWatermark = sendBufferWatermark;
    }

    public boolean isTorrentChangedTmmEnabled() {
        return torrentChangedTmmEnabled;
    }

    public void setTorrentChangedTmmEnabled(boolean torrentChangedTmmEnabled) {
        this.torrentChangedTmmEnabled = torrentChangedTmmEnabled;
    }

    public int getDlLimit() {
        return dlLimit;
    }

    public void setDlLimit(int dlLimit) {
        this.dlLimit = dlLimit;
    }

    public String getAutorunProgram() {
        return autorunProgram;
    }

    public void setAutorunProgram(String autorunProgram) {
        this.autorunProgram = autorunProgram;
    }

    public int getAsyncIoThreads() {
        return asyncIoThreads;
    }

    public void setAsyncIoThreads(int asyncIoThreads) {
        this.asyncIoThreads = asyncIoThreads;
    }

    public boolean isResolvePeerCountries() {
        return resolvePeerCountries;
    }

    public void setResolvePeerCountries(boolean resolvePeerCountries) {
        this.resolvePeerCountries = resolvePeerCountries;
    }

    public boolean isWebUiClickjackingProtectionEnabled() {
        return webUiClickjackingProtectionEnabled;
    }

    public void setWebUiClickjackingProtectionEnabled(boolean webUiClickjackingProtectionEnabled) {
        this.webUiClickjackingProtectionEnabled = webUiClickjackingProtectionEnabled;
    }

    public boolean isBypassAuthSubnetWhitelistEnabled() {
        return bypassAuthSubnetWhitelistEnabled;
    }

    public void setBypassAuthSubnetWhitelistEnabled(boolean bypassAuthSubnetWhitelistEnabled) {
        this.bypassAuthSubnetWhitelistEnabled = bypassAuthSubnetWhitelistEnabled;
    }

    public boolean isRssAutoDownloadingEnabled() {
        return rssAutoDownloadingEnabled;
    }

    public void setRssAutoDownloadingEnabled(boolean rssAutoDownloadingEnabled) {
        this.rssAutoDownloadingEnabled = rssAutoDownloadingEnabled;
    }

    public boolean isTempPathEnabled() {
        return tempPathEnabled;
    }

    public void setTempPathEnabled(boolean tempPathEnabled) {
        this.tempPathEnabled = tempPathEnabled;
    }

    public boolean isPex() {
        return pex;
    }

    public void setPex(boolean pex) {
        this.pex = pex;
    }

    public boolean isIncompleteFilesExt() {
        return incompleteFilesExt;
    }

    public void setIncompleteFilesExt(boolean incompleteFilesExt) {
        this.incompleteFilesExt = incompleteFilesExt;
    }

    public int getSendBufferLowWatermark() {
        return sendBufferLowWatermark;
    }

    public void setSendBufferLowWatermark(int sendBufferLowWatermark) {
        this.sendBufferLowWatermark = sendBufferLowWatermark;
    }

    public boolean isPreallocateAll() {
        return preallocateAll;
    }

    public void setPreallocateAll(boolean preallocateAll) {
        this.preallocateAll = preallocateAll;
    }

    public String getDyndnsUsername() {
        return dyndnsUsername;
    }

    public void setDyndnsUsername(String dyndnsUsername) {
        this.dyndnsUsername = dyndnsUsername;
    }

    public String getCurrentNetworkInterface() {
        return currentNetworkInterface;
    }

    public void setCurrentNetworkInterface(String currentNetworkInterface) {
        this.currentNetworkInterface = currentNetworkInterface;
    }

    public boolean isAutorunEnabled() {
        return autorunEnabled;
    }

    public void setAutorunEnabled(boolean autorunEnabled) {
        this.autorunEnabled = autorunEnabled;
    }

    public int getSchedulerDays() {
        return schedulerDays;
    }

    public void setSchedulerDays(int schedulerDays) {
        this.schedulerDays = schedulerDays;
    }

    public boolean isLimitTcpOverhead() {
        return limitTcpOverhead;
    }

    public void setLimitTcpOverhead(boolean limitTcpOverhead) {
        this.limitTcpOverhead = limitTcpOverhead;
    }

    public boolean isMailNotificationSslEnabled() {
        return mailNotificationSslEnabled;
    }

    public void setMailNotificationSslEnabled(boolean mailNotificationSslEnabled) {
        this.mailNotificationSslEnabled = mailNotificationSslEnabled;
    }

    public boolean isProxyPeerConnections() {
        return proxyPeerConnections;
    }

    public void setProxyPeerConnections(boolean proxyPeerConnections) {
        this.proxyPeerConnections = proxyPeerConnections;
    }

    public boolean isDyndnsEnabled() {
        return dyndnsEnabled;
    }

    public void setDyndnsEnabled(boolean dyndnsEnabled) {
        this.dyndnsEnabled = dyndnsEnabled;
    }

    public boolean isEnableSuperSeeding() {
        return enableSuperSeeding;
    }

    public void setEnableSuperSeeding(boolean enableSuperSeeding) {
        this.enableSuperSeeding = enableSuperSeeding;
    }

    public boolean isRandomPort() {
        return randomPort;
    }

    public void setRandomPort(boolean randomPort) {
        this.randomPort = randomPort;
    }

    public boolean isAnonymousMode() {
        return anonymousMode;
    }

    public void setAnonymousMode(boolean anonymousMode) {
        this.anonymousMode = anonymousMode;
    }

    public int getRssMaxArticlesPerFeed() {
        return rssMaxArticlesPerFeed;
    }

    public void setRssMaxArticlesPerFeed(int rssMaxArticlesPerFeed) {
        this.rssMaxArticlesPerFeed = rssMaxArticlesPerFeed;
    }

    public boolean isIpFilterEnabled() {
        return ipFilterEnabled;
    }

    public void setIpFilterEnabled(boolean ipFilterEnabled) {
        this.ipFilterEnabled = ipFilterEnabled;
    }

    public String getMailNotificationSmtp() {
        return mailNotificationSmtp;
    }

    public void setMailNotificationSmtp(String mailNotificationSmtp) {
        this.mailNotificationSmtp = mailNotificationSmtp;
    }

    public String getWebUiHttpsCertPath() {
        return webUiHttpsCertPath;
    }

    public void setWebUiHttpsCertPath(String webUiHttpsCertPath) {
        this.webUiHttpsCertPath = webUiHttpsCertPath;
    }

    public boolean isEnableCoalesceReadWrite() {
        return enableCoalesceReadWrite;
    }

    public void setEnableCoalesceReadWrite(boolean enableCoalesceReadWrite) {
        this.enableCoalesceReadWrite = enableCoalesceReadWrite;
    }

    public String getBannedIPs() {
        return bannedIPs;
    }

    public void setBannedIPs(String bannedIPs) {
        this.bannedIPs = bannedIPs;
    }

    public int getScheduleToHour() {
        return scheduleToHour;
    }

    public void setScheduleToHour(int scheduleToHour) {
        this.scheduleToHour = scheduleToHour;
    }

    public boolean isRssProcessingEnabled() {
        return rssProcessingEnabled;
    }

    public void setRssProcessingEnabled(boolean rssProcessingEnabled) {
        this.rssProcessingEnabled = rssProcessingEnabled;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public boolean isSavePathChangedTmmEnabled() {
        return savePathChangedTmmEnabled;
    }

    public void setSavePathChangedTmmEnabled(boolean savePathChangedTmmEnabled) {
        this.savePathChangedTmmEnabled = savePathChangedTmmEnabled;
    }

    public int getEncryption() {
        return encryption;
    }

    public void setEncryption(int encryption) {
        this.encryption = encryption;
    }

    public boolean isProxyAuthEnabled() {
        return proxyAuthEnabled;
    }

    public void setProxyAuthEnabled(boolean proxyAuthEnabled) {
        this.proxyAuthEnabled = proxyAuthEnabled;
    }

    public String getIpFilterPath() {
        return ipFilterPath;
    }

    public void setIpFilterPath(String ipFilterPath) {
        this.ipFilterPath = ipFilterPath;
    }

    public boolean isWebUiCsrfProtectionEnabled() {
        return webUiCsrfProtectionEnabled;
    }

    public void setWebUiCsrfProtectionEnabled(boolean webUiCsrfProtectionEnabled) {
        this.webUiCsrfProtectionEnabled = webUiCsrfProtectionEnabled;
    }

    public int getMaxRatioAct() {
        return maxRatioAct;
    }

    public void setMaxRatioAct(int maxRatioAct) {
        this.maxRatioAct = maxRatioAct;
    }

    public String getMailNotificationEmail() {
        return mailNotificationEmail;
    }

    public void setMailNotificationEmail(String mailNotificationEmail) {
        this.mailNotificationEmail = mailNotificationEmail;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    public String getWebUiAddress() {
        return webUiAddress;
    }

    public void setWebUiAddress(String webUiAddress) {
        this.webUiAddress = webUiAddress;
    }

    public int getMaxConnec() {
        return maxConnec;
    }

    public void setMaxConnec(int maxConnec) {
        this.maxConnec = maxConnec;
    }

    public String getAnnounceIp() {
        return announceIp;
    }

    public void setAnnounceIp(String announceIp) {
        this.announceIp = announceIp;
    }

    public String getExportDirFin() {
        return exportDirFin;
    }

    public void setExportDirFin(String exportDirFin) {
        this.exportDirFin = exportDirFin;
    }

    public String getAddTrackers() {
        return addTrackers;
    }

    public void setAddTrackers(String addTrackers) {
        this.addTrackers = addTrackers;
    }

    public boolean isDht() {
        return dht;
    }

    public void setDht(boolean dht) {
        this.dht = dht;
    }

    public int getSendBufferWatermarkFactor() {
        return sendBufferWatermarkFactor;
    }

    public void setSendBufferWatermarkFactor(int sendBufferWatermarkFactor) {
        this.sendBufferWatermarkFactor = sendBufferWatermarkFactor;
    }

    public String getWebUiUsername() {
        return webUiUsername;
    }

    public void setWebUiUsername(String webUiUsername) {
        this.webUiUsername = webUiUsername;
    }

    public String getCurrentInterfaceAddress() {
        return currentInterfaceAddress;
    }

    public void setCurrentInterfaceAddress(String currentInterfaceAddress) {
        this.currentInterfaceAddress = currentInterfaceAddress;
    }

    public int getSlowTorrentDlRateThreshold() {
        return slowTorrentDlRateThreshold;
    }

    public void setSlowTorrentDlRateThreshold(int slowTorrentDlRateThreshold) {
        this.slowTorrentDlRateThreshold = slowTorrentDlRateThreshold;
    }

    public int getMaxSeedingTime() {
        return maxSeedingTime;
    }

    public void setMaxSeedingTime(int maxSeedingTime) {
        this.maxSeedingTime = maxSeedingTime;
    }

    public boolean isWebUiHostHeaderValidationEnabled() {
        return webUiHostHeaderValidationEnabled;
    }

    public void setWebUiHostHeaderValidationEnabled(boolean webUiHostHeaderValidationEnabled) {
        this.webUiHostHeaderValidationEnabled = webUiHostHeaderValidationEnabled;
    }

    public boolean isDontCountSlowTorrents() {
        return dontCountSlowTorrents;
    }

    public void setDontCountSlowTorrents(boolean dontCountSlowTorrents) {
        this.dontCountSlowTorrents = dontCountSlowTorrents;
    }

    public int getScheduleFromHour() {
        return scheduleFromHour;
    }

    public void setScheduleFromHour(int scheduleFromHour) {
        this.scheduleFromHour = scheduleFromHour;
    }

    public boolean isUseHttps() {
        return useHttps;
    }

    public void setUseHttps(boolean useHttps) {
        this.useHttps = useHttps;
    }

    public int getProxyType() {
        return proxyType;
    }

    public void setProxyType(int proxyType) {
        this.proxyType = proxyType;
    }

    public int getDiskCache() {
        return diskCache;
    }

    public void setDiskCache(int diskCache) {
        this.diskCache = diskCache;
    }

    public int getMaxRatio() {
        return maxRatio;
    }

    public void setMaxRatio(int maxRatio) {
        this.maxRatio = maxRatio;
    }

    public int getRssRefreshInterval() {
        return rssRefreshInterval;
    }

    public void setRssRefreshInterval(int rssRefreshInterval) {
        this.rssRefreshInterval = rssRefreshInterval;
    }

    public int getWebUiPort() {
        return webUiPort;
    }

    public void setWebUiPort(int webUiPort) {
        this.webUiPort = webUiPort;
    }

    public int getUploadSlotsBehavior() {
        return uploadSlotsBehavior;
    }

    public void setUploadSlotsBehavior(int uploadSlotsBehavior) {
        this.uploadSlotsBehavior = uploadSlotsBehavior;
    }

    public boolean isLimitUtpRate() {
        return limitUtpRate;
    }

    public void setLimitUtpRate(boolean limitUtpRate) {
        this.limitUtpRate = limitUtpRate;
    }

    public int getBittorrentProtocol() {
        return bittorrentProtocol;
    }

    public void setBittorrentProtocol(int bittorrentProtocol) {
        this.bittorrentProtocol = bittorrentProtocol;
    }

    public int getDiskCacheTtl() {
        return diskCacheTtl;
    }

    public void setDiskCacheTtl(int diskCacheTtl) {
        this.diskCacheTtl = diskCacheTtl;
    }

    public String getDyndnsPassword() {
        return dyndnsPassword;
    }

    public void setDyndnsPassword(String dyndnsPassword) {
        this.dyndnsPassword = dyndnsPassword;
    }

    public boolean isBypassLocalAuth() {
        return bypassLocalAuth;
    }

    public void setBypassLocalAuth(boolean bypassLocalAuth) {
        this.bypassLocalAuth = bypassLocalAuth;
    }

    public int getUploadChokingAlgorithm() {
        return uploadChokingAlgorithm;
    }

    public void setUploadChokingAlgorithm(int uploadChokingAlgorithm) {
        this.uploadChokingAlgorithm = uploadChokingAlgorithm;
    }

    public boolean isEnableOsCache() {
        return enableOsCache;
    }

    public void setEnableOsCache(boolean enableOsCache) {
        this.enableOsCache = enableOsCache;
    }

    public boolean isIpFilterTrackers() {
        return ipFilterTrackers;
    }

    public void setIpFilterTrackers(boolean ipFilterTrackers) {
        this.ipFilterTrackers = ipFilterTrackers;
    }

    public int getScheduleFromMin() {
        return scheduleFromMin;
    }

    public void setScheduleFromMin(int scheduleFromMin) {
        this.scheduleFromMin = scheduleFromMin;
    }

    public boolean isQueueingEnabled() {
        return queueingEnabled;
    }

    public void setQueueingEnabled(boolean queueingEnabled) {
        this.queueingEnabled = queueingEnabled;
    }

    public boolean isCategoryChangedTmmEnabled() {
        return categoryChangedTmmEnabled;
    }

    public void setCategoryChangedTmmEnabled(boolean categoryChangedTmmEnabled) {
        this.categoryChangedTmmEnabled = categoryChangedTmmEnabled;
    }

    public boolean isMaxSeedingTimeEnabled() {
        return maxSeedingTimeEnabled;
    }

    public void setMaxSeedingTimeEnabled(boolean maxSeedingTimeEnabled) {
        this.maxSeedingTimeEnabled = maxSeedingTimeEnabled;
    }

    public int getMaxUploadsPerTorrent() {
        return maxUploadsPerTorrent;
    }

    public void setMaxUploadsPerTorrent(int maxUploadsPerTorrent) {
        this.maxUploadsPerTorrent = maxUploadsPerTorrent;
    }

    public int getSocketBacklogSize() {
        return socketBacklogSize;
    }

    public void setSocketBacklogSize(int socketBacklogSize) {
        this.socketBacklogSize = socketBacklogSize;
    }

    public boolean isWebUiUpnp() {
        return webUiUpnp;
    }

    public void setWebUiUpnp(boolean webUiUpnp) {
        this.webUiUpnp = webUiUpnp;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getBypassAuthSubnetWhitelist() {
        return bypassAuthSubnetWhitelist;
    }

    public void setBypassAuthSubnetWhitelist(String bypassAuthSubnetWhitelist) {
        this.bypassAuthSubnetWhitelist = bypassAuthSubnetWhitelist;
    }

    public int getListenPort() {
        return listenPort;
    }

    public void setListenPort(int listenPort) {
        this.listenPort = listenPort;
    }

    public String getMailNotificationSender() {
        return mailNotificationSender;
    }

    public void setMailNotificationSender(String mailNotificationSender) {
        this.mailNotificationSender = mailNotificationSender;
    }

    public boolean isUpnp() {
        return upnp;
    }

    public void setUpnp(boolean upnp) {
        this.upnp = upnp;
    }

    public boolean isCreateSubfolderEnabled() {
        return createSubfolderEnabled;
    }

    public void setCreateSubfolderEnabled(boolean createSubfolderEnabled) {
        this.createSubfolderEnabled = createSubfolderEnabled;
    }

    public int getAltUpLimit() {
        return altUpLimit;
    }

    public void setAltUpLimit(int altUpLimit) {
        this.altUpLimit = altUpLimit;
    }

    public int getMaxActiveDownloads() {
        return maxActiveDownloads;
    }

    public void setMaxActiveDownloads(int maxActiveDownloads) {
        this.maxActiveDownloads = maxActiveDownloads;
    }

    public int getSlowTorrentInactiveTimer() {
        return slowTorrentInactiveTimer;
    }

    public void setSlowTorrentInactiveTimer(int slowTorrentInactiveTimer) {
        this.slowTorrentInactiveTimer = slowTorrentInactiveTimer;
    }

    public int getMaxActiveUploads() {
        return maxActiveUploads;
    }

    public void setMaxActiveUploads(int maxActiveUploads) {
        this.maxActiveUploads = maxActiveUploads;
    }

    public boolean isLsd() {
        return lsd;
    }

    public void setLsd(boolean lsd) {
        this.lsd = lsd;
    }

    public int getUtpTcpMixedMode() {
        return utpTcpMixedMode;
    }

    public void setUtpTcpMixedMode(int utpTcpMixedMode) {
        this.utpTcpMixedMode = utpTcpMixedMode;
    }

    public int getAutoDeleteMode() {
        return autoDeleteMode;
    }

    public void setAutoDeleteMode(int autoDeleteMode) {
        this.autoDeleteMode = autoDeleteMode;
    }

    public int getOutgoingPortsMin() {
        return outgoingPortsMin;
    }

    public void setOutgoingPortsMin(int outgoingPortsMin) {
        this.outgoingPortsMin = outgoingPortsMin;
    }

    public int getSlowTorrentUlRateThreshold() {
        return slowTorrentUlRateThreshold;
    }

    public void setSlowTorrentUlRateThreshold(int slowTorrentUlRateThreshold) {
        this.slowTorrentUlRateThreshold = slowTorrentUlRateThreshold;
    }

    public String getWebUiHttpsKeyPath() {
        return webUiHttpsKeyPath;
    }

    public void setWebUiHttpsKeyPath(String webUiHttpsKeyPath) {
        this.webUiHttpsKeyPath = webUiHttpsKeyPath;
    }

    public boolean isEnableMultiConnectionsFromSameIp() {
        return enableMultiConnectionsFromSameIp;
    }

    public void setEnableMultiConnectionsFromSameIp(boolean enableMultiConnectionsFromSameIp) {
        this.enableMultiConnectionsFromSameIp = enableMultiConnectionsFromSameIp;
    }

    public boolean isProxyTorrentsOnly() {
        return proxyTorrentsOnly;
    }

    public void setProxyTorrentsOnly(boolean proxyTorrentsOnly) {
        this.proxyTorrentsOnly = proxyTorrentsOnly;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean isAlternativeWebuiEnabled() {
        return alternativeWebuiEnabled;
    }

    public void setAlternativeWebuiEnabled(boolean alternativeWebuiEnabled) {
        this.alternativeWebuiEnabled = alternativeWebuiEnabled;
    }

    public int getMaxConnecPerTorrent() {
        return maxConnecPerTorrent;
    }

    public void setMaxConnecPerTorrent(int maxConnecPerTorrent) {
        this.maxConnecPerTorrent = maxConnecPerTorrent;
    }

    public int getAltDlLimit() {
        return altDlLimit;
    }

    public void setAltDlLimit(int altDlLimit) {
        this.altDlLimit = altDlLimit;
    }

    public boolean isRecheckCompletedTorrents() {
        return recheckCompletedTorrents;
    }

    public void setRecheckCompletedTorrents(boolean recheckCompletedTorrents) {
        this.recheckCompletedTorrents = recheckCompletedTorrents;
    }

    public boolean isEnableUploadSuggestions() {
        return enableUploadSuggestions;
    }

    public void setEnableUploadSuggestions(boolean enableUploadSuggestions) {
        this.enableUploadSuggestions = enableUploadSuggestions;
    }

    public String getMailNotificationPassword() {
        return mailNotificationPassword;
    }

    public void setMailNotificationPassword(String mailNotificationPassword) {
        this.mailNotificationPassword = mailNotificationPassword;
    }

    public int getSaveResumeDataInterval() {
        return saveResumeDataInterval;
    }

    public void setSaveResumeDataInterval(int saveResumeDataInterval) {
        this.saveResumeDataInterval = saveResumeDataInterval;
    }

    public int getScheduleToMin() {
        return scheduleToMin;
    }

    public void setScheduleToMin(int scheduleToMin) {
        this.scheduleToMin = scheduleToMin;
    }

    public int getDyndnsService() {
        return dyndnsService;
    }

    public void setDyndnsService(int dyndnsService) {
        this.dyndnsService = dyndnsService;
    }

    public String getDyndnsDomain() {
        return dyndnsDomain;
    }

    public void setDyndnsDomain(String dyndnsDomain) {
        this.dyndnsDomain = dyndnsDomain;
    }

    public String getTempPath() {
        return tempPath;
    }

    public void setTempPath(String tempPath) {
        this.tempPath = tempPath;
    }

    public String getProxyIp() {
        return proxyIp;
    }

    public void setProxyIp(String proxyIp) {
        this.proxyIp = proxyIp;
    }

    public boolean isAnnounceToAllTiers() {
        return announceToAllTiers;
    }

    public void setAnnounceToAllTiers(boolean announceToAllTiers) {
        this.announceToAllTiers = announceToAllTiers;
    }

    public int getMaxUploads() {
        return maxUploads;
    }

    public void setMaxUploads(int maxUploads) {
        this.maxUploads = maxUploads;
    }

    public boolean isEnableEmbeddedTracker() {
        return enableEmbeddedTracker;
    }

    public void setEnableEmbeddedTracker(boolean enableEmbeddedTracker) {
        this.enableEmbeddedTracker = enableEmbeddedTracker;
    }

    public boolean isMailNotificationEnabled() {
        return mailNotificationEnabled;
    }

    public void setMailNotificationEnabled(boolean mailNotificationEnabled) {
        this.mailNotificationEnabled = mailNotificationEnabled;
    }

    public int getWebUiSessionTimeout() {
        return webUiSessionTimeout;
    }

    public void setWebUiSessionTimeout(int webUiSessionTimeout) {
        this.webUiSessionTimeout = webUiSessionTimeout;
    }

    public int getFilePoolSize() {
        return filePoolSize;
    }

    public void setFilePoolSize(int filePoolSize) {
        this.filePoolSize = filePoolSize;
    }

    public boolean isStartPausedEnabled() {
        return startPausedEnabled;
    }

    public void setStartPausedEnabled(boolean startPausedEnabled) {
        this.startPausedEnabled = startPausedEnabled;
    }

    public boolean isAddTrackersEnabled() {
        return addTrackersEnabled;
    }

    public void setAddTrackersEnabled(boolean addTrackersEnabled) {
        this.addTrackersEnabled = addTrackersEnabled;
    }

    public int getCheckingMemoryUse() {
        return checkingMemoryUse;
    }

    public void setCheckingMemoryUse(int checkingMemoryUse) {
        this.checkingMemoryUse = checkingMemoryUse;
    }

    public boolean isMailNotificationAuthEnabled() {
        return mailNotificationAuthEnabled;
    }

    public void setMailNotificationAuthEnabled(boolean mailNotificationAuthEnabled) {
        this.mailNotificationAuthEnabled = mailNotificationAuthEnabled;
    }

    public int getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(int upLimit) {
        this.upLimit = upLimit;
    }

    public boolean isSchedulerEnabled() {
        return schedulerEnabled;
    }

    public void setSchedulerEnabled(boolean schedulerEnabled) {
        this.schedulerEnabled = schedulerEnabled;
    }

    public boolean isAutoTmmEnabled() {
        return autoTmmEnabled;
    }

    public void setAutoTmmEnabled(boolean autoTmmEnabled) {
        this.autoTmmEnabled = autoTmmEnabled;
    }

    public int getOutgoingPortsMax() {
        return outgoingPortsMax;
    }

    public void setOutgoingPortsMax(int outgoingPortsMax) {
        this.outgoingPortsMax = outgoingPortsMax;
    }

    public int getMaxActiveTorrents() {
        return maxActiveTorrents;
    }

    public void setMaxActiveTorrents(int maxActiveTorrents) {
        this.maxActiveTorrents = maxActiveTorrents;
    }

    public String getMailNotificationUsername() {
        return mailNotificationUsername;
    }

    public void setMailNotificationUsername(String mailNotificationUsername) {
        this.mailNotificationUsername = mailNotificationUsername;
    }

    public String getExportDir() {
        return exportDir;
    }

    public void setExportDir(String exportDir) {
        this.exportDir = exportDir;
    }

    @Override
    public String toString() {
        return
            "Preferences{" +
                "embedded_tracker_port = '" + embeddedTrackerPort + '\'' +
                ",limit_lan_peers = '" + limitLanPeers + '\'' +
                ",max_ratio_enabled = '" + maxRatioEnabled + '\'' +
                ",web_ui_domain_list = '" + webUiDomainList + '\'' +
                ",proxy_password = '" + proxyPassword + '\'' +
                ",alternative_webui_path = '" + alternativeWebuiPath + '\'' +
                ",announce_to_all_trackers = '" + announceToAllTrackers + '\'' +
                ",send_buffer_watermark = '" + sendBufferWatermark + '\'' +
                ",torrent_changed_tmm_enabled = '" + torrentChangedTmmEnabled + '\'' +
                ",dl_limit = '" + dlLimit + '\'' +
                ",autorun_program = '" + autorunProgram + '\'' +
                ",async_io_threads = '" + asyncIoThreads + '\'' +
                ",resolve_peer_countries = '" + resolvePeerCountries + '\'' +
                ",web_ui_clickjacking_protection_enabled = '" + webUiClickjackingProtectionEnabled + '\'' +
                ",bypass_auth_subnet_whitelist_enabled = '" + bypassAuthSubnetWhitelistEnabled + '\'' +
                ",rss_auto_downloading_enabled = '" + rssAutoDownloadingEnabled + '\'' +
                ",temp_path_enabled = '" + tempPathEnabled + '\'' +
                ",pex = '" + pex + '\'' +
                ",incomplete_files_ext = '" + incompleteFilesExt + '\'' +
                ",send_buffer_low_watermark = '" + sendBufferLowWatermark + '\'' +
                ",preallocate_all = '" + preallocateAll + '\'' +
                ",dyndns_username = '" + dyndnsUsername + '\'' +
                ",current_network_interface = '" + currentNetworkInterface + '\'' +
                ",autorun_enabled = '" + autorunEnabled + '\'' +
                ",scheduler_days = '" + schedulerDays + '\'' +
                ",limit_tcp_overhead = '" + limitTcpOverhead + '\'' +
                ",mail_notification_ssl_enabled = '" + mailNotificationSslEnabled + '\'' +
                ",proxy_peer_connections = '" + proxyPeerConnections + '\'' +
                ",dyndns_enabled = '" + dyndnsEnabled + '\'' +
                ",enable_super_seeding = '" + enableSuperSeeding + '\'' +
                ",random_port = '" + randomPort + '\'' +
                ",anonymous_mode = '" + anonymousMode + '\'' +
                ",rss_max_articles_per_feed = '" + rssMaxArticlesPerFeed + '\'' +
                ",ip_filter_enabled = '" + ipFilterEnabled + '\'' +
                ",mail_notification_smtp = '" + mailNotificationSmtp + '\'' +
                ",web_ui_https_cert_path = '" + webUiHttpsCertPath + '\'' +
                ",enable_coalesce_read_write = '" + enableCoalesceReadWrite + '\'' +
                ",banned_IPs = '" + bannedIPs + '\'' +
                ",schedule_to_hour = '" + scheduleToHour + '\'' +
                ",rss_processing_enabled = '" + rssProcessingEnabled + '\'' +
                ",save_path = '" + savePath + '\'' +
                ",save_path_changed_tmm_enabled = '" + savePathChangedTmmEnabled + '\'' +
                ",encryption = '" + encryption + '\'' +
                ",proxy_auth_enabled = '" + proxyAuthEnabled + '\'' +
                ",ip_filter_path = '" + ipFilterPath + '\'' +
                ",web_ui_csrf_protection_enabled = '" + webUiCsrfProtectionEnabled + '\'' +
                ",max_ratio_act = '" + maxRatioAct + '\'' +
                ",mail_notification_email = '" + mailNotificationEmail + '\'' +
                ",proxy_username = '" + proxyUsername + '\'' +
                ",web_ui_address = '" + webUiAddress + '\'' +
                ",max_connec = '" + maxConnec + '\'' +
                ",announce_ip = '" + announceIp + '\'' +
                ",export_dir_fin = '" + exportDirFin + '\'' +
                ",add_trackers = '" + addTrackers + '\'' +
                ",dht = '" + dht + '\'' +
                ",send_buffer_watermark_factor = '" + sendBufferWatermarkFactor + '\'' +
                ",web_ui_username = '" + webUiUsername + '\'' +
                ",current_interface_address = '" + currentInterfaceAddress + '\'' +
                ",slow_torrent_dl_rate_threshold = '" + slowTorrentDlRateThreshold + '\'' +
                ",max_seeding_time = '" + maxSeedingTime + '\'' +
                ",web_ui_host_header_validation_enabled = '" + webUiHostHeaderValidationEnabled + '\'' +
                ",dont_count_slow_torrents = '" + dontCountSlowTorrents + '\'' +
                ",schedule_from_hour = '" + scheduleFromHour + '\'' +
                ",use_https = '" + useHttps + '\'' +
                ",proxy_type = '" + proxyType + '\'' +
                ",disk_cache = '" + diskCache + '\'' +
                ",max_ratio = '" + maxRatio + '\'' +
                ",rss_refresh_interval = '" + rssRefreshInterval + '\'' +
                ",web_ui_port = '" + webUiPort + '\'' +
                ",upload_slots_behavior = '" + uploadSlotsBehavior + '\'' +
                ",limit_utp_rate = '" + limitUtpRate + '\'' +
                ",bittorrent_protocol = '" + bittorrentProtocol + '\'' +
                ",disk_cache_ttl = '" + diskCacheTtl + '\'' +
                ",dyndns_password = '" + dyndnsPassword + '\'' +
                ",bypass_local_auth = '" + bypassLocalAuth + '\'' +
                ",upload_choking_algorithm = '" + uploadChokingAlgorithm + '\'' +
                ",enable_os_cache = '" + enableOsCache + '\'' +
                ",ip_filter_trackers = '" + ipFilterTrackers + '\'' +
                ",schedule_from_min = '" + scheduleFromMin + '\'' +
                ",queueing_enabled = '" + queueingEnabled + '\'' +
                ",category_changed_tmm_enabled = '" + categoryChangedTmmEnabled + '\'' +
                ",max_seeding_time_enabled = '" + maxSeedingTimeEnabled + '\'' +
                ",max_uploads_per_torrent = '" + maxUploadsPerTorrent + '\'' +
                ",socket_backlog_size = '" + socketBacklogSize + '\'' +
                ",web_ui_upnp = '" + webUiUpnp + '\'' +
                ",proxy_port = '" + proxyPort + '\'' +
                ",bypass_auth_subnet_whitelist = '" + bypassAuthSubnetWhitelist + '\'' +
                ",listen_port = '" + listenPort + '\'' +
                ",mail_notification_sender = '" + mailNotificationSender + '\'' +
                ",upnp = '" + upnp + '\'' +
                ",create_subfolder_enabled = '" + createSubfolderEnabled + '\'' +
                ",alt_up_limit = '" + altUpLimit + '\'' +
                ",max_active_downloads = '" + maxActiveDownloads + '\'' +
                ",slow_torrent_inactive_timer = '" + slowTorrentInactiveTimer + '\'' +
                ",max_active_uploads = '" + maxActiveUploads + '\'' +
                ",lsd = '" + lsd + '\'' +
                ",utp_tcp_mixed_mode = '" + utpTcpMixedMode + '\'' +
                ",auto_delete_mode = '" + autoDeleteMode + '\'' +
                ",outgoing_ports_min = '" + outgoingPortsMin + '\'' +
                ",slow_torrent_ul_rate_threshold = '" + slowTorrentUlRateThreshold + '\'' +
                ",web_ui_https_key_path = '" + webUiHttpsKeyPath + '\'' +
                ",enable_multi_connections_from_same_ip = '" + enableMultiConnectionsFromSameIp + '\'' +
                ",proxy_torrents_only = '" + proxyTorrentsOnly + '\'' +
                ",locale = '" + locale + '\'' +
                ",alternative_webui_enabled = '" + alternativeWebuiEnabled + '\'' +
                ",max_connec_per_torrent = '" + maxConnecPerTorrent + '\'' +
                ",alt_dl_limit = '" + altDlLimit + '\'' +
                ",recheck_completed_torrents = '" + recheckCompletedTorrents + '\'' +
                ",enable_upload_suggestions = '" + enableUploadSuggestions + '\'' +
                ",mail_notification_password = '" + mailNotificationPassword + '\'' +
                ",save_resume_data_interval = '" + saveResumeDataInterval + '\'' +
                ",schedule_to_min = '" + scheduleToMin + '\'' +
                ",dyndns_service = '" + dyndnsService + '\'' +
                ",dyndns_domain = '" + dyndnsDomain + '\'' +
                ",temp_path = '" + tempPath + '\'' +
                ",proxy_ip = '" + proxyIp + '\'' +
                ",announce_to_all_tiers = '" + announceToAllTiers + '\'' +
                ",max_uploads = '" + maxUploads + '\'' +
                ",enable_embedded_tracker = '" + enableEmbeddedTracker + '\'' +
                ",mail_notification_enabled = '" + mailNotificationEnabled + '\'' +
                ",web_ui_session_timeout = '" + webUiSessionTimeout + '\'' +
                ",file_pool_size = '" + filePoolSize + '\'' +
                ",start_paused_enabled = '" + startPausedEnabled + '\'' +
                ",add_trackers_enabled = '" + addTrackersEnabled + '\'' +
                ",checking_memory_use = '" + checkingMemoryUse + '\'' +
                ",mail_notification_auth_enabled = '" + mailNotificationAuthEnabled + '\'' +
                ",up_limit = '" + upLimit + '\'' +
                ",scheduler_enabled = '" + schedulerEnabled + '\'' +
                ",auto_tmm_enabled = '" + autoTmmEnabled + '\'' +
                ",outgoing_ports_max = '" + outgoingPortsMax + '\'' +
                ",max_active_torrents = '" + maxActiveTorrents + '\'' +
                ",mail_notification_username = '" + mailNotificationUsername + '\'' +
                ",export_dir = '" + exportDir + '\'' +
                "}";
    }
}
