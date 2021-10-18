FROM openjdk:17
# Run ./gradlew installDist before running Docker build

COPY build/install/qbittorrent-exporter /opt/qbittorrent-exporter
ENTRYPOINT ["/opt/qbittorrent-exporter/bin/qbittorrent-exporter"]

EXPOSE 17871
