# qbittorrent-exporter

This app is a Prometheus exporter for the qBittorrent application. You must have version 4.1.0 of qBittorrent or higher for this plugin to work.

See it on [DockerHub](https://hub.docker.com/r/caseyscarborough/qbittorrent-exporter).

## Usage

### docker

```bash
docker create \
    --name=qbittorrent-exporter \
    -e QBITTORRENT_USERNAME=username `# defaults to 'admin'` \
    -e QBITTORRENT_PASSWORD=password `# defaults to 'adminadmin'` \
    -e QBITTORRENT_HOST=localhost    `# defaults to 'localhost'` \
    -e QBITTORRENT_PORT=8080         `# defaults to '8080'` \
    -p 17871:17871 \
    caseyscarborough/qbittorrent-exporter:latest
```

## Parameters

| Parameter | Function |
| :----: | :----: |
| `-p 17871` | The webservice port. |
| `-e QBITTORRENT_USERNAME` | The qBittorrent username (defaults to `admin`). |
| `-e QBITTORRENT_PASSWORD` | The qBittorrent password (defaults to `adminadmin`). |
| `-e QBITTORRENT_HOST` | The qBittorrent host (defaults to `localhost`). |
| `-e QBITTORRENT_PORT` | The qBittorrnet port (defaults to `8080`).

## Setup

Add the target to your `scrape_configs` in your `prometheus.yml` configuration file. 

```yml
scrape_configs:

  - job_name: 'qbittorrent'
    static_configs:

    # Update your IP address and port here
    - targets: ['192.168.1.100:17871']
```

## Building Locally

Build the app and the docker container using the following commands:

```bash
git clone https://github.com/caseyscarborough/qbittorrent-exporter.git
cd qbittorrent-exporter
./gradlew build
docker build .
```
