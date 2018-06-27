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
    int i = (Integer)request.getAttribute("contador");
%>
<div class="">
    <div id="enunciado"><label id='preguntita'  class="w3-bar-item w3-button"><%=i+") "+ lista.getEnunciado()%></label><span id='<%= lista.getIdPregunta()%>'></span></div><br>
    <input id='myRadio1' type="radio" name="<%= lista.getIdPregunta()%>" onclick='radioEnviar("<%= lista.getIdPregunta()%>", 1)' value="<%= lista.getClave1()%>"><%=lista.getClave1()%> <br>
    <input id='myRadio2' type="radio" name="<%= lista.getIdPregunta()%>" onclick='radioEnviar("<%= lista.getIdPregunta()%>", 2)' value="<%= lista.getClave2()%>"><%=lista.getClave2()%><br>
    <input id='myRadio3' type="radio" name="<%= lista.getIdPregunta()%>" onclick='radioEnviar("<%= lista.getIdPregunta()%>", 3)' value="<%= lista.getClave3()%>"><%=lista.getClave3()%><br>
    <input id='myRadio4' type="radio" name="<%= lista.getIdPregunta()%>" onclick='radioEnviar("<%= lista.getIdPregunta()%>", 4)' value="<%= lista.getClave4()%>"><%=lista.getClave4()%><br>
    <input id='myRadio5' type="radio" name="<%= lista.getIdPregunta()%>" onclick='radioEnviar("<%= lista.getIdPregunta()%>", 5)' value="<%= lista.getClave5()%>"><%=lista.getClave5()%><br>
    <label id="respuesta"></label>
    <button onclick="siguiente(<%= i%>)" style="display:none;" id="btonSgt">Siguiente</button>
</div>
