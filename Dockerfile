FROM openjdk:8
MAINTAINER Shubham Aggarwal shubhamaggarwal890@gmail.com
COPY ./target/calculator-devops-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "calculator-devops-1.0-SNAPSHOT-jar-with-dependencies.jar"]