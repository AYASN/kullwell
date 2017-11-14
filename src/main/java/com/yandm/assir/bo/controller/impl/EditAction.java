package com.yandm.assir.bo.controller.impl;

import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.bo.service.IngredientService;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.IngredientServiceImpl;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class EditAction implements Action{

    RecipeService recipeService = new RecipeServiceImpl();
    IngredientService ingredientService = new IngredientServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

        List<Ingredient> ingredients = new ArrayList<>();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String cuisine_type = req.getParameter("cuisine_type");

        String[] ingredientsIds = req.getParameterValues("slcIngredients");
        String strIngredientsIds = convertFromTableToString(ingredientsIds);

        ingredients = ingredientService.getIngredientsById(strIngredientsIds);

        Recipe recipe = newRecipe(Long.valueOf(id), name, description, cuisine_type, ingredients);
        recipeService.editRecipe(recipe);
    }

    private Recipe newRecipe(Long id, String name, String description, String cuisine_type,
                             List<Ingredient> ingredients) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setCuisine_type(cuisine_type);
        recipe.setIngredients(ingredients);
        return recipe;
    }

    private String convertFromTableToString(String[] ingredientsIds) {
        String strIngredientsIds = ingredientsIds[0];
        for (int i=1; i<ingredientsIds.length; i++) {
            strIngredientsIds = strIngredientsIds + "," + ingredientsIds[i];
        }
        return strIngredientsIds;
    }
}