package com.desafio.dungeonsanddragons.battle;

import com.desafio.dungeonsanddragons.battle.enums.BattleInitiative;
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
    private BattleInitiative initiative;

    @Column
    private String log;

    @Column
    private String winner;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private CharacterModel character;

    @ManyToOne
    @JoinColumn(name = "opponent_id", nullable = false)
    private CharacterModel opponent;

    @OneToMany(mappedBy = "battle")
    private List<LogModel> logs;
}
