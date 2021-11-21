FROM gradle:7.2 AS builder
WORKDIR /build
COPY . /build/
RUN gradle clean build

FROM openjdk:11-jdk-slim
COPY --from=builder /build/build/libs/imanage-stack-api.jar app.jar
COPY application.yml application.yml
ENTRYPOINT ["java","-jar","/app.jar"]