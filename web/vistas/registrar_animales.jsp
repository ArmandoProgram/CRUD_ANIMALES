<%-- 
    Document   : registrar_animales
    Created on : 23/09/2024, 09:23:02 PM
    Author     : arman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <body>
  <h1>Registro de Animales</h1>
  <form action="registrar_animal" method="POST">
    COLOR: <br>
    <input type="text" name="txt_color"><br>
    ESPECIE: <br>
    <input type="text" name="txt_especie"><br>
    TIPO DE ANIMAL: <br>
    <input type="text" name="txt_tipo_animal"><br>
    TIPO DE ALIMENTO: <br>
    <input type="text" name="txt_tipo_alimento"><br>
    PESO: <br>
    <input type="number" step="0.01" name="txt_peso"><br>
    HABITAD: <br>
    <input type="text" name="txt_habitad"><br>
    ALTURA: <br>
    <input type="text" name="txt_altura"><br>
    <input type="submit" name="accion" value="Agregar">
  </form>
</body>


</html>
