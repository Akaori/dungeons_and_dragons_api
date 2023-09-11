package com.desafio.dungeonsanddragons.battle.enums;

public enum GameRole {
    PLAYER("PLAYER"),
    OPPONENT("OPPONENT");

    private String description;

    GameRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
