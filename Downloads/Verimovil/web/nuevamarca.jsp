<%-- 
    Document   : nuevamarca
    Created on : 24-abr-2017, 22:49:44
    Author     : Raul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="SelModelo">
            Selecciona la marca del automovil:  
            <select name="marca">   
                <c:forEach var="marca" begin="0" items="${marcas}">
                    <option value="${marca.idMarca}">${marca.nombreMarca}</option>
                </c:forEach> 
            </select>
            <br><br>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
