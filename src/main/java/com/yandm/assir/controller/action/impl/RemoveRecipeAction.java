package com.yandm.assir.controller.action.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.controller.action.Action;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class RemoveRecipeAction implements Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        RecipeService recipeService = new RecipeServiceImpl();
        Long id = Long.valueOf(req.getParameter("id"));
        recipeService.removeRecipe(id);
    }
}