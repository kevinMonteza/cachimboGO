<%-- 
    Document   : perfil
    Created on : Jun 23, 2018, 4:22:22 PM
    Author     : kevinMC
--%>

<%@page import="to.UsuarioTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%UsuarioTO user = (UsuarioTO) request.getAttribute("lista");%>
<table>

    <th ><span style="margin: .5em;">Usuario</span></th>
    <th ><span style="margin: .5em;">Nombres</span></th>
    <th><span style="margin: .5em;">Apellidos</span></th>
    <th ><span style="margin: .5em;">Correo</span></th>
    <th><span style="margin: .5em;">Monedas</span></th> 
    <tr style="margin: .2em;">
        <td style="margin: .2em;"><span style="margin: .5em;"><%=user.getUsuario()%></span></td>
        <td style="margin: .2em;"><span style="margin: .5em;"><%=user.getNombres()%></span></td>
        <td style="margin: .2em;"><span style="margin: .5em;"><%=user.getApellido()%></span></td>
        <td style="margin: .2em;"><span style="margin: .5em;"><%=user.getCorreo()%></span></td>
        <td style="margin: .2em;"><span style="margin: .5em;"><%=user.getMonedas()%></span></td>
    </tr>

</table>
