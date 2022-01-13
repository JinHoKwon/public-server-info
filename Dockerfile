FROM openjdk11:alpine-jre
VOLUME /app
ARG JAR_FILE=build/libs/server-info-v1.0.jar
ADD ${JAR_FILE} server-info-v1.0.jar
ADD app-entrypoint.sh /app-entrypoint.sh
RUN chmod +x /app-entrypoint.sh
ENTRYPOINT ["/app-entrypoint.sh"]
