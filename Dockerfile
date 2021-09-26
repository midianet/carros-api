FROM midianet/java11:1
COPY target/carros-api.jar /opt/app.jar
COPY carros.mv.db /opt
COPY cars /opt/cars
ENTRYPOINT java -jar /opt/app.jar
EXPOSE 8080