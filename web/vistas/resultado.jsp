<%-- 
    Document   : resultado
    Created on : 25/09/2024, 10:56:17 AM
    Author     : arman
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Resultado del Registro</title>
</head>
<body>
  <h2>Resultado</h2>
  <p><%= request.getAttribute("mensaje") %></p>
  <a href="inputform.jsp">Regresar al formulario</a>
</body>
</html>
