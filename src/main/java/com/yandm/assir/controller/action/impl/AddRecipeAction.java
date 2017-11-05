package com.yandm.assir.controller.action.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.controller.action.Action;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;
import com.yandm.assir.service.impl.RecipeServiceImpl;

public class AddRecipeAction implements Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        RecipeService recipeService = new RecipeServiceImpl();
        Recipe recipe;

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String cuisine_type = req.getParameter("cuisine_type");

        //get selected ingredients also to store with recipe object
        String[] ingredientsIds = req.getParameterValues("ingredients");
        List<Long> longIngredientsIds = new ArrayList<>();

        Long ingredientsId;
        for (int i=0; i < ingredientsIds.length; i++) {
            ingredientsId = Long.parseLong(ingredientsIds[i].trim());
            longIngredientsIds.add(ingredientsId);
        }

        recipe = newRecipe(name, description, cuisine_type, longIngredientsIds);

        recipeService.createRecipe(recipe);
    }

    private Recipe newRecipe(String name, String description, String cuisine_type, List<Long> longIngredientsIds) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setCuisineType(cuisine_type);
        recipe.setIngredients(longIngredientsIds);
        return recipe;
    }
}
