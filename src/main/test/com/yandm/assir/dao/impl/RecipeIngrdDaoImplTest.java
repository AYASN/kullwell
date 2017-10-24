package com.yandm.assir.dao.impl;

import com.yandm.assir.dao.RecipeIngrdDao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecipeIngrdDaoImplTest {

    @Test
    public void should_insert_ids() {
        RecipeIngrdDao recipeIngrdDao = new RecipeIngrdDaoImpl();
        List<Long> actualIngrdIds = new ArrayList<>(),
                expectedIngrdIds = new ArrayList<>(Arrays.asList(1L, 2L, 3L));

        recipeIngrdDao.addIds(1L,1L);
        recipeIngrdDao.addIds(1L,2L);
        recipeIngrdDao.addIds(1L,3L);

        actualIngrdIds = recipeIngrdDao.getIngredientsOfRecipe(1L);

        assertThat(actualIngrdIds).isEqualTo(expectedIngrdIds);
    }
}
