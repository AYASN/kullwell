package com.yandm.assir.dao.impl;

import com.yandm.assir.dao.IngredientDao;
import com.yandm.assir.model.Ingredient;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientDaoImplTest {

   @Test
   public void should_insert_an_ingredient() {
      // TODO: insert ingredient, get the ingredient, check that it's the same one
      IngredientDao ingredientDao = new IngredientDaoImpl();

      ingredientDao.addIngredient(dummyIngredient(1, "tomato", 150, "winter"));

      Set<Ingredient> result = ingredientDao.getIngredients();

      assertThat(result.iterator().next().getId()).isEqualTo(1);
      //result id must be equal to one
   }

   @Test
   public void should_update_an_ingredient() {

      IngredientDao ingredientDao = new IngredientDaoImpl();
//      ingredientDao.editIngredient(ingredient);

//      Ingredient updateResult = ingredientDao.getIngredientById(7);
//
//      assertThat(updateResult.getId())
//              .isEqualTo(7);
//      assertThat(updateResult.getName()).isEqualTo("Potatoe");
   }

   @Test
   public void should_delete_an_ingredient() {

      IngredientDao ingredientDao = new IngredientDaoImpl();
//      Ingredient beforeDeleteResult = ingredientDao.getIngredientById(2);

      ingredientDao.removeIngredient(2);

//      Ingredient deleteResult = ingredientDao.getIngredientById(2);

//      assertThat(deleteResult.getId())
//              .isEqualTo(null);
//      assertThat(deleteResult.getName()).isEqualTo(null);
   }

   public Ingredient dummyIngredient(long id, String name, int calories, String season) {
      Ingredient ingredient = new Ingredient();
      ingredient.setId(id);
      ingredient.setName(name);
      ingredient.setCalories(calories);
      ingredient.setSeason(season);
      return ingredient;
   }
}
