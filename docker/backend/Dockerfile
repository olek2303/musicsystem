# Build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM amazoncorretto:17
ARG PROFILE=dev
ARG APP_VERSION=1.0.1
ENV PROFILE=${PROFILE}
ENV APP_VERSION=${APP_VERSION}
ENV DB_URL=jdbc:postgresql://postgres-music-system:5432/musicsystem

WORKDIR /app
COPY --from=build /build/target/musicsystem-*.jar /app/
COPY fireCred.json /app/musicsystem/fireCred.json
COPY src/main/resources/application.yml /app/musicsystem/src/main/resources/application.yml
COPY src/main/resources/application-dev.yml /app/musicsystem/src/main/resources/application-dev.yml

ENV EMAIL_USERNAME=missing_username
ENV EMAIL_HOSTNAME=missing_host_name
ENV EMAIL_PASSWORD=missing_password

EXPOSE 8088
CMD java -jar -Dspring-profiles.active=${PROFILE} -Dspring.datasource.url=${DB_URL} musicsystem-${APP_VERSION}.jar
