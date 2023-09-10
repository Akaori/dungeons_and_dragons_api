package com.desafio.dungeonsanddragons.battle.enums;

public enum BattleStatus {
    OPEN("OPEN"),
    CLOSED("CLOSED");

    private String description;

    BattleStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
