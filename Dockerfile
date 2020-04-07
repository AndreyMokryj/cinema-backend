FROM openjdk:8-jdk-alpine
RUN apk add --no-cache curl wait4ports
VOLUME /tmp
ADD /target/CinemaService1-2.1.1.RELEASE.jar cinema.jar
ENTRYPOINT ["java","-jar","cinema.jar", "--spring.profiles.active=docker"]