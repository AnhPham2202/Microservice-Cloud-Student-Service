FROM openjdk:11

FROM maven:3.6.3

WORKDIR /app

COPY . /app


EXPOSE 8080

RUN mvn clean install package -DskipTests=true

CMD ["mvn", "spring-boot:run"]