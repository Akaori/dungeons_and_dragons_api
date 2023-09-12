package com.desafio.dungeonsanddragons.log;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/logs", produces = "application/json")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping(value = "/{battleId}")
    public ResponseEntity<LogModel> findByBattleId(@PathVariable Long battleId) {
        return ResponseEntity.ok().body(logService.findByBattleId(battleId));
    }
}
