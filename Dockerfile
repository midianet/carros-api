FROM midianet/java11:1
ADD target/carros-api.jar /opt/app.jar
ADD carros.mv.db /opt
ADD cars /opt/cars
ENTRYPOINT sh
#java -jar /opt/app.jar
EXPOSE 8080