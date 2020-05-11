FROM java:8
VOLUME /tmp
ADD target/buyer-service-0.0.1-SNAPSHOT.jar buyer-service.jar
RUN bash -c 'touch /buyer-service.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /buyer-service.jar"]