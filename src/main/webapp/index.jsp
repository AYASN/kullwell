<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <title>Welcome Page</title>
</head>
<body>
   <h1>Al Salamo Alykom from the jsp</h1>
   <h2>
      <form action="/recipe/read" method="post">
         <input type="submit" name="readRecipe" value="Show Recipes"/>
      </form>
   </h2>
      <%--<a href="/recipe/read">Show Recipes</a>--%>

   <h1>${recipes}</h1>

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

   <form action="/getIngredients/add" method="post">
      <input type="submit" name="addRecipe" value="Add Recipe"/>
   </form>
   <br>

</body>
</html>