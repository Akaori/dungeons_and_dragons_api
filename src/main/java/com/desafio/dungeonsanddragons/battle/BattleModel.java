package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.enums.GameRole;
import com.desafio.dungeonsanddragons.battle.enums.BattleStatus;
import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.log.LogModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "battle")
public class BattleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private BattleStatus status;

    @Column(nullable = false)
    private int shift;

    @Column(nullable = false)
    private GameRole initiative;

    @Column
    private GameRole winner;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private CharacterModel player;

    @ManyToOne
    @JoinColumn(name = "opponent_id", nullable = false)
    private CharacterModel opponent;

    @OneToOne(mappedBy = "battle", cascade = CascadeType.ALL)
    private LogModel log;
}
