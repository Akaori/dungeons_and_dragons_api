package com.desafio.dungeonsanddragons.character.dto;

import com.desafio.dungeonsanddragons.character.enums.CharacterRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterRequestDTO {
    private String name;
    private CharacterRole role;
    private int life;
    private int strength;
    private int defense;
    private int agility;
    private int diceQuantity;
    private int diceFaces;

    public CharacterRequestDTO(String name, CharacterRole role, int life, int strength, int defense, int agility, int diceQuantity, int diceFaces) {
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
