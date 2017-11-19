<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
   <title>Login Page</title>

   <link rel = "stylesheet" href = "/styles/css/bootstrap.min.css" />
   <link rel="stylesheet" type="text/css" href="/styles/login.css">

</head>

<body>

<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
   <div id="content" class="clearfix">
      <header>
         <h1 class="page-title text-center">Admin</h1>
      </header>

      <hr>

      <div id="content-inner">
         <div class="form-wrapper clearfix center-block">
            <form action="/admin/login" method="post">
               <div class="form-group input-group">
                  <span class="input-group-addon">
                     <span class="glyphicon glyphicon-user"></span>
                  </span>
                  <input type="text" class="form-control" name="username" value="" placeholder="Username"/>
               </div>

               <div class="form-group input-group">
                  <span class="input-group-addon">
                     <span class="glyphicon glyphicon-lock"></span>
                  </span>
                  <input type="password" class="form-control" name="password" value="" placeholder="Password"/>
               </div>

               <button type="submit" name="login" class="btn btn-primary">Login</button>

            </form>
            <p>${nullOrEmptyError}</p><br>
            <p>${userNotFoundError}</p><br>
         </div>
      </div>
   </div>
</div>

</body>
</html>