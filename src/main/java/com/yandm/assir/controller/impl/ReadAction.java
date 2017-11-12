package com.yandm.assir.controller.impl;

import com.yandm.assir.controller.Action;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class ReadAction implements Action{

    RecipeService recipeService = new RecipeServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Recipe> recipes = recipeService.getRecipes();
        req.setAttribute("recipes", recipes);

//        req.getRequestDispatcher("/read.jsp").forward(req, resp);

    }
}