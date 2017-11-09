package com.yandm.assir.controller.impl;

import com.yandm.assir.controller.Action;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveAction implements Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        RecipeService recipeService = new RecipeServiceImpl();
        Long id = Long.valueOf(req.getParameter("id"));
        recipeService.removeRecipe(id);
    }
}