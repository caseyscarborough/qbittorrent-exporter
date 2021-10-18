#!/usr/bin/env bash

version=$(git describe --abbrev=0 --always --tags | sed 's/v//g')

./gradlew installDist
docker build -t qbittorrent-exporter .
docker tag qbittorrent-exporter caseyscarborough/qbittorrent-exporter:latest
docker tag qbittorrent-exporter caseyscarborough/qbittorrent-exporter:$version
docker push caseyscarborough/qbittorrent-exporter:latest
docker push caseyscarborough/qbittorrent-exporter:$version
