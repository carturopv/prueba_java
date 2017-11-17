<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.prueba_java_entidades.Estudiantes"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login con Bootstrap</title>
        <link href="bootstrap.min.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <h1>Listado Estudiantes</h1>
        <form action="Estudiante" method="POST">
            
            
            
            Nombre:  <input type="text" name="nombre" class="form-control" /><br />
            Identidficación (Cedula/id/Pasaporte): <input type="password" name="clave" class="form-control" /><br />
            <input type="submit" class="btn btn-primary" value="Agregar"/>
            
            <table>
            <%
                
                List<Estudiantes> lista = (List) request.getAttribute("listaEstudiantes");
                
                Iterator<Estudiantes> it = lista.iterator();

                while (it.hasNext()) {
                %>
                <tr><td><%= it.next() + "Estudiante" %></td></tr>
                
                
                <%
               

                }
                


            %>
            </table>
            
            <br><a href="index.jsp">Volver</a><br>
            
            
        </form>
    </body>
</html>
