FROM openjdk:11
EXPOSE 8080
ADD target/number-search.jar number-search.jar
ENTRYPOINT ["java", "-jar", "/number-search.jar"]
