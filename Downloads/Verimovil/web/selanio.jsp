<%-- 
    Document   : selanio
    Created on : 25-abr-2017, 10:01:17
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
        <form action="SelVersion" method="post">
            Selecciona el anio del auto:    
            <select name="anio">
                <c:forEach var="anio" begin="0" items="${anios}">
                    <option value="${anio.anioPK.idAnio}">${anio.numAnio}</option>
                </c:forEach>
            </select>
            <br><br>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
