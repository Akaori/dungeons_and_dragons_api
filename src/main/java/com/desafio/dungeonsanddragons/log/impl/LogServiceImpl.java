package com.desafio.dungeonsanddragons.log.impl;

import com.desafio.dungeonsanddragons.battle.exceptions.BattleNotFoundException;
import com.desafio.dungeonsanddragons.log.LogModel;
import com.desafio.dungeonsanddragons.log.LogRepository;
import com.desafio.dungeonsanddragons.log.LogService;
import com.desafio.dungeonsanddragons.log.exceptions.LogNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    @Override
    public LogModel save(LogModel log) {
        return logRepository.save(log);
    }

    @Override
    public LogModel findByBattleId(Long battleId) {
        var log = logRepository.findBybattle_id(battleId);

        if (log != null) {
            return log;
        } else {
            throw new LogNotFoundException(battleId);
        }
    }
}
