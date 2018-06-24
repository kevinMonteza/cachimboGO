<%-- 
    Document   : preguntas
    Created on : 21/06/2018, 11:59:39 PM
    Author     : iFranco
--%>

<%@page import="to.PreguntaTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    PreguntaTO lista = (PreguntaTO) request.getAttribute("lista");
%>
<div class="">
    <% int i=1;%>
    <label id="<%= lista.getEnunciado()%>" class="w3-bar-item w3-button" onclick='alert("HOLA");'><%=i+")"  +  lista.getEnunciado()%></label><br>
    <input type="radio" name="<%= lista.getEnunciado()%>" value="<%= lista.getClave1()%>"><%=i+")"  + lista.getClave1()%><br>
    <input type="radio" name="<%= lista.getEnunciado()%>" value="<%= lista.getClave2()%>"><%=i+")"  + lista.getClave2()%><br>
    <input type="radio" name="<%= lista.getEnunciado()%>" value="<%= lista.getClave3()%>"><%=i+")"  + lista.getClave3()%><br>
    <input type="radio" name="<%= lista.getEnunciado()%>" value="<%= lista.getClave4()%>"><%=i+")"  +lista.getClave4()%><br>
    <input type="radio" name="<%= lista.getEnunciado()%>" value="<%= lista.getClave5()%>"><%=i+")"  + lista.getClave5()%><br>
    <%i++; }%>
</div>
