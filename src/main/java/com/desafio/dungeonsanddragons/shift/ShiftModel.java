package com.desafio.dungeonsanddragons.shift;

import com.desafio.dungeonsanddragons.battle.enums.GameRole;
import com.desafio.dungeonsanddragons.log.LogModel;
import com.desafio.dungeonsanddragons.log.enums.Action;
import com.desafio.dungeonsanddragons.log.enums.Result;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "shift")
public class ShiftModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private int shift;

    @Column(nullable = false)
    private Action action;

    @Column(nullable = false)
    private GameRole attacker;

    @Column(nullable = false)
    private GameRole defender;

    @Column
    private int attackValue;

    @Column
    private int defenseValue;

    @Column
    private int damageValue;

    @Column
    private Result result;

    @ManyToOne
    @JoinColumn(name="log_id", nullable=false)
    @JsonIgnore
    private LogModel log;
}
