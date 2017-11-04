package com.yandm.assir.controller;

import com.yandm.assir.model.Ingredient;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.IngredientService;
import com.yandm.assir.service.impl.IngredientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "IngredientController")
public class IngredientController extends HttpServlet {
    private IngredientService ingredientService = new IngredientServiceImpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<Ingredient> ingredients = ingredientService.getIngredients();
        req.setAttribute("ingredients", ingredients);

        String[] selectedIngredients = req.getParameterValues("ingredients");
        String strIngredientsIds = null;
        if (selectedIngredients != null) {
            strIngredientsIds = String.join(",", selectedIngredients);
        }

        req.setAttribute("selectedIngredients", selectedIngredients);
        req.setAttribute("strSelectedIngredients", strIngredientsIds);

        String reqPathType = req.getPathInfo().substring(1);
        if (reqPathType.equalsIgnoreCase("edit")) {
            req.getRequestDispatcher("/edit.jsp").forward(req, resp);
        } else if (reqPathType.equalsIgnoreCase("add")){
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        }
    }
}