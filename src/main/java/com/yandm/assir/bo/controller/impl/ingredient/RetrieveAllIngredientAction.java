package com.yandm.assir.bo.controller.impl.ingredient;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.bo.service.IngredientService;
import com.yandm.assir.bo.service.impl.IngredientServiceImpl;
import com.yandm.assir.model.Ingredient;

public class RetrieveAllIngredientAction implements Action {
   private IngredientService ingredientService = new IngredientServiceImpl();

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Set<Ingredient> ingredients = ingredientService.getIngredients();
      req.setAttribute("ingredients", ingredients);

      req.getRequestDispatcher("/admin/addRecipe.jsp").forward(req, resp);
   }
}
