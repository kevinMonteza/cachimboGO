<%-- 
    Document   : preguntas
    Created on : 21/06/2018, 11:59:39 PM
    Author     : iFranco
--%>

<%@page import="to.PreguntaTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<PreguntaTO> lista = (List<PreguntaTO>) request.getAttribute("lista");
%>
<div class="">
    <%int i = 0;
        for (PreguntaTO Pregunta : lista) {
            i++;%>
    <label id="<%= Pregunta.getEnunciado()%>" class="w3-bar-item w3-button" onclick='alert("HOLA");'><%= Pregunta.getEnunciado()%></label><br>
    <input type="radio" name="<%= Pregunta.getEnunciado()%>" value="<%= Pregunta.getClave1()%>"><%= Pregunta.getClave1()%><br>
    <input type="radio" name="<%= Pregunta.getEnunciado()%>" value="<%= Pregunta.getClave2()%>"><%= Pregunta.getClave2()%><br>
    <input type="radio" name="<%= Pregunta.getEnunciado()%>" value="<%= Pregunta.getClave3()%>"><%= Pregunta.getClave3()%><br>
    <input type="radio" name="<%= Pregunta.getEnunciado()%>" value="<%= Pregunta.getClave4()%>"><%= Pregunta.getClave4()%><br>
    <input type="radio" name="<%= Pregunta.getEnunciado()%>" value="<%= Pregunta.getClave5()%>"><%= Pregunta.getClave5()%><br>
    <%if (i == 10) {
                break;
            }
        }%>
</div>
