package qbittorrent.exporter.model;

import com.google.gson.annotations.SerializedName;

public class Torrent {

    @SerializedName("amount_left")
    private long amountLeft;

    @SerializedName("max_ratio")
    private long maxRatio;

    @SerializedName("auto_tmm")
    private boolean autoTmm;

    @SerializedName("availability")
    private double availability;

    @SerializedName("num_incomplete")
    private long numIncomplete;

    @SerializedName("seeding_time_limit")
    private long seedingTimeLimit;

    @SerializedName("force_start")
    private boolean forceStart;

    @SerializedName("save_path")
    private String savePath;

    @SerializedName("num_seeds")
    private long numSeeds;

    @SerializedName("dl_limit")
    private long dlLimit;

    @SerializedName("eta")
    private long eta;

    @SerializedName("last_activity")
    private long lastActivity;

    @SerializedName("num_leechs")
    private long numLeechs;

    @SerializedName("num_complete")
    private long numComplete;

    @SerializedName("seen_complete")
    private long seenComplete;

    @SerializedName("tracker")
    private String tracker;

    @SerializedName("uploaded")
    private long uploaded;

    @SerializedName("completion_on")
    private long completionOn;

    @SerializedName("ratio_limit")
    private long ratioLimit;

    @SerializedName("state")
    private String state;

    @SerializedName("added_on")
    private long addedOn;

    @SerializedName("time_active")
    private long timeActive;

    @SerializedName("total_size")
    private long totalSize;

    @SerializedName("seq_dl")
    private boolean seqDl;

    @SerializedName("downloaded_session")
    private long downloadedSession;

    @SerializedName("completed")
    private long completed;

    @SerializedName("f_l_piece_prio")
    private boolean fLPiecePrio;

    @SerializedName("priority")
    private long priority;

    @SerializedName("super_seeding")
    private boolean superSeeding;

    @SerializedName("upspeed")
    private long upspeed;

    @SerializedName("downloaded")
    private long downloaded;

    @SerializedName("tags")
    private String tags;

    @SerializedName("uploaded_session")
    private long uploadedSession;

    @SerializedName("size")
    private long size;

    @SerializedName("up_limit")
    private long upLimit;

    @SerializedName("magnet_uri")
    private String magnetUri;

    @SerializedName("max_seeding_time")
    private long maxSeedingTime;

    @SerializedName("name")
    private String name;

    @SerializedName("progress")
    private double progress;

    @SerializedName("category")
    private String category;

    @SerializedName("dlspeed")
    private long dlspeed;

    @SerializedName("hash")
    private String hash;

    @SerializedName("ratio")
    private double ratio;

    public long getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(long amountLeft) {
        this.amountLeft = amountLeft;
    }

    public long getMaxRatio() {
        return maxRatio;
    }

    public void setMaxRatio(long maxRatio) {
        this.maxRatio = maxRatio;
    }

    public boolean isAutoTmm() {
        return autoTmm;
    }

    public void setAutoTmm(boolean autoTmm) {
        this.autoTmm = autoTmm;
    }

    public double getAvailability() {
        return availability;
    }

    public void setAvailability(double availability) {
        this.availability = availability;
    }

    public long getNumIncomplete() {
        return numIncomplete;
    }

    public void setNumIncomplete(long numIncomplete) {
        this.numIncomplete = numIncomplete;
    }

    public long getSeedingTimeLimit() {
        return seedingTimeLimit;
    }

    public void setSeedingTimeLimit(long seedingTimeLimit) {
        this.seedingTimeLimit = seedingTimeLimit;
    }

    public boolean isForceStart() {
        return forceStart;
    }

