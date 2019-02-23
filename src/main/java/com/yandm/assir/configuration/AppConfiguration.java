package com.yandm.assir.configuration;

import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public RecipeService recipeService() {
        return new RecipeServiceImpl();
    }
}