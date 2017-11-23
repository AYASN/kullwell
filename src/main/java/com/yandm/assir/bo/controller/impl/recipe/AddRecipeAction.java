package com.yandm.assir.bo.controller.impl.recipe;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.common.base.Strings;
import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.bo.service.IngredientService;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.IngredientServiceImpl;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.model.Recipe;

public class AddRecipeAction implements Action {

    RecipeService recipeService = new RecipeServiceImpl();
    IngredientService ingredientService = new IngredientServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Recipe recipe;
        List<Ingredient> ingredients;

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String cuisineType = req.getParameter("cuisine_type");
        String[] ingredientsIds = req.getParameterValues("slcIngredients");

        if (Strings.isNullOrEmpty(name) || Strings.isNullOrEmpty(description)
                || Strings.isNullOrEmpty(cuisineType) || ingredientsIds == null) {

            req.setAttribute("addError", "Please fill in all recipe fields.");
            req.getRequestDispatcher("/admin/ingredient/retrieve/all").forward(req, resp);
        }else {
            String strIngredientsIds = convertFromTableToString(ingredientsIds);
            ingredients = ingredientService.getIngredientsById(strIngredientsIds);

            recipe = newRecipe(name, description, cuisineType, ingredients);
            recipeService.createRecipe(recipe);

            resp.sendRedirect("/admin/recipe/read");
        }
    }

    private String convertFromTableToString(String[] ingredientsIds) {
        String strIngredientsIds = ingredientsIds[0];
        for (int i=1; i<ingredientsIds.length; i++) {
            strIngredientsIds = strIngredientsIds + "," + ingredientsIds[i];
        }
        return strIngredientsIds;
    }

    private Recipe newRecipe(String name, String description, String cuisineType,
                             List<Ingredient> ingredients) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setCuisine_type(cuisineType);
        recipe.setIngredients(ingredients);
        return recipe;
    }
}
