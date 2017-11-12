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
        <div class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top" id="side-menu">
            <h1 class="hidden-sm hidden-xs">Al Salamo Alykom from the jsp</h1>
            <ul>
                <li class="link">
                    <a href="index.jsp">
                        <span class="glyphicon glyphicon-th" aria-hidden="true"></span>
                        <span class="hidden-sm hidden-xs">Dashboard</span>
                    </a>
                </li>
                <li class="link">
                    <a>
                        <form action="/admin/recipe/read" method="post">
                            <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                            <input type="submit" name="readRecipe" value="Show Recipes"/>
                        </form>
                    </a>
                </li>
                <li class="link active">
                    <a>
                        <form action="/admin/getIngredients/add" method="post">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                            <input type="submit" name="addRecipe" value="Add Recipe"/>
                            <%--<span>Add recipe</span>--%>
                        </form>
                    </a>
                </li>
                <li class="link settings-btn">
                    <a href="settings.html">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        <span class="hidden-sm hidden-xs" >Settings</span>
                    </a>
                </li>
            </ul>

            <%--${recipes}--%>
        </div>

        <div class="col-md-10 col-sm-11 box display-table-cell valign-top">
            <div class="row">
                <header id="nav-header" class="clearfix">
                    <div class="col-md-5">
                        <nav class="navbar-default pull-left">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="offcanvas" data-target="#side-menu">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </nav>
                        <input type="text" class="hidden-sm hidden-xs" id="header-search-field" placeholder="Search for something...">
                    </div>

                    <div class="col-md-7">
                        <ul class="pull-right" >
                            <li id="welcome" class="hidden-xs">Welcome to your administration area</li>
                            <li class="fixed-width">
                                <a href="#">
                                    <span class="glyphicon glyphicon-bell" aria-hidden="true"></span>
                                    <span class="label label-warning">3</span>
                                </a>
                            </li>
                            <li class="fixed-width">
                                <a href="#">
                                    <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                                    <span class="label label-message">3</span>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="logout">
                                    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                                    Log out
                                </a>
                            </li>
                        </ul>
                    </div>
                </header>
            </div>

            <div id="content">
                <header>
                    <h2 class="page-title">Add new recipe</h2>
                </header>

                <div class="content-inner">
                    <div class="form-wrapper clearfix">
                        <form action="/admin/recipe/add" method="post">
                            <div class="form-group">
                                <label class="sr-only">Name</label>
                                <input type="text" class="form-control" name="name" value="" placeholder="Name" />
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Description</label>
                                <input type="text" class="form-control" name="description" value="" placeholder="Description" />
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Cuisine type</label>
                                <input type="text" class="form-control" name="cuisine_type" value="" placeholder="Cuisine type" />
                            </div>

                            <div class="form-group">
                                <label class="sr-only">Ingredients</label>
                                <select name="slcIngredients" multiple class="form-control">
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

            <div class="row">
                <footer id="admin-footer" class="clearfix">
                    <div class="pull-left"><b>Copyrignt</b>&copy; 2015</div>
                    <div class="pull-right">Admin system</div>
                </footer>
            </div>

        </div>
    </div>
</div>

    <script src="../scripts/js/bootstrap.min.js"></script>
    <script src="../scripts/script.js"></script>
    <%--<script src="chosen_v1.4.0/chosen.jquery.min.js" />--%>

</body>
</html>