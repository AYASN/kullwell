package com.yandm.assir.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.yandm.assir.dao.IngredientDao;
import com.yandm.assir.model.Ingredient;

public class IngredientDaoImplTest {
   private Ingredient ingredient;

   @Before
   public void setUp() {
      ingredient = dummyIngredient(6, "Tomato");
   }

   @After
   public void tearDown() {
      System.out.println("show something");
   }

   @Test
   public void should_insert_an_ingredient() {

      IngredientDao ingredientDao = new IngredientDaoImpl();
      ingredientDao.addIngredient(ingredient);

      Ingredient result = ingredientDao.getIngredientById(6);

      assertThat(result.getId())
            .isEqualTo(6);
      assertThat(result.getName()).isEqualToIgnoringCase("tomato");
   }

   @Test
   public void should_update_an_ingredient(){

      IngredientDao ingredientDao = new IngredientDaoImpl();
      ingredient = dummyIngredient(7, "Potatoe");
      ingredientDao.editIngredient(ingredient);

      Ingredient updateResult = ingredientDao.getIngredientById(7);

      assertThat(updateResult.getId())
              .isEqualTo(7);
      assertThat(updateResult.getName()).isEqualTo("Potatoe");
   }

   @Test
   public void should_delete_an_ingredient() {

      IngredientDao ingredientDao = new IngredientDaoImpl();
      Ingredient beforeDeleteResult = ingredientDao.getIngredientById(2);

      ingredientDao.removeIngredient(2);

      Ingredient deleteResult = ingredientDao.getIngredientById(2);

      assertThat(deleteResult.getId())
              .isEqualTo(null);
      assertThat(deleteResult.getName()).isEqualTo(null);
   }

   public Ingredient dummyIngredient(long id, String name) {
      ingredient = new Ingredient();
      ingredient.setId(id);
      ingredient.setName(name);
      return ingredient;
   }
}
