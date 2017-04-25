<%-- 
    Document   : selmodelo
    Created on : 25-abr-2017, 8:58:35
    Author     : Raul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Automor</title>
    </head>
    <body>
        <form action="SelAnio" method="post">
            Selecciona el modelo:   
            <select name="modelo">
                <c:forEach var="modelo" begin="0" items="${modelos}">
                    <option value="${modelo.modeloPK.idModelo}">${modelo.nombreModelo}</option>
                </c:forEach>
            </select>
            <br>
            <br>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>
