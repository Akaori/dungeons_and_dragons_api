package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;
import com.desafio.dungeonsanddragons.battle.impl.BattleServiceImpl;
import com.desafio.dungeonsanddragons.character.CharacterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/battles", produces = "application/json")
@RequiredArgsConstructor
public class BattleController {

    private final BattleServiceImpl battleService;

    @GetMapping
    public ResponseEntity<List<BattleModel>> findAll() {
        return ResponseEntity.ok().body(battleService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BattleModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(battleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BattleModel> save(@RequestBody BattlePostRequestDTO battle) {
        var createdBattle = battleService.save(battle);
        return ResponseEntity.ok().body(createdBattle);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        battleService.delete(id);
    }

    @PutMapping("/{id}/attack")
    public ResponseEntity<BattleModel> attack(@PathVariable Long id) {
        return ResponseEntity.ok(battleService.attack(id));
    }
}
