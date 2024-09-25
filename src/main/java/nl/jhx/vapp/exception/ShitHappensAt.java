package nl.jhx.vapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ShitHappensAt extends RuntimeException {
    public ShitHappensAt(String message) {
        super(message);
    }
}
