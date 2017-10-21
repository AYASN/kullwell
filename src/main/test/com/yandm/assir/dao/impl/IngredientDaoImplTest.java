package com.yandm.assir.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.yandm.assir.dao.IngredientsDao;
import com.yandm.assir.model.Ingredient;

public class IngredientDaoImplTest {
   private Ingredient ingredient;

   @Before
   public void setUp() {
//      String urlDbFile = getClass().getResource("/kullWellTest.db").getPath();
//      Connection connection = ConnectionFactory.getConnection("jdbc:sqlite:" + urlDbFile);
      ingredient = dummyIngredient();
   }

   @After
   public void tearDown() {
      System.out.println("show something");
   }

   @Test
   public void should_insert_an_ingredient() {

      IngredientsDao ingredientsDao = new IngredientDaoImpl();
      ingredientsDao.addIngredient(ingredient);

      Ingredient result = ingredientsDao.getIngredientById(1);

      assertThat(result.getId())
            .isEqualTo(1);
      assertThat(result.getName()).isEqualToIgnoringCase("tomato");
   }

   public Ingredient dummyIngredient() {
      ingredient = new Ingredient();
      ingredient.setId(1L);
      ingredient.setName("Tomato");
      return ingredient;
   }
}
