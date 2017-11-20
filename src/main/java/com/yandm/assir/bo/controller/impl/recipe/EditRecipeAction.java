package com.yandm.assir.bo.controller.impl.recipe;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.bo.service.IngredientService;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.IngredientServiceImpl;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.model.Recipe;

public class EditRecipeAction implements Action{

    RecipeService recipeService = new RecipeServiceImpl();
    IngredientService ingredientService = new IngredientServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write("I'm in the edit action");
        String nextAction = req.getParameter("nextAction");
        if (nextAction.equals("ok") || nextAction.equals("cancel")) {
            req.getRequestDispatcher("/admin/recipe/show");
        }
        if (nextAction.equals("ko")) {
            req.getRequestDispatcher("/admin/recipe/edit");
        }
        /*List<Ingredient> ingredients;

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String cuisineType = req.getParameter("cuisine_type");
        String[] ingredientsIds = req.getParameterValues("slcIngredients");

        if (Strings.isNullOrEmpty(id) || Strings.isNullOrEmpty(name) || Strings.isNullOrEmpty(description)
                || Strings.isNullOrEmpty(cuisineType) || ingredientsIds == null) {

            req.setAttribute("editError", "Please fill in all fields of recipe to edit.");
            req.getRequestDispatcher("/admin/getIngredients/edit").forward(req, resp);
        } else {
            String strIngredientsIds = convertFromTableToString(ingredientsIds);
            ingredients = ingredientService.getIngredientsById(strIngredientsIds);

            Recipe recipe = newRecipe(Long.valueOf(id), name, description, cuisineType, ingredients);
            recipeService.editRecipe(recipe);
        }*/
    }

    private Recipe newRecipe(Long id, String name, String description, String cuisineType,
                             List<Ingredient> ingredients) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setCuisine_type(cuisineType);
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