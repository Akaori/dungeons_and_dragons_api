package com.desafio.dungeonsanddragons.log;

import com.desafio.dungeonsanddragons.battle.BattleModel;
import com.desafio.dungeonsanddragons.shift.ShiftModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "log")
public class LogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String player;

    @Column(nullable = false)
    private String opponent;

    @Column(nullable = false)
    private String whoStarted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "battle_id", referencedColumnName = "id")
    @JsonIgnore
    private BattleModel battle;

    @OneToMany(mappedBy = "log", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShiftModel> shifts;
}
