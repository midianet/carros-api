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

    @GetMapping(path = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] get(@PathVariable final Integer id) throws IOException {
        return getPhoto(id);
    }

    private byte[] getPhoto(final Integer id) throws  IOException{
        return Files.readAllBytes(new File(String.format("/opt/cars/car_%s.png", id)).toPath());
    }

}
