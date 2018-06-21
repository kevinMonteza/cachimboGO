<%-- 
    Document   : subTemas
    Created on : Jun 21, 2018, 4:30:53 PM
    Author     : kevinMC
--%>


<%@page import="to.SubtemaTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<SubtemaTO> lista = (List<SubtemaTO>) request.getAttribute("lista");
%>
<div class="">
    <%for (SubtemaTO Stema : lista) {%>
    <button id="<%= Stema.getNombre()%>" class="w3-bar-item w3-button" onclick='openSubTheme("<%= Stema.getIdSubtema()%>", this.id)'><%= Stema.getNombre()%></button>    
    <%}%>
</div>
