package com.yandm.assir.bo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;
import com.yandm.assir.bo.controller.impl.AddAction;
import com.yandm.assir.bo.controller.impl.EditAction;
import com.yandm.assir.bo.controller.impl.ReadAction;
import com.yandm.assir.bo.controller.impl.RemoveAction;
import com.yandm.assir.model.Recipe;

public class RecipeController extends HttpServlet {

   private RecipeService recipeService = new RecipeServiceImpl();
   private Map<String, Action> actions = new HashMap<>();

   @Override
   public void init() {
      actions.put("add", new AddAction());
      actions.put("edit", new EditAction());
      actions.put("remove", new RemoveAction());
      actions.put("read", new ReadAction());
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//      Set<Recipe> recipes = recipeService.getRecipes();
//      req.setAttribute("recipes", recipes);
//
//      req.getRequestDispatcher("/index.jsp").forward(req, resp);
   }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String operation = req.getPathInfo().substring(1);
      Action action = actions.get(operation);
      action.execute(req, resp);

      Set<Recipe> recipes = recipeService.getRecipes();
      req.setAttribute("recipes", recipes);

      req.getRequestDispatcher("/admin/read.jsp").forward(req, resp);
   }
}