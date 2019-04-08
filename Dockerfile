FROM openjdk:8-alpine

COPY target/uberjar/jimw-clj-binding-games.jar /jimw-clj-binding-games/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/jimw-clj-binding-games/app.jar"]
