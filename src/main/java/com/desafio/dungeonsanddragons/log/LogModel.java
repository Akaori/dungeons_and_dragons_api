package com.desafio.dungeonsanddragons.log;

import com.desafio.dungeonsanddragons.battle.BattleModel;
import com.desafio.dungeonsanddragons.log.enums.Action;
import com.desafio.dungeonsanddragons.log.enums.Result;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "log")
public class LogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private int shift;

    @Column(nullable = false)
    private Action action;

    @Column(nullable = false)
    private String attacker;

    @Column(nullable = false)
    private String defender;

    @Column
    private int modifier;

    @Column
    private int attackValue;

    @Column
    private int defenseValue;

    @Column
    private int damageValue;

    @Column
    private Result result;

    @ManyToOne
    @JoinColumn(name="battle_id", nullable=false)
    private BattleModel battle;
}
