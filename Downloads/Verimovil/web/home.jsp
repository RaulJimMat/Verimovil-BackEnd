<%-- 
    Document   : home.jsp
    Created on : 25-abr-2017, 12:36:05
    Author     : Raul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text"> 
	<link rel="stylesheet" type="text/css" href="css/contenedor.css"> 
	<title>Verimovil</title>
</head>
<body>
    <h1>¿Que es Verimovil?</h1>                 Bienvenido <c:out value="${sessionScope.user}"/>
	<h3>Verimovil es una aplicacion destinada a aquellos consumidores que cuenten con un automotor y quieran saber cuanto contamina</h3>
        <a href="/Verimovil/Marcas">Agregar automotor</a>
</body>
</html>
