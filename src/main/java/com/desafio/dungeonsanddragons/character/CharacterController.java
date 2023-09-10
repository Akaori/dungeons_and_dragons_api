package com.desafio.dungeonsanddragons.character;

import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;
import com.desafio.dungeonsanddragons.character.dto.CharacterRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/characters", produces = "application/json")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterModel>> findAll() {
        return ResponseEntity.ok().body(characterService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CharacterModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(characterService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        characterService.delete(id);
    }

    @PostMapping
    public ResponseEntity<CharacterModel> save(@RequestBody CharacterRequestDTO character) {
        var createdCharacter = characterService.save(character);
        return ResponseEntity.ok().body(createdCharacter);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CharacterModel> update(@PathVariable("id") Long id, @RequestBody CharacterPutRequestDTO character) {
        var updatedCharacter = characterService.update(character, id);
        return ResponseEntity.ok().body(updatedCharacter);
    }

}
