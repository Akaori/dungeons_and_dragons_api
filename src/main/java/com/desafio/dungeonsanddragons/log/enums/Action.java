package com.desafio.dungeonsanddragons.log.enums;

public enum Action {
    ATTACK("ATTACK"),
    DEFENSE("DEFENSE");

    private String description;

    Action(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
