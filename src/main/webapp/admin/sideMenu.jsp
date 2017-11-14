<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top clearfix" id="side-menu">
    <h1 class="hidden-sm hidden-xs">Al Salamo Alykom from the jsp</h1>
    <ul>
        <li class="link active">
            <a href="/admin/recipe/read">
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
        <li class="link">
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

</div>