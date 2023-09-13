package com.desafio.dungeonsanddragons.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterModel, Long> {
    @Query(value = "select c.id from CharacterModel c where c.role = 1")
    List<Long> findMonstersIds();
}
