package com.desafio.dangeous_and_dragons.character.dto;

import com.desafio.dangeous_and_dragons.character.CharacterModel;
import com.desafio.dangeous_and_dragons.character.enums.CharacterRole;
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
    private int dice_quantity;
    private int dice_faces;

}
