package midianet.carros.resource;

import lombok.extern.log4j.Log4j2;
import midianet.carros.entity.Carro;
import midianet.carros.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "/imagens")
public class ImagemResource {

    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] list(@RequestParam(name = "nome") String nome) throws IOException {
        var f = new File(String.format("/Users/user/db/cars/%s.png", nome));
       return Files.readAllBytes(f.toPath());
    }

}