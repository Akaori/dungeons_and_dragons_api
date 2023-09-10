package com.desafio.dangeous_and_dragons.character;

import com.desafio.dangeous_and_dragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dangeous_and_dragons.character.dto.CharacterRequestDTO;
import com.desafio.dangeous_and_dragons.character.dto.CharacterResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CharacterService {

    List<CharacterResponseDTO> getAll();
    CharacterResponseDTO findById(Long id);

    CharacterResponseDTO save(CharacterRequestDTO characterRequestDTO);

    CharacterResponseDTO update(CharacterPutRequestDTO characterPutRequestDTO, Long id);

    void delete(Long id);
}
