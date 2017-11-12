<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <title>Welcome Page</title>

   <link rel = "stylesheet" href = "/styles/css/bootstrap.min.css" />
   <link rel="stylesheet" type="text/css" href="/styles/default.css">

</head>

<body>
<div class="container-fluid display-table">
   <div class="row display-table-row">
      <div class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top" id="side-menu">
         <h1 class="hidden-sm hidden-xs">Al Salamo Alykom from the jsp</h1>
         <ul>
            <li class="link active">
               <a href="index.jsp">
                  <span class="glyphicon glyphicon-th" aria-hidden="true"></span>
                  <span class="hidden-sm hidden-xs">Dashboard</span>
               </a>
            </li>
            <li class="link">
               <a>
                  <form action="/recipe/read" method="post">
                     <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                     <input type="submit" name="readRecipe" value="Show Recipes"/>
                  </form>
               </a>
            </li>
            <li class="link">
               <a>
                  <form action="/getIngredients/add" method="post">
                     <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                     <input type="submit" name="addRecipe" value="Add Recipe"/>
                     <%--<span>Add recipe</span>--%>
                  </form>
               </a>
            </li>
            <li class="link settings-btn">
               <a href="settings.html">
                  <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                  <span class="hidden-sm hidden-xs" >Settings</span>
               </a>
            </li>
         </ul>

         <h1>${recipes}</h1>
      </div>

      <div class="col-md-10 col-sm-11 box display-table-cell valign-top">
         <div class="row">
            <header id="nav-header" class="clearfix">
               <div class="col-md-5">
                  <nav class="navbar-default pull-left">
                     <button type="button" class="navbar-toggle collapsed" data-toggle="offcanvas" data-target="#side-menu">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                     </button>
                  </nav>
                  <input type="text" class="hidden-sm hidden-xs" id="header-search-field" placeholder="Search for something...">
               </div>

               <div class="col-md-7">
                  <ul class="pull-right" >
                     <li id="welcome" class="hidden-xs">Welcome to your administration area</li>
                     <li class="fixed-width">
                        <a href="#">
                           <span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
                           <span class="label label-warning">3</span>
                        </a>
                     </li>
                     <li class="fixed-width">
                        <a href="#">
                           <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                           <span class="label label-message">3</span>
                        </a>
                     </li>
                     <li>
                        <a href="#" class="logout">
                           <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                           Log out
                        </a>
                     </li>
                  </ul>
               </div>
            </header>
         </div>

         <table>
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
                  <td>
                     <form action="/getIngredients/edit" method="post">
                        <input hidden name="id" value="${recipe.id}">
                        <input hidden name="name" value="${recipe.name}">
                        <input hidden name="description" value="${recipe.description}">
                        <input hidden name="cuisine_type" value="${recipe.cuisine_type}">
                        <input type="submit" name="editRecipe" value="Edit"/>
                     </form>
                  </td>
                  <td>
                        <%--<a href="/recipe/remove?id=${recipe.id}">Remove</a>--%>
                     <form action="/recipe/remove" method="post">
                        <input hidden name="id" value="${recipe.id}">
                        <input type="submit" name="removeRecipe" value="Remove"/>
                     </form>
                  </td>
               </tr>
            </c:forEach>
         </table>

         <br>

         <div class="row">
            <footer id="admin-footer" class="clearfix">
               <div class="pull-left"><b>Copyrignt</b>&copy; 2015</div>
               <div class="pull-right">Admin system</div>
            </footer>
         </div>

      </div>
   </div>
</div>

   <script src="scripts/js/bootstrap.min.js"></script>
   <script src="scripts/script.js"></script>

</body>
</html>