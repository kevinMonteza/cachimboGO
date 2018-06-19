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
<div class="w3-display-middle">
    <%for (TemaTO tema : lista) {%>
    <button class="w3-button w3-black w3-round-large"><%= tema.getNombre()%></button>
    <%}%>
</div>
