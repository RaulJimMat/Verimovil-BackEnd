<%-- 
    Document   : cooksesion
    Created on : 28/02/2017, 08:17:08 PM
    Author     : GRISELDA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
session = request.getSession(false);
String nm = (String) session.getAttribute("nombre");
    if(nm != null){
       out.println(nm);
    }else{
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesion iniciada</title>
    </head>
    <body>
        <a href="logout.jsp">LOGOUT</a>
    </body>
</html>
<jsp:forward page="errorlogin.jsp" />
<%
   }
%>