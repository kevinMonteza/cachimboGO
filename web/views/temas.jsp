<%-- 
    Document   : temas
    Created on : Jun 12, 2018, 1:46:44 AM
    Author     : kevinMC
--%>

<%@page import="to.TemaTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<TemaTO> lista = (List<TemaTO>) request.getAttribute("lista");
%>
<div class="">
    <table>
    <%for (TemaTO tema : lista) {%>
    <tr>
        <td><button id="<%= tema.getNombre()%>" class="w3-bar-item w3-button" onclick='openTheme("<%= tema.getIdTema()%>",this.id )'><%= tema.getNombre()%></button></td>
        <td><span><%=tema.getPorcentaje()%> %</span></td>
    </tr>
         
    <%}%>
    </table>
</div>
