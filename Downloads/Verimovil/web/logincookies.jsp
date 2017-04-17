<%-- 
    Document   : logincookies
    Created on : 28/02/2017, 08:23:48 PM
    Author     : GRISELDA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN succes</title>
    </head>
    <body>
        <p>Hello World!<%=session.getAttribute("nombre")%></p>
        <table width="200" border="1">
            <tr>
                <td width="77">Nombre</td>
                <td width="107"><%=session.getAttribute("nombre")%></td>
            </tr>
            <tr>
                <td>ivan</td>
                <td><%=session.getAttribute("ivan")%></td>
            </tr>
        </table>
            <p><a href="logout.jsp">LOGOUT</a></p>
            <p>No se que rayos<a href="cooksesion.jsp">Link</a></p>
    </body>
</html>
