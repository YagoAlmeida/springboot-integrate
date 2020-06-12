FROM openjdk:8-jdk-alpine
EXPOSE 8091
COPY /target /opt/target
WORKDIR /opt/target
ENTRYPOINT ["java","-jar","springboot.integrate-0.0.1.jar"]