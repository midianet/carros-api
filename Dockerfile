FROM midianet/java11:1
ADD target/carros-api.jar /opt
RUN mv /opt/carros-api.jar /opt/app.jar
ENTRYPOINT java -jar /opt/app.jar
EXPOSE 8080
