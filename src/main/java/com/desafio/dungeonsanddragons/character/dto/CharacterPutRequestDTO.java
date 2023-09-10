package com.desafio.dangeous_and_dragons.character.dto;

import com.desafio.dangeous_and_dragons.character.enums.CharacterRole;
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
    private int dice_quantity;
    private int dice_faces;
}
