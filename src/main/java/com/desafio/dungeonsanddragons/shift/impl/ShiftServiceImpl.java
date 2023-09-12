package com.desafio.dungeonsanddragons.shift.impl;

import com.desafio.dungeonsanddragons.shift.ShiftModel;
import com.desafio.dungeonsanddragons.shift.ShiftRepository;
import com.desafio.dungeonsanddragons.shift.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ShiftServiceImpl implements ShiftService {

    private final ShiftRepository shiftRepository;
    @Override
    public ShiftModel save(ShiftModel shift) {
        return shiftRepository.save(shift);
    }
}
