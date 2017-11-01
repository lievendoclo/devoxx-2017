FROM fabric8/java-alpine-openjdk8-jre
VOLUME /tmp
ADD build/libs/main-partition-1.0.0-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar