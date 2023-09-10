package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;
import com.desafio.dungeonsanddragons.battle.impl.BattleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/battles", produces = "application/json")
@RequiredArgsConstructor
public class BattleController {

    private final BattleServiceImpl battleService;

    @PostMapping
    public ResponseEntity<BattleModel> save(@RequestBody BattlePostRequestDTO battle) {
        var createdBattle = battleService.save(battle);
        return ResponseEntity.ok().body(createdBattle);
    }
}
