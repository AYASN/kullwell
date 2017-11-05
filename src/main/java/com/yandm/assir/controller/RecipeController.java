package com.yandm.assir.controller;

import static com.yandm.assir.utils.ControllerUtils.getActionFromPath;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.controller.action.Action;
import com.yandm.assir.controller.action.impl.AddRecipeAction;
import com.yandm.assir.controller.action.impl.EditRecipeAction;
import com.yandm.assir.controller.action.impl.FindRecipeAction;
import com.yandm.assir.controller.action.impl.ReadRecipeAction;
import com.yandm.assir.controller.action.impl.RemoveRecipeAction;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class RecipeController extends HttpServlet {

   private RecipeService recipeService = new RecipeServiceImpl();
   private Map<String, Action> actions = new HashMap<>();

   @Override
   public void init() {
      actions.put("add", new AddRecipeAction());
      actions.put("edit", new EditRecipeAction());
      actions.put("remove", new RemoveRecipeAction());
      actions.put("read", new ReadRecipeAction());
      actions.put("find", new FindRecipeAction());
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String operation = getActionFromPath(req.getPathInfo());
      Action action = actions.get(operation);
      if (action != null) {
         action.execute(req, resp);
      }
   }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Set<Recipe> recipes = recipeService.getRecipes();
      req.setAttribute("recipes", recipes);

      String operation = getActionFromPath(req.getPathInfo());
      Action action = actions.get(operation);
      action.execute(req, resp);

//      req.getRequestDispatcher("/index.jsp").forward(req, resp);
   }
}