package midianet.carros.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

@Log4j2
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException e) {
        log.error(e.getMessage(),e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error(e.getMessage(),e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(ConstraintViolationException e) {
        log.error(e.getMessage(),e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }

}