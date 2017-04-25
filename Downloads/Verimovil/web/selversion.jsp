<%-- 
    Document   : selversion
    Created on : 25-abr-2017, 10:20:42
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
        <form action="NvoAutomotor" method="post">
            Numero de serie: <input type="text" name="numserie"/>
            <br>
            Tipo de transmision: <select name="transmision">
                <option value="automatica">Automatica</option>
                <option value="manual">Manual</option>
            </select>
            <br>
            Version:<select name="version">
                <c:forEach var="version" begin="0" items="${versions}">
                    <option value="${version.versionPK.idVersion}">${version.nomVersion}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
