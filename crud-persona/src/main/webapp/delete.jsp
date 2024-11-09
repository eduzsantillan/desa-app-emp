<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Personas</title>
  <link rel="stylesheet" href="./styles/Index.css" />
  <link rel="stylesheet" href="./styles/Navbar.css" />
  <link rel="stylesheet" href="./styles/PersonaList.css" />
</head>
<body>

<nav class="navbar">
  <div class="container navbar-container">
    <div class="navbar-brand">
      <span>CRUD PERSONA V1.0 </span>
    </div>
  </div>
</nav>

<div class="container">
  <div class="persona-header">
    <div>
      <h1 class="persona-title"> Persona ID: ${personaDelete.id}</h1>
      <hr />
      <p class="persona-subtitle">
        Estas seguro que quieres eliminar a ${personaDelete.nombre} ${personaDelete.apellido}?
      </p>
    </div>
    <hr />
    <form action="<%=request.getContextPath()%>/delete" method="post">
      <input type="hidden" name="id" value="${personaDelete.id}" />
      <button class="btn btn-danger" type="submit">
        Eliminar
      </button>
    </form>
  </div>
</div>

</body>
</html>