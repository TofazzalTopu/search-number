# Number Search System

Please follow below instruction to run this project:

###Browse swagger:
http://localhost:8080/swagger-ui.html

Technology stack:
1. Java - 11
2. Spring Boot
3. Spring Data JPA
4. Maven
5. Postgres
6. Docker
7. Swagger

Run Commands:
1. mvn clean
2. mvn install
3. mvn spring-boot:run

Generate and run jar file:
1. mvn clean install
2. cd target
3. java -jar number-search.jar
    
### Create docker image and run
1. docker build -t number-search .
2. docker run -p 8080:8080 number-search
3. docker container run --name number-search -p 8080:8080 -d number-search
4. docker start <container id>
5. docker logs <container id>
