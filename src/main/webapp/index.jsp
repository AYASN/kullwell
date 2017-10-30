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
      </tr>

      <c:forEach items="${recipes}" var="recipe">
         <tr>
            <td>${recipe.id}</td>
            <td>${recipe.name}</td>
            <td>${recipe.description}</td>
            <td>${recipe.cuisine_type}</td>
            <td>
               <a href="/edit.jsp?id=${recipe.id}&name=${recipe.name}
               &description=${recipe.description}&cuisine_type=${recipe.cuisine_type}">Edit</a>
            </td>
            <td>
               <a href="/recipe/remove?id=${recipe.id}">Remove</a>
            </td>
         </tr>
      </c:forEach>
   </table>

   <form action="/urlofservlet" method="post">
      <input type="submit" name="addRecipe" value="Add Recipe"/>
   </form>

</body>
</html>