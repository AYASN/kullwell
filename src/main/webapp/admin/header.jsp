<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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