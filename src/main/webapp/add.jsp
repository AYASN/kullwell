<%--
  Created by IntelliJ IDEA.
  User: assir
  Date: 27/10/17
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Enter recipe details :</h1>
    <form action="/recipe/add" method="get">
        <input type="text" name="name" value="" />
        <input type="text" name="description" value="" />
        <input type="submit" name="addRecipe" value="Add Recipe"/>
    </form>

</body>
</html>
