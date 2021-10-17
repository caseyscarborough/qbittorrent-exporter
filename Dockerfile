FROM openjdk:17

COPY build/libs/qbittorrent-exporter.jar /opt/qbittorrent-exporter.jar
CMD java -jar /opt/qbittorrent-exporter.jar

EXPOSE 17871
