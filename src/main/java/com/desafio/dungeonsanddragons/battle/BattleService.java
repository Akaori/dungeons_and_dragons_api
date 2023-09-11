package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;
import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.character.dto.CharacterPutRequestDTO;

import java.util.List;

public interface BattleService {

    List<BattleModel> getAll();

    BattleModel findById(Long id);

    BattleModel save(BattlePostRequestDTO battlePostRequestDTO);

    BattleModel update(BattleModel battle, Long id);

    void delete(Long id);

    BattleModel attack(Long id);
}
