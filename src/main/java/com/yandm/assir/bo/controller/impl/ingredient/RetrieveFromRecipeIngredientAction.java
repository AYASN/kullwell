package com.yandm.assir.bo.controller.impl.ingredient;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.bo.service.RecipeIngredientService;
import com.yandm.assir.bo.service.impl.RecipeIngredientServiceImpl;
import com.yandm.assir.model.Ingredient;

public class RetrieveFromRecipeIngredientAction implements Action {

   private RecipeIngredientService recipeIngredientService = new RecipeIngredientServiceImpl();

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String recipeID = req.getParameter("id");
      List<Ingredient> ingredientsOfRecipeToEdit;
      ingredientsOfRecipeToEdit = recipeIngredientService.getIngredientsOfRecipe(Long.valueOf(recipeID));

      String strIngredientsIds;
      strIngredientsIds = fromIdsToString(ingredientsOfRecipeToEdit);

      req.setAttribute("preSelectedIngredients", ingredientsOfRecipeToEdit);
      req.setAttribute("strPreSelectedIngredients", strIngredientsIds);
      req.getRequestDispatcher("/admin/editRecipe.jsp").forward(req, resp);
   }

   private String fromIdsToString(List<Ingredient> ingredientsOfRecipeToEdit) {
      String ingredientsIds = "";
      for (int i=0; i<ingredientsOfRecipeToEdit.size(); i++) {
         Long id = ingredientsOfRecipeToEdit.get(i).getId();
         ingredientsIds = ingredientsIds + id + ",";
      }
      return ingredientsIds;
   }
}
