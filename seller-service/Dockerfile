FROM java:8
VOLUME /tmp
ADD target/seller-service-0.0.1-SNAPSHOT.jar seller-service.jar
RUN bash -c 'touch /seller-service.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /seller-service.jar"]