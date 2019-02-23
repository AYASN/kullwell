package com.yandm.assir.configuration;

import com.yandm.assir.service.RecipeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class AppConfigurationTest {

    @Autowired
    private AppConfiguration appConfiguration;

    @Test
    public void should_initialize_the_spring_context() {
        RecipeService recipeService = appConfiguration.recipeService();

        assertThat(recipeService).isNotNull();
    }
}