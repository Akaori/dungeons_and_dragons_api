package com.desafio.dungeonsanddragons.service;

import com.desafio.dungeonsanddragons.character.CharacterRepository;
import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterRequestDTO;
import com.desafio.dungeonsanddragons.character.enums.CharacterRole;
import com.desafio.dungeonsanddragons.character.exceptions.CharacterNotFoundException;
import com.desafio.dungeonsanddragons.character.impl.CharacterServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharacterServiceTest {

    @Mock
    private Random random;

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CharacterServiceImpl characterService;

    @Test
    void getAll_WhenCharactersExist_ShouldReturnAllCharacters() {
        List<CharacterModel> characters = List.of(
                new CharacterModel(1L, "Orc", CharacterRole.MONSTER, 42, 7, 1, 2, 3, 4),
                new CharacterModel(2L, "Bárbaro", CharacterRole.HERO, 21, 10, 2, 5, 2, 8)
        );
        when(characterRepository.findAll()).thenReturn(characters);
        List<CharacterModel> result = characterService.getAll();
        assertThat(result).isEqualTo(characters);
    }

    @Test
    void findById_WhenCharacterExists_ShouldReturnCharacter() {
        CharacterModel character = new CharacterModel(1L, "Orc", CharacterRole.MONSTER, 42, 7, 1, 2, 3, 4);
        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));
        CharacterModel result = characterService.findById(1L);
        assertThat(result).isEqualTo(character);
    }

    @Test
    void findById_WhenCharacterDoesNotExist_ShouldThrowCharacterNotFoundException() {
        when(characterRepository.findById(1L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> characterService.findById(1L))
                .isInstanceOf(CharacterNotFoundException.class)
                .hasMessage("Character with id 1 not found");
    }

    @Test
    void save_WhenCharacterRequestDTOIsValid_ShouldReturnSavedCharacterModel() {
        CharacterRequestDTO characterRequestDTO = new CharacterRequestDTO("Orc", CharacterRole.MONSTER, 42, 7, 1, 2, 3, 4);
        CharacterModel characterModel = new CharacterModel(1L, "Orc", CharacterRole.MONSTER, 42, 7, 1, 2, 3, 4);
        when(characterRepository.save(any())).thenReturn(characterModel);
        CharacterModel result = characterService.save(characterRequestDTO);
        assertThat(result).isEqualTo(characterModel);
    }

    @Test
    void update_WhenCharacterPutRequestDTOIsValid_ShouldReturnUpdatedCharacterModel() {
        CharacterPutRequestDTO characterPutRequestDTO = new CharacterPutRequestDTO(1L, "Orc", CharacterRole.MONSTER, 42, 7, 1, 2, 3, 4);
        CharacterModel characterModel = new CharacterModel(1L, "Orc", CharacterRole.MONSTER, 42, 7, 1, 2, 3, 4);
        when(characterRepository.findById(1L)).thenReturn(Optional.of(characterModel));
        when(characterRepository.save(any())).thenReturn(characterModel);
        CharacterModel result = characterService.update(characterPutRequestDTO, 1L);
        assertThat(result).isEqualTo(characterModel);
    }

    @Test
    void delete_WhenCharacterExists_ShouldDeleteCharacter() {
        CharacterModel character = new CharacterModel(1L, "Orc", CharacterRole.MONSTER, 42, 7, 1, 2, 3, 4);
        when(characterRepository.findById(1L)).thenReturn(Optional.of(character));
        characterService.delete(1L);
        Mockito.verify(characterRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void delete_WhenCharacterDoesNotExist_ShouldThrowCharacterNotFoundException() {
        when(characterRepository.findById(1L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> characterService.delete(1L))
                .isInstanceOf(CharacterNotFoundException.class)
                .hasMessage("Character with id 1 not found");
    }

    @Test
    void getRandomMonsterId_WhenMonstersExist_ShouldReturnRandomMonsterId() {
        List<Long> monstersIds = List.of(3L, 4L, 5L);
        when(characterRepository.findMonstersIds()).thenReturn(monstersIds);
        when(random.nextInt(monstersIds.size())).thenReturn(1);
        Long result = characterService.getRandomMonsterId();
        assertThat(result).isEqualTo(4L);
    }
}
