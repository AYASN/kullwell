<%--
  Created by IntelliJ IDEA.
  User: assir
  Date: 27/10/17
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Edit the recipe info :</h1>
    <form action="/recipe/edit" method="get">
        <input type="hidden" name="id" value="${param.id}" />
        <input type="text" name="name" value="${param.name}" />
        <input type="text" name="description" value="${param.description}" />
        <input type="text" name="cuisine_type" value="${param.cuisine_type}" />
        <input type="submit" name="editRecipe" value="Edit Recipe"/>
    </form>

</head>
<body>

</body>
</html>