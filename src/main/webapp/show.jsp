<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Recipes By Ingredients</title>
</head>
<body>
   <table>
      <tr>
         <th>#</th>
         <th>Name</th>
         <th>Description</th>
         <th>Cuisine Type</th>
         <th>Ingredients</th>
      </tr>

      <c:forEach items="${recipes}" var="recipe">
         <tr>
            <td>${recipe.id}</td>
            <td>${recipe.name}</td>
            <td>${recipe.description}</td>
            <td>${recipe.cuisineType}</td>
            <td>${recipe.ingredients}</td>
         </tr>
      </c:forEach>
   </table>

</body>
</html>
