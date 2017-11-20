package com.yandm.assir.bo.controller.impl.recipe;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;
import com.yandm.assir.model.Recipe;

public class ShowRecipeAction implements Action{

   RecipeService recipeService = new RecipeServiceImpl();

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Set<Recipe> recipes = recipeService.getRecipes();
      req.setAttribute("recipes", recipes);
      req.getRequestDispatcher("/admin/showRecipe.jsp").forward(req, resp);
   }
}
