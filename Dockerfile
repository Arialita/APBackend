FROM amazoncorretto:17
MAINTAINER alejandroaguilar
COPY target/BackendPortfolio-0.0.1-SNAPSHOT.jar BackendPortfolio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","BackendPortfolio-0.0.1-SNAPSHOT.jar"]