package com.yandm.assir.controller.Impl;

import com.yandm.assir.controller.Action;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveAction implements Action{

    RecipeService recipeService = new RecipeServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        Long id = Long.valueOf(req.getParameter("id"));
        recipeService.removeRecipe(id);
    }
}
