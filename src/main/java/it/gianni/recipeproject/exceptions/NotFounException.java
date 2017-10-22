package it.gianni.recipeproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFounException extends RuntimeException {

    public NotFounException() {
        super();
    }

    public NotFounException(String message) {
        super(message);
    }

    public NotFounException(String message, Throwable cause) {
        super(message, cause);
    }
}

