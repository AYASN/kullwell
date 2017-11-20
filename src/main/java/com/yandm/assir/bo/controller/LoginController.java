package com.yandm.assir.bo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.common.base.Strings;
import com.yandm.assir.bo.service.RecipeService;
import com.yandm.assir.bo.service.UserService;
import com.yandm.assir.bo.service.impl.RecipeServiceImpl;
import com.yandm.assir.bo.service.impl.UserServiceImpl;
import com.yandm.assir.model.User;

public class LoginController extends HttpServlet {

   private UserService userService = new UserServiceImpl();
   private RecipeService recipeService = new RecipeServiceImpl();



   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

   }

   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String username = req.getParameter("username");
      String password = req.getParameter("password");
      User user = new User();

      if (Strings.isNullOrEmpty(username) || Strings.isNullOrEmpty(password)) {
         req.setAttribute("nullOrEmptyError", "Please fill in all fields");
         req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
      }else {
         user.setUsername(username);
         user.setPassword(password);
         if (userService.isFound(user)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

//            Set<Recipe> recipes = recipeService.getRecipes();
//            req.setAttribute("recipes", recipes);
////            req.getRequestDispatcher("/admin/recipe/show").forward(req, resp);
            resp.sendRedirect("/admin/recipe/show");
         } else {
            req.setAttribute("userNotFoundError", "Incorrect username or password");
            req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
         }
      }
   }
}