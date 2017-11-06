<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Enter recipe details :</h1>
    <form action="/recipe/add" method="post">
        <input type="text" name="name" value="" />
        <input type="text" name="description" value="" />
        <input type="text" name="cuisine_type" value="" />
        <select name="slcIngredients" multiple>
            <c:forEach items="${ingredients}" var="ingredient">
                <option value="${ingredient.id}">${ingredient.name}</option>
            </c:forEach>
        </select>
        <%--<c:set var="ingredients" value="${slcIngredients}"/>--%>
        <%--<%--%>
            <%--System.out.println(pageContext.getAttribute("ingredients"));--%>
        <%--%>--%>
        <input type="submit" name="addRecipe" value="Add Recipe"/>
    </form>
</body>
</html>