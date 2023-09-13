package com.desafio.dungeonsanddragons.damage;

import com.desafio.dungeonsanddragons.damage.dto.DamageRequestDTO;

public interface DamageService {

    int calculateDamage(DamageRequestDTO damageRequestDTO);
}
