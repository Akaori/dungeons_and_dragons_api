package com.desafio.dungeonsanddragons.character.dto;

import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.character.enums.CharacterRole;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CharacterResponseDTO {
    private Long id;
    private String name;
    private CharacterRole role;
    private int life;
    private int strength;
    private int defense;
    private int agility;
    private int dice_quantity;
    private int dice_faces;

    public CharacterResponseDTO(CharacterModel character) {
        this.id = character.getId();
        this.name = character.getName();
        this.role = character.getRole();
        this.life = character.getLife();
        this.strength = character.getStrength();
        this.defense = character.getDefense();
        this.agility = character.getAgility();
        this.dice_quantity = character.getDice_quantity();
        this.dice_faces = character.getDice_faces();
    }
}
