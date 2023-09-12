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

}
