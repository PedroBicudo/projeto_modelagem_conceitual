#
# BASE
#
FROM maven:3.8.6-openjdk-11 as BASE
WORKDIR stages
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY . .

#
# TEST
#
FROM BASE as TEST
RUN mvn clean test

#
# BUILD
#
FROM BASE as BUILD
RUN mvn clean package -DskipTests

#
# RUN
#
FROM openjdk:11
EXPOSE 8080
WORKDIR /app
COPY --from=BASE stages/target/*.jar app.jar
ENTRYPOINT java -jar app.jar