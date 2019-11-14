package midianet.carros;

import midianet.carros.entity.Carro;
import midianet.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Application {

    @Autowired
    CarroRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Transactional
    @PostConstruct
    public void load(){
//        var template = new RestTemplate();
//        var carros = template.getForObject("https://carros-springboot.herokuapp.com/api/v1/carros/", Carro[].class);
//        for(var carro: carros){
//            carro.setCodigo(carro.getId());
//            carro.setId(null);
//            repository.save(carro);
//        }
//        repository.findAll().forEach(carro -> {
//            carro.setDescricao(carro.getDescricao().replace("\"", ""));
//            repository.save(carro);
//        });

    }

}