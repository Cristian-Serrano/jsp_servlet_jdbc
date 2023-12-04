<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Partidos</title>
</head>
<body>
<h1>Listado de Partidos</h1>
<div class="col-md-4 align-self-center" ><form method="get" action="GrabarPartidosServlet">
    <input class="btn btn-primary"  type="submit" value="Crear Partido">
</form></div>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juego","root", "user");

    Statement s = conexion.createStatement();
    ResultSet listado = s.executeQuery ("SELECT * FROM partido");

    while (listado.next()) {
        out.println(listado.getInt("id") + " " + listado.getDate("fecha") + " "+ listado.getString("equipo1") + " "+ listado.getInt("puntos_equipo1") + " "+ listado.getString("equipo2") + " "+ listado.getInt("puntos_equipo2") + " "+ listado.getString("tipo_partido"));
        %>
        <form class="d-inline" method="post" action="BorrarPartidosServlet">
            <input type="hidden" name="codigo" value="<%=listado.getInt("id") %>"/>
            <input class="btn btn-primary"  type="submit" value="Borrar">
        </form>
        <form class="d-inline" method="get" action="EditarPartidosServlet">
            <input type="hidden" name="codigo" value="<%=listado.getInt("id") %>"/>
            <input class="btn btn-primary"  type="submit" value="Editar">
        </form><br>
    <%

    }
    listado.close();
    s.close();
    conexion.close();
%>
</body>
</html>