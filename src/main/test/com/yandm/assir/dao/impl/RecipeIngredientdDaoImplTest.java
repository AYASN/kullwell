package com.yandm.assir.dao.impl;

import com.yandm.assir.dao.RecipeIngredientDao;
import com.yandm.assir.model.Ingredient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeIngredientdDaoImplTest {

    @Test
    public void should_insert_ids() {
        RecipeIngredientDao recipeIngredientDao = new RecipeIngredientDaoImpl();
        List<Ingredient> actualIngrdIds = new ArrayList<>();
        List<Long> expectedIngrdIds = new ArrayList<>(Arrays.asList(1L, 2L, 3L));

        recipeIngredientDao.addIds(1L,1L);
        recipeIngredientDao.addIds(1L,2L);
        recipeIngredientDao.addIds(1L,3L);

        actualIngrdIds = recipeIngredientDao.getIngredientsOfRecipe(1L);

        assertThat(actualIngrdIds).isEqualTo(expectedIngrdIds);
    }
}
