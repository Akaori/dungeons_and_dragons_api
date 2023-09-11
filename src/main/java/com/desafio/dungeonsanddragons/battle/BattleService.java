package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;


import java.util.List;

public interface BattleService {

    List<BattleModel> getAll();

    BattleModel findById(Long id);

    BattleModel save(BattlePostRequestDTO battlePostRequestDTO);

    BattleModel update(BattleModel battle, Long id);

    void delete(Long id);

    BattleModel attack(Long id);

    BattleModel defense(Long id);
}
