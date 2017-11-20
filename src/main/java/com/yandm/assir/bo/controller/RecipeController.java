package com.yandm.assir.bo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.controller.impl.recipe.AddRecipeAction;
import com.yandm.assir.bo.controller.impl.recipe.EditRecipeAction;
import com.yandm.assir.bo.controller.impl.recipe.ReadRecipeAction;
import com.yandm.assir.bo.controller.impl.recipe.RemoveRecipeAction;
import com.yandm.assir.bo.controller.impl.recipe.ShowRecipeAction;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;

public class RecipeController extends HttpServlet {

   private RecipeService recipeService = new RecipeServiceImpl();
   private Map<String, Action> actions = new HashMap<>();

   @Override
   public void init() {
      actions.put("add", new AddRecipeAction());
      actions.put("edit", new EditRecipeAction());
      actions.put("remove", new RemoveRecipeAction());
      actions.put("read", new ReadRecipeAction());
      actions.put("show", new ShowRecipeAction());
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
   }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String operation = req.getPathInfo().substring(1);
      Action action = actions.get(operation);
      action.execute(req, resp);
   }
}
