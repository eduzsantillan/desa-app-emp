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
            <h1 class="persona-title">${title}</h1>
            <p class="persona-subtitle">
                Lista de todas las personas registradas en el sistema
            </p>
        </div>
        <button class="btn btn-primary" onclick="window.location.href='create.jsp'" >
            Nueva Persona
        </button>
    </div>

    <div class="table-container">
        <table class="table">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Nacionalidad</th>
                    <th>Estado</th>
                    <th>Correo</th>
                    <th><span class="sr-only">Acciones</span></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="persona" items="${personas}">
                    <tr >
                        <td>${persona.nombre}</td>
                        <td>${persona.apellido}</td>
                        <td>${persona.nacionalidad}</td>
                        <td>
                          <span class="status-badge status-active">
                                  ${persona.estado}
                          </span>
                        </td>
                        <td>${persona.correo}</td>
                        <td>
                            <div class="actions">
                                <button class="action-btn action-view">
                                    Ver detalle
                                </button>
                                <button class="action-btn action-edit">
                                    Editar
                                </button>
                                <button class="action-btn action-delete">
                                    Eliminar
                                </button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>