package midianet.carros.repository;

import midianet.carros.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro,Long> {

    List<Carro>  findByTipo(Carro.Tipo tipo);

}