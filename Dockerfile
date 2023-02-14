FROM amazoncorretto:11-alpine-jdk
MAINTAINER JeremiasGauto
COPY target/gauto-0.0.1-SNAPSHOT.jar GautoBackendAP.jar
ENTRYPOINT ["java","-jar","/GautoBackendAP.jar"]