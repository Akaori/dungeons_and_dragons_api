package com.desafio.dungeonsanddragons.character.dto;

import com.desafio.dungeonsanddragons.character.enums.CharacterRole;
import lombok.Data;

@Data
public class CharacterPutRequestDTO {
    private Long id;
    private String name;
    private CharacterRole role;
    private int life;
    private int strength;
    private int defense;
    private int agility;
    private int diceQuantity;
    private int diceFaces;

    public CharacterPutRequestDTO(Long id, String name, CharacterRole role, int life, int strength, int defense, int agility, int diceQuantity, int diceFaces) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.life = life;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.diceQuantity = diceQuantity;
        this.diceFaces = diceFaces;
    }
}
