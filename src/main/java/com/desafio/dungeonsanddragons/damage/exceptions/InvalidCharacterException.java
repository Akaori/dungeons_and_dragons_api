package com.desafio.dungeonsanddragons.damage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCharacterException extends RuntimeException {
    public InvalidCharacterException(String msg) {
        super(msg);
    }
}
