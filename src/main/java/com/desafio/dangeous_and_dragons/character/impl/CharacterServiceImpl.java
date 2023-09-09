package com.desafio.dangeous_and_dragons.character.impl;

import com.desafio.dangeous_and_dragons.character.CharacterModel;
import com.desafio.dangeous_and_dragons.character.CharacterRepository;
import com.desafio.dangeous_and_dragons.character.CharacterService;
import com.desafio.dangeous_and_dragons.character.dto.CharacterRequestDTO;
import com.desafio.dangeous_and_dragons.character.dto.CharacterResponseDTO;
import com.desafio.dangeous_and_dragons.character.exceptions.CharacterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    final CharacterRepository characterRepository;

    @Override
    public List<CharacterResponseDTO> getAll() {
        List<CharacterModel> characters = characterRepository.findAll();
        return characters.stream().map(CharacterResponseDTO::new).toList();
    }

    @Override
    public CharacterResponseDTO findById(Long id) {
        return new CharacterResponseDTO(characterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id)));
    }

    @Override
    public CharacterResponseDTO save(CharacterRequestDTO characterRequestDTO) {
        return new CharacterResponseDTO(characterRepository.save(new CharacterModel(characterRequestDTO)));
    }

    @Override
    public CharacterResponseDTO update(CharacterRequestDTO characterRequestDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        characterRepository.deleteById(id);
    }
}
