<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Edit the recipe info :</h1>
    <form action="/admin/recipe/edit" method="post">
        <input type="hidden" name="id" value="${param.id}" />
        <input type="text" name="name" value="${param.name}" />
        <input type="text" name="description" value="${param.description}" />
        <input type="text" name="cuisine_type" value="${param.cuisine_type}" />

        <%--<c:set var="strSelectedIngredients" value="${strSelectedIngredients}"/>--%>
        <select name="slcIngredients" multiple>
            <c:forEach items="${ingredients}" var="ingredient">
                <c:set var = "ingredientID" value = "${ingredient.id}"/>
                <c:choose>
                    <c:when test="${fn:contains(strPreSelectedIngredients, ingredientID)}">
                        <option value="${ingredient.id}" selected>${ingredient.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${ingredient.id}">${ingredient.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>

        <input type="submit" name="editRecipe" value="Edit Recipe"/>
    </form>

    <p>Selected ingredients for this recipe :</p><br>
    <c:forEach items="${preSelectedIngredients}" var="ingredient">
        ${ingredient.name},
    </c:forEach>
    <br>
    <p>${strPreSelectedIngredients}</p>

    <c:set var = "strPreSelectedIngredients" value = "${strPreSelectedIngredients}"/>
</head>
<body>
</body>
</html>