package com.yandm.assir.bo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.service.IngredientService;
import com.yandm.assir.bo.service.RecipeIngredientService;
import com.yandm.assir.bo.service.impl.IngredientServiceImpl;
import com.yandm.assir.bo.service.impl.RecipeIngredientServiceImpl;
import com.yandm.assir.model.Ingredient;

public class IngredientController extends HttpServlet {
    private IngredientService ingredientService = new IngredientServiceImpl();
    private RecipeIngredientService recipeIngredientService = new RecipeIngredientServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Ingredient> ingredients = ingredientService.getIngredients();
        req.setAttribute("ingredients", ingredients);

        String reqPathType = req.getPathInfo().substring(1);
        if (reqPathType.equalsIgnoreCase("edit")) {
            String recipeID = req.getParameter("id");
            List<Ingredient> ingredientsOfRecipeToEdit;
            ingredientsOfRecipeToEdit = recipeIngredientService.getIngredientsOfRecipe(Long.valueOf(recipeID));

            String strIngredientsIds;
            strIngredientsIds = extractIdsAndConvertToString(ingredientsOfRecipeToEdit);

            req.setAttribute("preSelectedIngredients", ingredientsOfRecipeToEdit);
            req.setAttribute("strPreSelectedIngredients", strIngredientsIds);
            req.getRequestDispatcher("/admin/edit.jsp").forward(req, resp);

        } else if (reqPathType.equalsIgnoreCase("add")){
            req.getRequestDispatcher("/admin/add.jsp").forward(req, resp);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private String extractIdsAndConvertToString(List<Ingredient> ingredientsOfRecipeToEdit) {
        String ingredientsIds = "";
        for (int i=0; i<ingredientsOfRecipeToEdit.size(); i++) {
            Long id = ingredientsOfRecipeToEdit.get(i).getId();
            ingredientsIds = ingredientsIds + id + ",";
        }
        return ingredientsIds;
    }
}
