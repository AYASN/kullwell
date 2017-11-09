<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Find Recipes by Ingredients</title>
</head>
<body>
   <h1>What are you hungry for ?</h1>
   <form action="recipe/ingredient/find" method="post">
      <label for="ingredients">Ingredients :</label>
      <select name="ingredients" id="ingredients" multiple>
         <option value="1">Tomato</option>
         <option value="2">Carrot</option>
         <option value="3">Onion</option>
         <option value="4">Potato</option>
      </select>
      <button type="submit">Show me what you have for me</button>
   </form>
</body>
</html>
