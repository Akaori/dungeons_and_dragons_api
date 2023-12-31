package com.desafio.dungeonsanddragons.log.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class LogNotFoundException extends RuntimeException {
    public LogNotFoundException(Long id) {
        super("Log of battle id " + id + "not found.");
    }
}
