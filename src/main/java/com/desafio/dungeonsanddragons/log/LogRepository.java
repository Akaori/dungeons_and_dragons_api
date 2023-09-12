package com.desafio.dungeonsanddragons.log;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<LogModel, Long> {
    LogModel findBybattle_id(Long battle_id);
}
