package com.desafio.dungeonsanddragons.damage.impl;

import com.desafio.dungeonsanddragons.battle.exceptions.InvalidActionException;
import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.damage.DamageService;
import com.desafio.dungeonsanddragons.damage.dto.DamageRequestDTO;
import com.desafio.dungeonsanddragons.damage.exceptions.InvalidCharacterException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class DamageServiceImpl implements DamageService {

    @Autowired
    private final Random random;

    @Override
    public int calculateDamage(DamageRequestDTO damageRequestDTO) {

        // Check if the character is valid
        if (damageRequestDTO.getCharacter() == null) {
            throw new InvalidCharacterException("Invalid Character.");
        }

        // Get the player from the request
        CharacterModel character = damageRequestDTO.getCharacter();

        // Initialize the damage value to zero
        int damageValue = 0;

        // Calculate the damage value by rolling the dice according
        // to the character's damage attribute and adding it to their strength
        for (int i = 0; i < character.getDiceQuantity(); i++) {
            damageValue += random.nextInt(character.getDiceFaces()) + 1;
        }
        damageValue += character.getStrength();

        return damageValue;
    }
}
