package midianet.carros.resource;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Log4j2
@RestController
@RequestMapping(value = "/imagens")
public class ImagemResource {

    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] list(@RequestParam(name = "nome") String nome) throws IOException {
        var f = new File(String.format("/opt/cars/%s.png", nome));
       return Files.readAllBytes(f.toPath());
    }

}