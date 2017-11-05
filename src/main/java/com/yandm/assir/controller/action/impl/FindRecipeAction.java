package com.yandm.assir.controller.action.impl;

import static java.lang.Long.valueOf;
import static java.util.Arrays.asList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.controller.action.Action;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class FindRecipeAction implements Action {
   private RecipeService recipeService = new RecipeServiceImpl();

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Long[] ingredientIds = stringstoLongs(req.getParameterValues("ingredients"));

      Set<Recipe> recipesByIdIngredients = recipeService.getRecipesByIdIngredients(asList(ingredientIds));

      PrintWriter writer = resp.getWriter();
      writer.write("came here means we can do the work" + req.getParameterValues("ingredients"));
      writer.write("  .Is there something here: " + recipesByIdIngredients.size());
   }

   private Long[] stringstoLongs(String[] ingredients) {
      Long[] ingredientIds = new Long[ingredients.length];
      for (int i = 0; i < ingredients.length; i++) {
         ingredientIds[i] = valueOf(ingredients[i]);
      }
      return ingredientIds;
   }
}
