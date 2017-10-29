package com.yandm.assir.controller.Impl;

import com.yandm.assir.controller.Action;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAction implements Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        RecipeService recipeService = new RecipeServiceImpl();
        Recipe recipe;
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String cuisine_type = req.getParameter("cuisine_type");

        recipe = newRecipe(name, description, cuisine_type);
        recipeService.createRecipe(recipe);
    }

    private Recipe newRecipe(String name, String description, String cuisine_type) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setCuisine_type(cuisine_type);
        return recipe;
    }
}