    public void setForceStart(boolean forceStart) {
        this.forceStart = forceStart;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public long getNumSeeds() {
        return numSeeds;
    }

    public void setNumSeeds(long numSeeds) {
        this.numSeeds = numSeeds;
    }

    public long getDlLimit() {
        return dlLimit;
    }

    public void setDlLimit(long dlLimit) {
        this.dlLimit = dlLimit;
    }

    public long getEta() {
        return eta;
    }

    public void setEta(long eta) {
        this.eta = eta;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(long lastActivity) {
        this.lastActivity = lastActivity;
    }

    public long getNumLeechs() {
        return numLeechs;
    }

    public void setNumLeechs(long numLeechs) {
        this.numLeechs = numLeechs;
    }

    public long getNumComplete() {
        return numComplete;
    }

    public void setNumComplete(long numComplete) {
        this.numComplete = numComplete;
    }

    public long getSeenComplete() {
        return seenComplete;
    }

    public void setSeenComplete(long seenComplete) {
        this.seenComplete = seenComplete;
    }

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public long getUploaded() {
        return uploaded;
    }

    public void setUploaded(long uploaded) {
        this.uploaded = uploaded;
    }

    public long getCompletionOn() {
        return completionOn;
    }

    public void setCompletionOn(long completionOn) {
        this.completionOn = completionOn;
    }

    public long getRatioLimit() {
        return ratioLimit;
    }

    public void setRatioLimit(long ratioLimit) {
        this.ratioLimit = ratioLimit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(long addedOn) {
        this.addedOn = addedOn;
    }

    public long getTimeActive() {
        return timeActive;
    }

    public void setTimeActive(long timeActive) {
        this.timeActive = timeActive;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public boolean isSeqDl() {
        return seqDl;
    }

    public void setSeqDl(boolean seqDl) {
        this.seqDl = seqDl;
    }

    public long getDownloadedSession() {
        return downloadedSession;
    }

    public void setDownloadedSession(long downloadedSession) {
        this.downloadedSession = downloadedSession;
    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }

    public boolean isFLPiecePrio() {
        return fLPiecePrio;
    }

    public void setFLPiecePrio(boolean fLPiecePrio) {
        this.fLPiecePrio = fLPiecePrio;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public boolean isSuperSeeding() {
        return superSeeding;
    }

    public void setSuperSeeding(boolean superSeeding) {
        this.superSeeding = superSeeding;
    }

    public long getUpspeed() {
        return upspeed;
    }

    public void setUpspeed(long upspeed) {
        this.upspeed = upspeed;
    }

    public long getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(long downloaded) {
        this.downloaded = downloaded;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getUploadedSession() {
        return uploadedSession;
    }

    public void setUploadedSession(long uploadedSession) {
        this.uploadedSession = uploadedSession;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getUpLimit() {
        return upLimit;
    }

    public void setUpLimit(long upLimit) {
        this.upLimit = upLimit;
    }

    public String getMagnetUri() {
        return magnetUri;
    }

    public void setMagnetUri(String magnetUri) {
        this.magnetUri = magnetUri;
    }

    public long getMaxSeedingTime() {
        return maxSeedingTime;
    }

    public void setMaxSeedingTime(long maxSeedingTime) {
        this.maxSeedingTime = maxSeedingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getDlspeed() {
        return dlspeed;
    }

    public void setDlspeed(long dlspeed) {
        this.dlspeed = dlspeed;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return
            "Response{" +
                "amount_left = '" + amountLeft + '\'' +
                ",max_ratio = '" + maxRatio + '\'' +
                ",auto_tmm = '" + autoTmm + '\'' +
                ",availability = '" + availability + '\'' +
                ",num_incomplete = '" + numIncomplete + '\'' +
                ",seeding_time_limit = '" + seedingTimeLimit + '\'' +
                ",force_start = '" + forceStart + '\'' +
                ",save_path = '" + savePath + '\'' +
                ",num_seeds = '" + numSeeds + '\'' +
                ",dl_limit = '" + dlLimit + '\'' +
                ",eta = '" + eta + '\'' +
                ",last_activity = '" + lastActivity + '\'' +
                ",num_leechs = '" + numLeechs + '\'' +
                ",num_complete = '" + numComplete + '\'' +
                ",seen_complete = '" + seenComplete + '\'' +
                ",tracker = '" + tracker + '\'' +
                ",uploaded = '" + uploaded + '\'' +
                ",completion_on = '" + completionOn + '\'' +
                ",ratio_limit = '" + ratioLimit + '\'' +
                ",state = '" + state + '\'' +
                ",added_on = '" + addedOn + '\'' +
                ",time_active = '" + timeActive + '\'' +
                ",total_size = '" + totalSize + '\'' +
                ",seq_dl = '" + seqDl + '\'' +
                ",downloaded_session = '" + downloadedSession + '\'' +
                ",completed = '" + completed + '\'' +
                ",f_l_piece_prio = '" + fLPiecePrio + '\'' +
                ",priority = '" + priority + '\'' +
                ",super_seeding = '" + superSeeding + '\'' +
                ",upspeed = '" + upspeed + '\'' +
                ",downloaded = '" + downloaded + '\'' +
                ",tags = '" + tags + '\'' +
                ",uploaded_session = '" + uploadedSession + '\'' +
                ",size = '" + size + '\'' +
                ",up_limit = '" + upLimit + '\'' +
                ",magnet_uri = '" + magnetUri + '\'' +
                ",max_seeding_time = '" + maxSeedingTime + '\'' +
                ",name = '" + name + '\'' +
                ",progress = '" + progress + '\'' +
                ",category = '" + category + '\'' +
                ",dlspeed = '" + dlspeed + '\'' +
                ",hash = '" + hash + '\'' +
                ",ratio = '" + ratio + '\'' +
                "}";
    }
}
