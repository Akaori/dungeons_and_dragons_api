package com.desafio.dungeonsanddragons.battle.impl;

import com.desafio.dungeonsanddragons.battle.enums.BattleInitiative;
import com.desafio.dungeonsanddragons.battle.BattleModel;
import com.desafio.dungeonsanddragons.battle.BattleRepository;
import com.desafio.dungeonsanddragons.battle.BattleService;
import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;
import com.desafio.dungeonsanddragons.battle.enums.BattleStatus;
import com.desafio.dungeonsanddragons.character.impl.CharacterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
@RequiredArgsConstructor
public class BattleServiceImpl implements BattleService {

    @Autowired
    private Random random;
    private final BattleRepository battleRepository;
    private final CharacterServiceImpl characterService;

    @Override
    public BattleModel save(BattlePostRequestDTO battlePostRequestDTO) {
        var character = characterService.findById(battlePostRequestDTO.getCharacter_id());
        var opponent = characterService.findById(battlePostRequestDTO.getOpponent_id());

        // Create new Battle instance
        BattleModel battle = new BattleModel();
        battle.setCharacter(character);
        battle.setOpponent(opponent);

        // Roll a 20-sided dice for each (character and opponent)
        int characterRoll = random.nextInt(20) + 1;
        int opponentRoll = random.nextInt(20) + 1;

        // Check who will have the initiative
        if (characterRoll > opponentRoll) {
            battle.setInitiative(BattleInitiative.CHARACTER);
        } else if (characterRoll < opponentRoll) {
            battle.setInitiative(BattleInitiative.OPPONENT);
        } else {
            // If there is a tie, roll again until there is a winner
            return save(battlePostRequestDTO);
        }

        // Set status, shift and log of the battle
        battle.setStatus(BattleStatus.OPEN);
        battle.setShift(1);
        battle.setLog("");

        return battleRepository.save(battle);
    }
}
