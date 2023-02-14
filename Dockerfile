FROM amazoncorretto:11-alpine-jdk
MAINTAINER JeremiasGauto
COPY target/gauto-0.0.1-SNAPSHOT.jar JeremiasBackendApp.jar
ENTRYPOINT ["java", "-jar", "JeremiasBackendApp.jar"]