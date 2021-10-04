<%-- 
    Document   : index
    Created on : 3/10/2021, 5:08:10 p. m.
    Author     : jsebi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <center>
        <h1 style="color: blue;">Inicio de Sesión</h1>
        <form method="post" action="Usuario">
            <table>
                <tr>
                <label>Usuario:<br>
                    <input type="text" class="form-control" name="textUsuario"><br>
                <label>Contraseña: <br>
                    <input type="password" class="form-control" name="textClave"><br>
                </tr>
                </table><br>
                <button class="btn btn-primary">Iniciar</button>
                <input type="hidden" name="textOpcion" value="4">
        </form><br>
        <div style="color: red;">
            <%
            if(request.getAttribute("mensajeError")!= null){    
            %>
            ${mensajeError}
            <% } %>
        </div>
    </center>
    </body>
</html>
