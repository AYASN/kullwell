<%@ page import="com.yandm.assir.model.Recipe" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.yandm.assir.bo.dao.impl.RecipeDaoImpl" %>
<%@ page import="com.yandm.assir.bo.service.RecipeService" %>
<%@ page import="com.yandm.assir.bo.service.impl.RecipeServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <title>Welcome Page</title>

   <link rel = "stylesheet" href = "/styles/css/bootstrap.min.css" />
   <link rel="stylesheet" type="text/css" href="/styles/default.css">

</head>

<body>

<%
   RecipeService recipeService = new RecipeServiceImpl();
   Set<Recipe> recipes = recipeService.getRecipes();
   request.setAttribute("recipes", recipes);
%>

<div class="container-fluid display-table">
   <div class="row display-table-row">

      <jsp:include page="sideMenu.jsp"/>

      <div class="col-md-10 col-sm-11 box display-table-cell valign-top">

         <jsp:include page="header.jsp"/>

         <div id="content">
            <div id="content-inner">
               <div class="row">
                  <div class="col-md-12">
                     <div class="input-group">
                        <input type="text" name="name" id="inputID" class="form-control" placeholder="Search">
                        <span class="input-group-btn">
                           <button type="button" class="btn btn-primary">Go !</button>
                        </span>
                     </div>
                  </div>
               </div>

               <div class="row">
                  <div class="col-md-12">
                     <table class="table table-striped">
                        <tr>
                           <th>#</th>
                           <th>Name</th>
                           <th>Description</th>
                           <th>Cuisine type</th>
                           <th>Ingredients</th>
                        </tr>

                        <c:forEach items="${recipes}" var="recipe">
                           <tr>
                              <td>${recipe.id}</td>
                              <td>${recipe.name}</td>
                              <td>${recipe.description}</td>
                              <td>${recipe.cuisine_type}</td>
                              <td>
                                 <c:forEach items="${recipe.ingredients}" var="ingredient">
                                    ${ingredient.name},
                                 </c:forEach>
                              </td>
                           </tr>
                        </c:forEach>
                     </table>
                     <p class="pull-left">${alreadyLoggedIn}</p>
                  </div>
               </div>
            </div>
         </div>

         <jsp:include page="footer.jsp"/>

      </div>

     </div>
</div>

   <script src="../scripts/js/bootstrap.min.js"></script>
   <script src="../scripts/script.js"></script>

</body>
</html>