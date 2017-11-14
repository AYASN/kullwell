<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Welcome Page</title>

    <link rel = "stylesheet" href = "/styles/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/styles/default.css">
    <link rel="stylesheet" type="text/css" href="/styles/add.css">
    <%--<link rel="stylesheet" type="text/css" href="chosen_v1.4.0/chosen.min.css">--%>
</head>

<body>
<div class="container-fluid display-table">
    <div class="row display-table-row">

        <jsp:include page="sideMenu.jsp"/>


        <div class="col-md-10 col-sm-11 box display-table-cell valign-top">

            <jsp:include page="header.jsp"/>

            <div id="content">
                <header>
                    <h2 class="page-title">Add new recipe</h2>
                </header>

                <div class="content-inner">
                    <div class="form-wrapper clearfix">
                        <form action="/admin/recipe/add" method="post">
                            <div class="form-group">
                                <label class="sr-only">Name</label>
                                <input type="text" class="form-control" name="name" value="" placeholder="Name" required/>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Description</label>
                                <input type="text" class="form-control" name="description" value="" placeholder="Description" required/>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Cuisine type</label>
                                <input type="text" class="form-control" name="cuisine_type" value="" placeholder="Cuisine type" required/>
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Ingredients</label>
                                <select name="slcIngredients" multiple class="form-control" required>
                                        <c:forEach items="${ingredients}" var="ingredient">
                                            <option value="${ingredient.id}">${ingredient.name}</option>
                                        </c:forEach>
                                </select>
                            </div>
                            <button type="submit" name="addRecipe" class="btn btn-primary pull-right">Save</button>
                            <%--<button type="submit" class="btn btn-default">Submit</button>--%>
                        </form>
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"/>

        </div>
    </div>
</div>

    <script src="../scripts/js/bootstrap.min.js"></script>
    <script src="../scripts/script.js"></script>
    <%--<script src="chosen_v1.4.0/chosen.jquery.min.js" />--%>

</body>
</html>