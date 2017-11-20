<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel = "stylesheet" href = "/styles/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/styles/default.css">
    <link rel="stylesheet" type="text/css" href="/styles/add.css">

</head>

<body>

<div class="container-fluid display-table">
    <div class="row display-table-row">

        <jsp:include page="sideMenu.jsp"/>


        <div class="col-md-10 col-sm-11 box display-table-cell valign-top">

            <jsp:include page="header.jsp"/>

            <div id="content">
                <header>
                    <h2 class="page-title">Edit the recipe info:</h2>
                </header>

                <div class="content-inner">
                    <div class="form-wrapper clearfix">
                        <form action="/admin/recipe/edit" method="post">
                            <div class="form-group">
                                <label class="sr-only">Name</label>
                                <input type="hidden" name="id"   value="${param.id}" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Name</label>
                                <input type="text" name="name" value="${param.name}" placeholder="Name" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Description</label>
                                <input type="text" name="description" class="form-control" value="${param.description}"/>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Cuisine type</label>
                                <input type="text" class="form-control" name="cuisine_type" value="${param.cuisine_type}" placeholder="Cuisine type"/>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Ingredients</label>
                                <select name="slcIngredients" multiple class="form-control">
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
                            </div>
                            <button type="submit" name="editRecipe" class="btn btn-primary pull-right">Edit</button>
                        </form>
                    </div>
                </div>
                <p>${editError}</p>

                <p>Preselected ingredients for this recipe :</p><br>
                <c:forEach items="${preSelectedIngredients}" var="ingredient">
                    ${ingredient.name},
                </c:forEach>
                <p>${strPreSelectedIngredients}</p>
                <c:set var = "strPreSelectedIngredients" value = "${strPreSelectedIngredients}"/>
            </div>

            <jsp:include page="footer.jsp"/>

        </div>
    </div>
</div>

<script src="../scripts/js/bootstrap.min.js"></script>
<script src="../scripts/script.js"></script>

</body>
</html>