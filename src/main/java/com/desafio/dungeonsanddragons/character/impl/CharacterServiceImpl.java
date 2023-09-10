package com.desafio.dungeonsanddragons.character.impl;

import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.character.CharacterRepository;
import com.desafio.dungeonsanddragons.character.CharacterService;
import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterResponseDTO;
import com.desafio.dungeonsanddragons.character.exceptions.CharacterNotFoundException;
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
    public CharacterResponseDTO update(CharacterPutRequestDTO characterPutRequestDTO, Long id) {
        this.findById(id);
        return new CharacterResponseDTO(characterRepository.save(new CharacterModel(characterPutRequestDTO)));
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        characterRepository.deleteById(id);
    }
}
