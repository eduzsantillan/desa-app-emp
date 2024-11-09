<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Persona</title>
    <link rel="stylesheet" href="./styles/Index.css">
    <link rel="stylesheet" href="./styles/PersonaForm.css">
</head>
<body>

<div class="form-container">
  <button>
    Volver
  </button>

  <form action="<%=request.getContextPath()%>/edit" method="post" class="form-card">
    <h2 class="form-title">Editar Persona</h2>

    <input type="hidden" name="id" value="${personaEdit.id}" />

    <div class="form-grid">
      <div class="form-group">
        <label htmlFor="nombre" class="form-label">
          Nombre
        </label>
        <input
                type="text"
                name="nombre"
                class="form-input"
                value="${personaEdit.nombre}"
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
                value="${personaEdit.apellido}"
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
                value="${personaEdit.nacionalidad}"
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
                value="${personaEdit.estado}"
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
                value="${personaEdit.correo}"
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
