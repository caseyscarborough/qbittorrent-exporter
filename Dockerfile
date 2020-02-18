FROM openjdk:13.0.2-jdk-slim

COPY build/libs/qbittorrent-exporter.jar /opt/qbittorrent-exporter.jar
CMD java -jar /opt/qbittorrent-exporter.jar
EXPOSE 17871
