package com.desafio.dungeonsanddragons.damage.dto;


import com.desafio.dungeonsanddragons.character.CharacterModel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DamageRequestDTO {
    private CharacterModel character;
}
