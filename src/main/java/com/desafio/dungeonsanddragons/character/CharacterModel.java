package com.desafio.dungeonsanddragons.character;


import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterRequestDTO;
import com.desafio.dungeonsanddragons.character.enums.CharacterRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "character")
@NoArgsConstructor
public class CharacterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private CharacterRole role;

    @Column(nullable = false)
    private int life;

    @Column(nullable = false)
    private int strength;

    @Column(nullable = false)
    private int defense;

    @Column(nullable = false)
    private int agility;

    @Column(nullable = false)
    private int dice_quantity;

    @Column(nullable = false)
    private int dice_faces;

    public CharacterModel(CharacterRequestDTO character) {
        this.name = character.getName();
        this.role = character.getRole();
        this.life = character.getLife();
        this.strength = character.getStrength();
        this.defense = character.getDefense();
        this.agility = character.getAgility();
        this.dice_quantity = character.getDice_quantity();
        this.dice_faces = character.getDice_faces();
    }

    public CharacterModel(CharacterPutRequestDTO character) {
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
