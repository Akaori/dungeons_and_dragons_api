package com.desafio.dungeonsanddragons.log.enums;

public enum Result {
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");

    private String description;

    Result(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
