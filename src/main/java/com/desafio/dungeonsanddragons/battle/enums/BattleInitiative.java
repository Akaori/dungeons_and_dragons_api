package com.desafio.dungeonsanddragons.battle.enums;

public enum BattleInitiative {
    CHARACTER("CHARACTER"),
    OPPONENT("OPPONENT");

    private String description;

    BattleInitiative(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
