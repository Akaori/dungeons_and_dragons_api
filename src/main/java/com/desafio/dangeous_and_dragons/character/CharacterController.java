package com.desafio.dangeous_and_dragons.character;

import com.desafio.dangeous_and_dragons.character.dto.CharacterRequestDTO;
import com.desafio.dangeous_and_dragons.character.dto.CharacterResponseDTO;
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
    public ResponseEntity<List<CharacterResponseDTO>> findAll() {
        return ResponseEntity.ok().body(characterService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CharacterResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(characterService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        characterService.delete(id);
    }

    @PostMapping
    public ResponseEntity<CharacterResponseDTO> save(@RequestBody CharacterRequestDTO character) {
        var createdCharacter = characterService.save(character);
        return ResponseEntity.ok().body(createdCharacter);
    }

}
