package com.desafio.dungeonsanddragons.battle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleRepository extends JpaRepository<BattleModel, Long> {
}
