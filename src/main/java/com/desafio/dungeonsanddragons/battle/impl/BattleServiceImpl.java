package com.desafio.dungeonsanddragons.battle.impl;

import com.desafio.dungeonsanddragons.battle.enums.GameRole;
import com.desafio.dungeonsanddragons.battle.BattleModel;
import com.desafio.dungeonsanddragons.battle.BattleRepository;
import com.desafio.dungeonsanddragons.battle.BattleService;
import com.desafio.dungeonsanddragons.battle.dto.BattlePostRequestDTO;
import com.desafio.dungeonsanddragons.battle.enums.BattleStatus;
import com.desafio.dungeonsanddragons.battle.exceptions.BattleNotFoundException;
import com.desafio.dungeonsanddragons.battle.exceptions.InvalidActionException;
import com.desafio.dungeonsanddragons.character.CharacterService;
import com.desafio.dungeonsanddragons.log.LogModel;
import com.desafio.dungeonsanddragons.log.LogService;
import com.desafio.dungeonsanddragons.log.enums.Action;
import com.desafio.dungeonsanddragons.log.enums.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class BattleServiceImpl implements BattleService {

    @Autowired
    private final Random random;
    private final BattleRepository battleRepository;
    private final CharacterService characterService;
    private final LogService logService;

    @Override
    public List<BattleModel> getAll() {
        return battleRepository.findAll();
    }

    @Override
    public BattleModel findById(Long id) {
        return battleRepository.findById(id).orElseThrow(() -> new BattleNotFoundException(id));
    }

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
            battle.setInitiative(GameRole.PLAYER);
        } else if (characterRoll < opponentRoll) {
            battle.setInitiative(GameRole.OPPONENT);
        } else {
            // If there is a tie, roll again until there is a winner
            return save(battlePostRequestDTO);
        }

        // Set status, shift and log of the battle
        battle.setStatus(BattleStatus.OPEN);
        battle.setShift(0);
        battle.setLog("");

        return battleRepository.save(battle);
    }

    @Override
    public BattleModel update(BattleModel battle, Long id) {
        this.findById(id);
        return battleRepository.save(battle);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        battleRepository.deleteById(id);
    }

    @Override
    public BattleModel attack(Long id) {
        BattleModel battle = this.findById(id);

        // Check if the battle is open
        if (!battle.getStatus().equals(BattleStatus.OPEN)) {
            throw new InvalidActionException("Invalid Action. Battle is Closed.");
        }

        // Check if the initiative is character
        if (!battle.getInitiative().equals(GameRole.PLAYER)) {
            throw new InvalidActionException("Invalid Action. Initiative belongs to the Opponent.");
        }

        // Calculate the attack value by rolling a 12-sided dice
        // and adding it to the character's strength and agility
        int attackValue = random.nextInt(12) + 1 + battle.getCharacter().getStrength() + battle.getCharacter().getAgility();

        // Calculate the defense value by rolling a 12-sided dice
        // and adding it to the opponent's defense and agility
        int defenseValue = random.nextInt(12) + 1 + battle.getOpponent().getDefense() + battle.getOpponent().getAgility();

        // Compare the attack value and the defense value
        // and determine if the attack was successful or not
        boolean success = attackValue > defenseValue;

        // Initialize the damage value to zero
        int damageValue = 0;

        // If successful, calculate the damage value by rolling the dice according
        // to the character's damage attribute and adding it to their strength
        if (success) {
            for (int i = 0; i < battle.getCharacter().getDice_quantity(); i++) {
                damageValue += random.nextInt(battle.getCharacter().getDice_faces()) + 1;
            }
            damageValue += battle.getCharacter().getStrength();

            // Subtract the damage value from the opponent's life points
            // and check if they are zero or less
            battle.getOpponent().setLife(battle.getOpponent().getLife() - damageValue);

            if (battle.getOpponent().getLife() <= 0) {
                // End the battle and declare the winner as the character
                battle.setStatus(BattleStatus.CLOSED);
                battle.setWinner(GameRole.PLAYER);
            } else {
                // Switch the initiative to the opponent and increment the turn number
                battle.setInitiative(GameRole.OPPONENT);
                battle.setShift(battle.getShift() + 1);
            }
        }  else {
            // Switch the initiative to the opponent and increment the turn number
            battle.setInitiative(GameRole.OPPONENT);
            battle.setShift(battle.getShift() + 1);
        }

        // Update the battle log with all the details of the attack action
        String logEntry = "Turno " + battle.getShift() + ": Personagem atacou" +
                ", valor do ataque " + attackValue + ", valor da defesa " + defenseValue +
                ", valor do dano " + damageValue + ", resultado " + (success ? "sucesso" : "falha") + "\n";
        battle.setLog(battle.getLog() + logEntry);

        // Save the updated battle in the database
        this.update(battle, battle.getId());

        // Create a new log entry with all the details of the attack action
        LogModel log = new LogModel();
        log.setShift(battle.getShift());
        log.setAction(Action.ATTACK);
        log.setAttacker(GameRole.PLAYER);
        log.setDefender(GameRole.OPPONENT);
        log.setAttackValue(attackValue);
        log.setDefenseValue(defenseValue);
        log.setDamageValue(damageValue);
        log.setResult(success ? Result.SUCCESS : Result.FAILURE);

        // Set the foreign key to reference the battle id
        log.setBattle(battle);

        // Save the log entry in the database
        logService.save(log);

        // Return the updated battle
        return battle;
    }
}
