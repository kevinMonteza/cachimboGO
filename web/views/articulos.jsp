<%-- 
    Document   : articulos
    Created on : Jun 22, 2018, 2:02:05 AM
    Author     : kevinMC
--%>

<%@page import="to.ArticuloTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<ArticuloTO> lista = (List<ArticuloTO>) request.getAttribute("lista");
%>
<div class="">
    <table>
        <th>Nombre</th>
        <th>Descripcion</th>
        <th>Precio</th>
        <%for (ArticuloTO Stema : lista) {%>
        <tr>
            <td><button id="<%= Stema.getNombre()%>" class="btn btn-info btn-lg" style="margin: .3em;"onclick='buyArticulo("<%= Stema.getId_articulo()%>","<%= Stema.getCosto()%>")'><%= Stema.getNombre()%></button>&nbsp;&nbsp;</td>
            <td><span style="margin-right: .2em;"><%=Stema.getDescripcion()%></span></td><td>&nbsp;&nbsp; <span><%=Stema.getCosto()%></span></td>
        </tr>

        <%}%>

    </table>

</div>
