package com.yandm.assir.controller.action.impl;

import static com.yandm.assir.utils.ControllerUtils.idsToLong;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.controller.action.Action;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class FindRecipesFromIngredientsAction implements Action {
   public static final String INGREDIENTS = "ingredients";
   private RecipeService recipeService = new RecipeServiceImpl();

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      List<Long> ingredientIds = idsToLong(req, INGREDIENTS);

      Set<Recipe> recipesByIdIngredients = recipeService.getRecipesByIdIngredients(ingredientIds);
      req.setAttribute("recipes", recipesByIdIngredients);

      req.getRequestDispatcher("/show.jsp")
            .forward(req, resp);
   }
}
