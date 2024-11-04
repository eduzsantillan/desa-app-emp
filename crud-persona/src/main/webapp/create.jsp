<%--
  Created by IntelliJ IDEA.
  User: eduzuniga
  Date: 2024-11-02
  Time: 4:10 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./styles/Index.css">
    <link rel="stylesheet" href="./styles/PersonaForm.css">

</head>
<body>

<div class="form-container">
  <button>
    Volver
  </button>

  <form action="/crud/persona/" method="post" class="form-card">
    <h2 class="form-title">Nueva Persona</h2>

    <div class="form-grid">
      <div class="form-group">
        <label htmlFor="nombre" class="form-label">
          Nombre
        </label>
        <input
                type="text"
                name="nombre"
                class="form-input"
                required
        />
      </div>

      <div class="form-group">
        <label htmlFor="apellido" class="form-label">
          Apellido
        </label>
        <input
                type="text"
                name="apellido"
                class="form-input"
        required
        />
      </div>

      <div class="form-group">
        <label htmlFor="nacionalidad" class="form-label">
          Nacionalidad
        </label>
        <input
                type="text"
                name="nacionalidad"
                class="form-input"
        required
        />
      </div>

      <div class="form-group">
        <label htmlFor="estado" class="form-label">
          Estado
        </label>
        <select
                name="estado"
                class="form-select"
                required
        >
        <option value="">Seleccionar estado</option>
        <option value="Active">Activo</option>
        <option value="Inactive">Inactivo</option>
        </select>
      </div>

      <div class="form-group">
        <label htmlFor="correo" class="form-label">
          Correo
        </label>
        <input
                type="email"
                name="correo"
                class="form-input"
        required
        />
      </div>
    </div>

    <div class="form-footer">
      <button type="submit" class="btn btn-primary" >
        Guardar
      </button>
    </div>
  </form>
</div>

</body>
</html>
