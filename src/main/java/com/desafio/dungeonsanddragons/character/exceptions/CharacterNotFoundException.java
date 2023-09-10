package com.desafio.dungeonsanddragons.character.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(Long id) {
        super("Character id " + id + "not found.");
    }
}
