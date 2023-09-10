package com.desafio.dungeonsanddragons.character;

import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterRequestDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterModel> getAll();
    CharacterModel findById(Long id);

    CharacterModel save(CharacterRequestDTO characterRequestDTO);

    CharacterModel update(CharacterPutRequestDTO characterPutRequestDTO, Long id);

    void delete(Long id);
}
