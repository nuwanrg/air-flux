FROM openjdk:8-jdk-alpine

COPY . .

ENV MYSQL_DB_HOST=database
ENV MYSQL_DB_PORT=3306

RUN ./mvnw package -DskipTests

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/target/air-flux-capacity-0.0.1-SNAPSHOT.jar"]
