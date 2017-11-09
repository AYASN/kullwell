package com.yandm.assir.controller;

import static com.yandm.assir.utils.ControllerUtils.getActionFromPath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.controller.action.Action;
import com.yandm.assir.controller.action.impl.FindRecipesFromIngredientsAction;
import com.yandm.assir.controller.action.impl.ShowIngredientsAction;
import com.yandm.assir.service.IngredientService;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.IngredientServiceImpl;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class RecipeIngredientController extends HttpServlet {

   private RecipeService recipeService = new RecipeServiceImpl();
   private IngredientService ingredientService = new IngredientServiceImpl();
   private Map<String, Action> actions = new HashMap<>();

   @Override
   public void init() throws ServletException {
      actions.put("show", new ShowIngredientsAction());
      actions.put("find", new FindRecipesFromIngredientsAction());
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String operation = getActionFromPath(request.getPathInfo());
      Action action = actions.get(operation);

      action.execute(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String operation = getActionFromPath(request.getPathInfo());
      Action action = actions.get(operation);
      action.execute(request, response);
   }
}
