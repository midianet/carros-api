package midianet.carros.resource;

import lombok.extern.log4j.Log4j2;
import midianet.carros.entity.Carro;
import midianet.carros.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/carros")
public class CarroResource {

    @Autowired
    private CarroRepository repository;

    @Transactional
    @PostMapping
    public Carro create(@RequestBody Carro carro, HttpServletResponse response) {
        carro.setId(null);
        carro = repository.save(carro);
        response.addHeader(HttpHeaders.LOCATION,"/carros/" + carro.getId());
        return carro;
    }

    @Transactional
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id,  @RequestBody Carro carro){
        var old = get(id);
        BeanUtils.copyProperties(carro,old, "id");
        repository.save(old);
    }

    @Transactional
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        var carro = get(id);
        repository.delete(carro);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Carro> list(@RequestParam(name = "tipo", required = false) String tipo) {
        if(ObjectUtils.isEmpty(tipo)) return repository.findAll();
        var lista = repository.findByTipo(Carro.Tipo.byName(tipo));
//        lista.forEach(carro -> carro.setDescricao("vazio"));
        return lista;
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Carro get(@PathVariable  Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Carro %d", id)));
    }

}