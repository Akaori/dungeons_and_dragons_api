package com.desafio.dungeonsanddragons.character.runner;

import com.desafio.dungeonsanddragons.character.CharacterModel;
import com.desafio.dungeonsanddragons.character.CharacterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAndInsertSampleCharactersRunner  implements CommandLineRunner {

    private final CharacterRepository characterRepository;

    @Override
    public void run(String... args) throws Exception {
        if(characterRepository.count() > 1) return;

        // read json and write to db
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<CharacterModel>> typeReference = new TypeReference<List<CharacterModel>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/sample_characters.json");

        List<CharacterModel> characters = mapper.readValue(inputStream,typeReference);
        characterRepository.saveAll(characters);
        System.out.println("Sample characters Saved!");
    }
}