package com.desafio.dungeonsanddragons.character.enums;

public enum CharacterRole {
    HERO("HERO"),
    MONSTER("MONSTER");

    private String description;

    CharacterRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
