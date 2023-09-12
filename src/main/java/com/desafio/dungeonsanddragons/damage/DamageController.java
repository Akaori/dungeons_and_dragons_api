package com.desafio.dungeonsanddragons.damage;


import com.desafio.dungeonsanddragons.damage.dto.DamageRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/damage", produces = "application/json")
@RequiredArgsConstructor
public class DamageController {

    private final DamageService damageService;

    @PostMapping
    public ResponseEntity<Integer> calculateDamage(@RequestBody DamageRequestDTO damageRequestDTO) {
        return ResponseEntity.ok().body(damageService.calculateDamage(damageRequestDTO));
    }
}
