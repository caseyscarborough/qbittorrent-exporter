FROM adoptopenjdk/openjdk13:jdk-13.0.2_8-alpine-slim

COPY build/libs/qbittorrent-exporter.jar /opt/qbittorrent-exporter.jar
CMD java -jar /opt/qbittorrent-exporter.jar
EXPOSE 17871
