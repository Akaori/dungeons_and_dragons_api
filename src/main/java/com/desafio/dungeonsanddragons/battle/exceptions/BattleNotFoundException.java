package com.desafio.dungeonsanddragons.battle.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BattleNotFoundException extends RuntimeException {

    public BattleNotFoundException(Long id) {
        super("Battle id " + id + "not found.");
    }
}