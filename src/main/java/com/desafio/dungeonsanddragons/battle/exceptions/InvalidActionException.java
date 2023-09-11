package com.desafio.dungeonsanddragons.battle.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidActionException extends RuntimeException {

    public InvalidActionException(String msg) {
        super(msg);
    }
}
