<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Welcome Page</title>

    <link rel = "stylesheet" href = "/styles/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/styles/default.css">

</head>

<body>
 <%--   <ol>
        <li><a href="/admin/ingredient/retrieve/add">Add</a></li>
        <li><a href="/admin/ingredient/retrieve/edit">Edit</a></li>
        <li><a href="/admin/recipe/remove">Remove</a></li>
    </ol>--%>
<div class="container-fluid display-table">
    <div class="row display-table-row">

        <jsp:include page="sideMenu.jsp"/>

        <div class="col-md-10 col-sm-11 box display-table-cell valign-top">

            <jsp:include page="header.jsp"/>

            <div id="content">
                <header class="clearfix">
                    <h2 class="page-title pull-left">All recipes</h2>
                    <button type="button" class="btn btn-xs btn-primary pull-right">Add new recipe</button>
                </header>

                <div id="content-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="input-group">
                                <input type="text" name="name" id="inputID" class="form-control" placeholder="Search">
                                <span class="input-group-btn">
                                    <button type="button" class="btn btn-primary">Go !</button>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">

                            <table class="table table-striped">
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Cuisine type</th>
                                    <th>Ingredients</th>
                                    <th></th>
                                    <th></th>
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
                                        <div>
                                            <td class="pull-right">
                                                <form class="btn btn-xs btn-default" action="/admin/ingredient/edit" method="post">
                                                    <input hidden name="id" value="${recipe.id}"/>
                                                    <input hidden name="name" value="${recipe.name}"/>
                                                    <input hidden name="description" value="${recipe.description}"/>
                                                    <input hidden name="cuisine_type" value="${recipe.cuisine_type}"/>
                                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                                    <input type="submit" name="editRecipe" value="Edit"/>
                                                </form>
                                            </td>
                                            <td class="pull-right">
                                                <form class="btn btn-xs btn-default" action="/admin/recipe/remove" method="post">
                                                    <input hidden name="id" value="${recipe.id}"/>
                                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                    <input type="submit" name="removeRecipe" value="Remove"/>
                                                </form>
                                            </td>
                                        </div>
                                    </tr>
                                </c:forEach>
                            </table>
                            <p>${removeSuccess}</p>
                            <p>${removeError}</p>

                        </div>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"/>

        </div>
    </div>
</div>

<script src="../scripts/js/bootstrap.min.js"></script>
<script src="../scripts/script.js"></script>

</body>
</html>