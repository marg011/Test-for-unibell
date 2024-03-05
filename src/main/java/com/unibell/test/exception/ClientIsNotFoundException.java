package com.unibell.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientIsNotFoundException extends RuntimeException{
    public ClientIsNotFoundException(String message) {
        super(message);
    }
}
