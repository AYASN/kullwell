<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
   <title>Welcome Page</title>
</head>
<body>
   <h1>Al Salamo Alykom from the jsp</h1>
   <h2>Run the <a href="/welcome">Servlet</a></h2>
   <h1>${recipes}</h1>

   <c:forEach items="${recipes}" var="recipe">
      <tr>
         <td>${recipe.name}</td>

         </td>
      </tr>
   </c:forEach>
</body>
</html>
