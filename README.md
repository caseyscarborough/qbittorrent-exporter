# qbittorrent-exporter

![Gradle Build](https://github.com/caseyscarborough/qbittorrent-exporter/actions/workflows/build.yaml/badge.svg) ![Release](https://github.com/caseyscarborough/qbittorrent-exporter/actions/workflows/release.yaml/badge.svg)

<img src="https://github.com/caseyscarborough/qbittorrent-grafana-dashboard/blob/master/images/logo.png" width=100> <img src="https://github.com/caseyscarborough/qbittorrent-grafana-dashboard/blob/master/images/prometheus.png" width=100>

This app is a Prometheus exporter for the qBittorrent application. You must have version 4.1.0 of qBittorrent or higher
for this plugin to work.

This is especially useful when integrated with
the [qbittorrent-grafana-dashboard](https://github.com/caseyscarborough/qbittorrent-grafana-dashboard).

See it on [DockerHub](https://hub.docker.com/r/caseyscarborough/qbittorrent-exporter).

## Usage

### docker

```bash
docker run \
    --name=qbittorrent-exporter \
    -e QBITTORRENT_USERNAME=username \
    -e QBITTORRENT_PASSWORD=password \
    -e QBITTORRENT_BASE_URL=http://localhost:8080 \
    -p 17871:17871 \
    caseyscarborough/qbittorrent-exporter:latest
```

## Parameters

|         Parameter         |                               Function                               |      Default Value      |
|:-------------------------:|:--------------------------------------------------------------------:|:-----------------------:|
|        `-p 17871`         |                         The webservice port.                         |           N/A           |
| `-e QBITTORRENT_USERNAME` |                      The qBittorrent username.                       |         `admin`         |
| `-e QBITTORRENT_PASSWORD` |                      The qBittorrent password.                       |      `adminadmin`       |
| `-e QBITTORRENT_BASE_URL` |                      The qBittorrent base URL.                       | `http://localhost:8080` |
|   `-e QBITTORRENT_HOST`   |   The qBittorrent host. Ignored when using `QBITTORRENT_BASE_URL`.   |       `localhost`       |
|   `-e QBITTORRENT_PORT`   |   The qBittorrent port. Ignored when using `QBITTORRENT_BASE_URL`.   |         `8080`          |
| `-e QBITTORRENT_PROTOCOL` | The qBittorrent protocol. Ignored when using `QBITTORRENT_BASE_URL`. |         `http`          |

## Setup

Add the target to your `scrape_configs` in your `prometheus.yml` configuration file of your Prometheus server.

```yml
scrape_configs:

  - job_name: 'qbittorrent'
    static_configs:

      # Update your IP address and port here
      - targets: [ '192.168.1.100:17871' ]
```

## Building Locally

Build the app and the docker container using the following commands:

```bash
./gradlew build
docker build .
```
