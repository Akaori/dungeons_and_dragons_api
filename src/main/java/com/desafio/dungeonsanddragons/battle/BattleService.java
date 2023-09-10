package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;

public interface BattleService {
    BattleModel save(BattlePostRequestDTO battlePostRequestDTO);
}
