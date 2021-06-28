FROM narmour/build-env:latest

COPY pom.xml pom.xml
COPY src/ src/

RUN mvn package

CMD ["java", "-jar", "/root/target/server-0.0.1.jar"]
