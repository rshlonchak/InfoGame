package com.example.infogame.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@Configuration
@Import(DatabaseConfig.class)
public class AppConfig {

    @Bean
    ValidatorFactory validatorFactory() {
        return Validation.buildDefaultValidatorFactory();
    }

}
