package com.yandm.assir.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yandm.assir.controller.Impl.AddAction;
import com.yandm.assir.controller.Impl.EditAction;
import com.yandm.assir.controller.Impl.ReadAction;
import com.yandm.assir.controller.Impl.RemoveAction;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

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

      String operation = req.getPathInfo().substring(1);
      Action action = actions.get(operation);
      action.execute(req, resp);

      Set<Recipe> recipes = recipeService.getRecipes();
      req.setAttribute("recipes", recipes);

      req.getRequestDispatcher("/index.jsp").forward(req, resp);
   }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      Set<Recipe> recipes = recipeService.getRecipes();
      req.setAttribute("recipes", recipes);

      req.getRequestDispatcher("/index.jsp").forward(req, resp);
   }
}