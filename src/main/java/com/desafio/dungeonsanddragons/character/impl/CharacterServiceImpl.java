package com.desafio.dungeonsanddragons.character.impl;

import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.character.CharacterRepository;
import com.desafio.dungeonsanddragons.character.CharacterService;
import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterRequestDTO;
import com.desafio.dungeonsanddragons.character.enums.CharacterRole;
import com.desafio.dungeonsanddragons.character.exceptions.CharacterNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private final Random random;
    final CharacterRepository characterRepository;

    @Override
    public List<CharacterModel> getAll() {
        return characterRepository.findAll();
    }

    @Override
    public CharacterModel findById(Long id) {
        return characterRepository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public CharacterModel save(CharacterRequestDTO characterRequestDTO) {
        return characterRepository.save(new CharacterModel(characterRequestDTO));
    }

    @Override
    public CharacterModel update(CharacterPutRequestDTO characterPutRequestDTO, Long id) {
        this.findById(id);
        return characterRepository.save(new CharacterModel(characterPutRequestDTO));
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        characterRepository.deleteById(id);
    }

    @Override
    public Long getRandomMonsterId() {
        List<Long> monstersIds = characterRepository.findMonstersIds();
        int randomMonsterId = random.nextInt(monstersIds.size());
        return monstersIds.get(randomMonsterId);
    }
}
