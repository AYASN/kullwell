<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 12/11/17
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Title</title>
</head>
<body>
   <h2>Login page !</h2>
   <form action="/admin/login">
      Username: <input type="text" name="username" required>
      Password: <input type="password" name="password" required>
      <input type="submit" value="Login">
   </form>

   <p>${nullOrEmptyError}</p><br>
   <p>${userNotFoundError}</p><br>

</body>
</html>