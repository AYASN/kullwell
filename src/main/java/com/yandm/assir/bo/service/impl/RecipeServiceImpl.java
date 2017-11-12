package com.yandm.assir.bo.service.impl;

import java.util.Set;
import com.yandm.assir.bo.dao.RecipeDao;
import com.yandm.assir.bo.dao.RecipeIngredientDao;
import com.yandm.assir.bo.dao.impl.RecipeDaoImpl;
import com.yandm.assir.bo.dao.impl.RecipeIngredientDaoImpl;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.bo.service.RecipeService;

public class RecipeServiceImpl implements RecipeService {
   private RecipeDao recipeDao = new RecipeDaoImpl();
   private RecipeIngredientDao recipeIngredientDao = new RecipeIngredientDaoImpl();

   @Override
   public Set<Recipe> getRecipes() {
      return recipeDao.getRecipes();
   }

   @Override
   public void createRecipe(Recipe recipe) {
      Long recipeID =  recipeDao.addRecipe(recipe);
      recipeIngredientDao.insertIngredientsOfRecipeIds(recipe.getIngredients(), recipeID);
   }

   @Override
   public void editRecipe(Recipe recipe) {
      recipeDao.editRecipe(recipe);
      recipeIngredientDao.editIngredientsOfRecipe(recipe.getIngredients(), recipe.getId());
   }

   @Override
   public void removeRecipe(Long id) {
      recipeDao.removeRecipe(id);
   }
}
