<%--
  Created by IntelliJ IDEA.
  User: eduzuniga
  Date: 2024-10-05
  Time: 5:29 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="ingreso" method="post" >
  Usuario:
  <input type="text" name="usuario" id="usuario" />
  <br>
  Clave:
  <input type="password" name="clave" id="clave" />
  <br>
  <input type="submit" value="Ingresar" />
</form>
</body>
</html>
