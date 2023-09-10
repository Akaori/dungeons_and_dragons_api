package com.desafio.dungeonsanddragons.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI dungeonsAndDragonsMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Dungeons and Dragons API")
                        .description("API Rest usando Java SpringBoot com banco de dados Postgres")
                        .version("1.0"));
    }
}
