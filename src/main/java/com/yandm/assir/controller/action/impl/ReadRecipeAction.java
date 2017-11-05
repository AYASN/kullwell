package com.yandm.assir.controller.action.impl;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.controller.action.Action;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class ReadRecipeAction implements Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeServiceImpl();
        Set<Recipe> recipes = recipeService.getRecipes();
        req.setAttribute("recipes", recipes);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}