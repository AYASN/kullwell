package com.yandm.assir.bo.controller.impl;

import com.google.common.base.Strings;
import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;
import com.yandm.assir.model.Recipe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class RemoveAction implements Action{

    RecipeService recipeService = new RecipeServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        if (Strings.isNullOrEmpty(String.valueOf(id))) {
            req.setAttribute("removeError", "Please select a recipe.");
        }else{
            req.setAttribute("removeSuccess", "Recipe is removed.");
            recipeService.removeRecipe(id);
        }
    }
}
