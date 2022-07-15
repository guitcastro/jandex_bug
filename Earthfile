VERSION 0.6
FROM quay.io/quarkus/ubi-quarkus-native-image:22.0.0-java17
WORKDIR /app

deps:
    USER root
    # Install docker for integration test
    RUN microdnf install findutils
    COPY gradle/ gradle/
    COPY gradlew gradlew
    COPY gradle.properties gradle.properties
    COPY settings.gradle.kts settings.gradle.kts
    COPY build.gradle.kts build.gradle.kts
    # Cache dependencies
    COPY domain/build.gradle.kts domain/build.gradle.kts
    COPY data/build.gradle.kts data/build.gradle.kts
    COPY app/build.gradle.kts app/build.gradle.kts
    RUN ./gradlew build

build:
    FROM +deps
    COPY . .
    RUN ./gradlew build