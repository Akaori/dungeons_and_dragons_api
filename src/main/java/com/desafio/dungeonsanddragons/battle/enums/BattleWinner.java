package com.desafio.dungeonsanddragons.battle.enums;

public enum BattleWinner {
    CHARACTER("CHARACTER"),
    OPPONENT("OPPONENT");

    private String description;

    BattleWinner(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
