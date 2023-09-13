package com.desafio.dungeonsanddragons.battle.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingPlayerException extends RuntimeException {
    public MissingPlayerException(String msg) {
        super(msg);
    }
}
