package com.desafio.dungeonsanddragons.log.impl;

import com.desafio.dungeonsanddragons.log.LogModel;
import com.desafio.dungeonsanddragons.log.LogRepository;
import com.desafio.dungeonsanddragons.log.LogService;
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
    public List<LogModel> findByBattleId(Long battleId) {
        return logRepository.findAllBybattle_id(battleId);
    }
}
