package com.desafio.dungeonsanddragons.character;

import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterResponseDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterResponseDTO> getAll();
    CharacterResponseDTO findById(Long id);

    CharacterResponseDTO save(CharacterRequestDTO characterRequestDTO);

    CharacterResponseDTO update(CharacterPutRequestDTO characterPutRequestDTO, Long id);

    void delete(Long id);
}
