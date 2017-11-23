<div class="col-md-2 col-sm-1 hidden-xs display-table-cell valign-top clearfix" id="side-menu">
    <h1 class="hidden-sm hidden-xs">Al Salamo Alykom from the jsp</h1>
    <ul>
        <li class="link">
            <a href="/admin/recipe/show">
                <span class="glyphicon glyphicon-th" aria-hidden="true"></span>
                <span class="hidden-sm hidden-xs">Dashboard</span>
            </a>
        </li>
        <li class="link">
            <a>
                <form action="/admin/recipe/read" method="post">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <input type="submit" name="readRecipe" value="Display Recipes"/>
                </form>
            </a>
        </li>
        <li class="link">
            <a>
                <form action="/admin/ingredient/retrieve/all" method="post">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    <input type="submit" name="addRecipe" value="Add Recipe"/>
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

    <p id="test"></p>

</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

    function myFunction() {
        var pathname = window.location.pathname;
        $('li > a > form[action="' + pathname + '"]').parent().parent().addClass('active');
        $('li > a[href="' + pathname + '"]').parent().addClass('active');
        return pathname;
    };

    document.getElementById("test").innerHTML = myFunction();

</script>
