package com.desafio.dungeonsanddragons.battle.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BattlePostRequestDTO {
    private Long playerId;
    private Long opponentId;
}
