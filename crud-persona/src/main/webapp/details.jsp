<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Personas</title>
  <link rel="stylesheet" href="./styles/Index.css" />
  <link rel="stylesheet" href="./styles/Navbar.css" />
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
      <h1 class="persona-title">Persona ID: ${persona.id}</h1>
        <hr />
      <h3 >
        Nombres: ${persona.nombre} ${persona.apellido}
      </h3>
      <h3 >
        Nacionalidad: ${persona.nacionalidad}
      </h3>
      <h3 >
        Estado: ${persona.estado}
      </h3>
      <h3 >
        Correo: ${persona.correo}
      </h3>
    </div>
  </div>

</div>

</body>
</html>