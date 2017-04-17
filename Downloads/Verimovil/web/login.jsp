<%-- 
    Document   : login
    Created on : 28/02/2017, 08:03:52 PM
    Author     : GRISELDA
--%>

<%
String uservalid="ivan";
String passvalid="hola";
String user= request.getParameter("username");
String pass= request.getParameter("password");

if(user == null) user="";
if(pass == null) pass="";
if(user.equals(uservalid) && pass.equals(passvalid)){
    session.setAttribute("nombre", "contraseña");
    session.setAttribute("ivan", "loquesea");
       
%>


<jsp:forward page="admin.html" />
<%
  }else{  
%>
<jsp:forward page="errorlogin.jsp" />
<%
}
%>