FROM midianet/java11:1
ADD target/carros-api.jar /opt/
RUN mv /opt/${JAR_FILE} /opt/app.jar
ENTRYPOINT java -jar /opt/app.jar
EXPOSE 8080
