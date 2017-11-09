package com.yandm.assir.controller.impl;

import com.yandm.assir.controller.Action;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class ReadAction implements Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeServiceImpl();
        Set<Recipe> recipes = recipeService.getRecipes();
        req.setAttribute("recipes", recipes);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}