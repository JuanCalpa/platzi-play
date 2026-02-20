#Etapa 1: compilacion
FROM gradle:8-jdk21 AS build
COPY --chown=gradle.gradle . /app
WORKDIR /app
RUN gradle bootJar --no-daemon

#Etapa 2: ejecucion
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar platzi_play.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "-jar platzi-play-1.0.0.jar"]