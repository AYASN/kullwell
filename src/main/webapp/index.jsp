<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <title>Welcome Page</title>
</head>
<body>
   <h1>Al Salamo Alykom from the jsp</h1>
   <h2><a href="/recipe/read">Show Recipes</a></h2>
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
                  ${ingredient},
               </c:forEach>
            </td>
            <td>
               <a href="/getIngredients/edit?id=${recipe.id}&name=${recipe.name}
               &description=${recipe.description}&cuisine_type=${recipe.cuisine_type}
               &ingredients=${recipe.ingredients}">Edit</a>
            </td>
            <td>
               <a href="/recipe/remove?id=${recipe.id}">Remove</a>
            </td>
         </tr>

      </c:forEach>
   </table>

   <form action="/getIngredients/add" method="get">
      <input type="submit" name="addRecipe" value="Add Recipe"/>
   </form>
   <br>

</body>
</html>