package com.yandm.assir.bo.controller.impl.recipe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.controller.Action;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;

public class RemoveRecipeAction implements Action{

    RecipeService recipeService = new RecipeServiceImpl();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("I'm in the remove action");
       /* Long id = Long.valueOf(req.getParameter("id"));
        if (Strings.isNullOrEmpty(String.valueOf(id))) {
            req.setAttribute("removeError", "Please select a recipe.");
        }else{
            req.setAttribute("removeSuccess", "Recipe is removed.");
            recipeService.removeRecipe(id);
        }*/
    }
}
