FROM adoptopenjdk/openjdk13:jre-13.0.2_8-alpine

COPY build/libs/qbittorrent-exporter.jar /opt/qbittorrent-exporter.jar
CMD java -jar /opt/qbittorrent-exporter.jar
EXPOSE 17871
