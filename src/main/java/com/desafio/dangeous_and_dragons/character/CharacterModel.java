package com.desafio.dangeous_and_dragons.character;


import com.desafio.dangeous_and_dragons.character.enums.CharacterRole;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "character")
public class Character {
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

}
