FROM amazoncorretto:11-alpine-jdk
MAINTAINER JeremiasGauto
COPY target/gauto-0.0.1-SNAPSHOT.jar jeremias.jar
ENTRYPOINT ["java","-jar","/jeremias.jar"]