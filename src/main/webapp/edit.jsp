<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Edit the recipe info :</h1>
    <form action="/recipe/edit" method="get">
        <input type="hidden" name="id" value="${param.id}" />
        <input type="text" name="name" value="${param.name}" />
        <input type="text" name="description" value="${param.description}" />
        <input type="text" name="cuisineType" value="${param.cuisineType}" />
        <select name="ingredients" multiple>
            <c:forEach items="${ingredients}" var="ingredient">
                <option value="${ingredient.id}">${ingredient.name}</option>
            </c:forEach>
        </select>

        <input type="submit" name="editRecipe" value="Edit Recipe"/>
    </form>

    <p>Selected ingredients for this recipe :</p><br>
    <c:forEach items="${selectedIngredients}" var="ingredient">
        ${ingredient},
    </c:forEach>
</head>
<body>
</body>
</html>