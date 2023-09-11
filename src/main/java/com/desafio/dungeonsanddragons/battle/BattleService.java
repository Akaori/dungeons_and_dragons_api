package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;
import com.desafio.dungeonsanddragons.character.CharacterModel;

import java.util.List;

public interface BattleService {

    List<BattleModel> getAll();

    BattleModel findById(Long id);

    BattleModel save(BattlePostRequestDTO battlePostRequestDTO);

    void delete(Long id);
}
