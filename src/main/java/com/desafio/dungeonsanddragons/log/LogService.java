package com.desafio.dungeonsanddragons.log;

import java.util.List;

public interface LogService {
    LogModel save(LogModel log);

    LogModel findByBattleId(Long battleId);
}
