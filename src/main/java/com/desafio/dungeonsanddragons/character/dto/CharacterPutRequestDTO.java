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
}
