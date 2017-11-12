package com.yandm.assir.dao.impl;

import com.yandm.assir.bo.dao.RecipeDao;
import com.yandm.assir.bo.dao.impl.RecipeDaoImpl;
import com.yandm.assir.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeDaoImplTest {

    private Recipe recipe;

    @Before
    public void setUp() {
        recipe = exampleOfRecipe("Tomato_Salad");
    }

    @Test
    public void should_insert_a_recipe() {

        RecipeDao recipeDao = new RecipeDaoImpl();
        recipeDao.addRecipe(recipe);

        Recipe recipe = exampleOfRecipe("Tomato_Pasta");
        recipeDao.addRecipe(recipe);

        Recipe result1 = recipeDao.getRecipeByName("Tomato_Galette");
        Recipe result2 = recipeDao.getRecipeByName("Tomato_Salad");
        Recipe result3 = recipeDao.getRecipeByName("Tomato_Pasta");

        assertThat(result1.getId())
                .isEqualTo(10);
        assertThat(result1.getName()).isEqualTo("Tomato_Galette");

        assertThat(result2.getId())
                .isEqualTo(19);
        assertThat(result2.getName()).isEqualTo("Tomato_Salad");

        assertThat(result3.getId())
                .isEqualTo(20);
        assertThat(result3.getName()).isEqualTo("Tomato_Pasta");
    }


    private Recipe exampleOfRecipe(String name) {
        recipe = new Recipe();
        recipe.setName(name);

        return recipe;
    }
}