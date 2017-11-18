<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
   <title>Title</title>
</head>
<body>
   <h2>Login page !</h2>
   <form action="/admin/login" method="get">
      Username: <input type="text" name="username" required>
      Password: <input type="password" name="password" required>
      <input type="submit" value="Login">
   </form>

   <p>${nullOrEmptyError}</p><br>
   <p>${userNotFoundError}</p><br>

</body>
</html>