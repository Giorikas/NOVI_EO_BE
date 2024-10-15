package nl.jhx.vapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class xNotFoundException extends RuntimeException {
    public xNotFoundException(String message, String itemNotFound, String dto) {
        super(message);
        System.out.println("Not found: "+ itemNotFound + "Error:" + message + " DTO: " + dto );
    }
}


