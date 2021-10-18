#!/usr/bin/env bash

./gradlew installDist
docker build -t qbittorrent-exporter:latest .
docker tag qbittorrent-exporter:latest caseyscarborough/qbittorrent-exporter:latest
