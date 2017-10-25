package com.yandm.assir.controller;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class RecipeController extends HttpServlet {

   private RecipeService recipeService = new RecipeServiceImpl();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Set<Recipe> recipes = recipeService.getRecipes();
      req.setAttribute("recipes", recipes);

      req.getRequestDispatcher("/index.jsp").forward(req, resp);
   }

}
