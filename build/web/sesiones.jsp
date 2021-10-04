<%-- 
    Document   : sesiones
    Created on : 27/09/2021, 2:54:36 p. m.
    Author     : jsebi
--%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
    response.setDateHeader("Expires",0);
    %>
<%
    HttpSession buscarSesion = (HttpSession)request.getSession();
    String usuario="";
    if(buscarSesion.getAttribute("datosUsuario")==null){
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }else{
    UsuarioVO usuVO = (UsuarioVO)buscarSesion.getAttribute("datosUsuario");  
    usuario = usuVO.getUsuLogin();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="float: right;">
            Bienvenido:<%=usuario%>

            <form method="post" action="Sesiones">
                <input type="submit" value="Cerrar Sesión"> 
            </form>
        </div><br><br>
    </body>
</html>
