package com.yandm.assir.bo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yandm.assir.bo.controller.impl.ingredient.RetrieveAllIngredientAction;
import com.yandm.assir.bo.controller.impl.ingredient.RetrieveFromRecipeIngredientAction;

public class IngredientController extends HttpServlet {
   private Map<String, Action> actions = new HashMap<>();

   @Override
   public void init() {
      actions.put("all", new RetrieveAllIngredientAction());
      actions.put("forRecipe", new RetrieveFromRecipeIngredientAction());
   }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String operation = getAction(req.getPathInfo());
      Action action = actions.get(operation);
      action.execute(req, resp);
   }


   private String getAction(String pathInfo) {
      return pathInfo.split("/")[2];
   }
}
