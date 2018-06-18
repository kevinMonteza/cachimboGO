<%-- 
    Document   : index
    Created on : Jun 2, 2018, 10:59:50 PM
    Author     : kmont
--%>

   <%
        String name = request.getParameter("upass");
        session = request.getSession(true);
        System.out.println("Sesion: " +  session.getAttribute("uname"));
        if (session.getAttribute("uname") == null && session.getAttribute("upass") == null) {
            session.invalidate();
        }
%>
<%@page import="to.AsignaturaTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>PD Proyecto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="JQuery/jquery-3.1.1.js"></script>
        <%List<AsignaturaTO> lista = (List<AsignaturaTO>) request.getAttribute("lista");%>
        <script type="text/javascript">

            $(document).ready(function () {
                
            
            $.get('Controller', {
                    instruccion: "asignaturas"
                },function (response) {
                   // console.log(response);
                    $("#asignaturasBoton").append(response);
                });
            });
             function openCourse(e){
                $.get('Controller', {
                    instruccion: "temas",
                    id:e
                },function (response) {
                    console.log("ID : ", e)
                    console.log(response); // aca recibe los temas de cada curso
                    if (document.getElementById("courseTab")) {
                        document.getElementById("courseTab").remove();
                    }
                    $("#headerBar").append("<button id='courseTab' class='w3-bar-item w3-button w3-border-right'>Inicio</button>");
                });
                }
        </script>
     

    </head>

    <!-- 
    Usado:
    Tabs : https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_tabulators
    Nav Bar & Dropdown : https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_navbar_dropdown
    Border : https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_navbar_border
    Add Buttons : https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_document_createelement2
    Clicked Button : https://stackoverflow.com/questions/10291017/how-to-get-id-of-button-user-just-clicked
    -->
    <body>  
        <div class="w3-container">
            <h2>Patrones de Diseño</h2>
            <p id="algo">welcome</p>
        </div>
        <div id="headerBar" class="w3-bar w3-grey w3-card-4">
            <button class="w3-bar-item w3-button w3-border-right">Inicio</button>
            <button class="w3-bar-item w3-button w3-border-right">Ayuda</button>
            <div class="w3-dropdown-hover">
                <button id="courses" type="button" class="w3-button w3-border-right" id="asignaturas">Asignaturas</button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4" id="asignaturasBoton">
                </div> 
            </div>
            <div style="float: right;">
                <input type="text" class="w3-bar-item w3-input" placeholder="Search..">
                <a href="#" class="w3-bar-item w3-button w3-grey w3-border-right">Go</a>
            </div> 
        </div>

        <div id="Inicio" class="w3-container inicio" style="display:none">
            <h2>Bienvenidos</h2>
            <p>---</p>
        </div>

        <div id="Aritmética" class="w3-container courseDescription" style="display:none">
            <h2>Aritmética</h2>
            <p>---</p>
        </div>

        <div id="Geometría" class="w3-container courseDescription" style="display:none">
            <h2>Geometría</h2>
            <p>---</p>
        </div>

        <div id="Álgebra" class="w3-container courseDescription" style="display:none">
            <h2>Álgebra</h2>
            <p>---</p>
        </div>
        <div id="Trigonometría" class="w3-container courseDescription" style="display:none">
            <h2>Trigonometría</h2>
            <p>---</p>
        </div>
        <div id="Lenguaje" class="w3-container courseDescription" style="display:none">
            <h2>Lenguaje</h2>
            <p>---</p>
        </div>
        <div id="Literatura" class="w3-container courseDescription" style="display:none">
            <h2>Literatura</h2>
            <p>---</p>
        </div>
        <div id="Educación Cívica" class="w3-container courseDescription" style="display:none">
            <h2>Educación Cívica</h2>
            <p>---</p>
        </div>
        <div id="Historia Universal" class="w3-container courseDescription" style="display:none">
            <h2>Historia Universal</h2>
            <p>---</p>
        </div>
        <div id="Historia del Perú" class="w3-container courseDescription" style="display:none">
            <h2>Historia del Perú</h2>
            <p>---</p>
        </div>
        <div id="Geografía" class="w3-container courseDescription" style="display:none">
            <h2>Geografía</h2>
            <p>---</p>
        </div>
        <div id="Economía" class="w3-container courseDescription" style="display:none">
            <h2>Economía</h2>
            <p>---</p>
        </div>
        <div id="Filosofía" class="w3-container courseDescription" style="display:none">
            <h2>Filosofía</h2>
            <p>---</p>
        </div>
        <div id="Física" class="w3-container courseDescription" style="display:none">
            <h2>Física</h2>
            <p>---</p>
        </div>
        <div id="Química" class="w3-container courseDescription" style="display:none">
            <h2>Química</h2>
            <p>---</p>
        </div>
        <div id="Biología" class="w3-container courseDescription" style="display:none">
            <h2>Biología</h2>
            <p>---</p>
        </div>
        <div id="Razonamiento Matemático" class="w3-container courseDescription" style="display:none">
            <h2>Razonamiento Matemático</h2>
            <p>---</p>
        </div>
        <div id="Razonamiento Verbal" class="w3-container courseDescription" style="display:none">
            <h2>Razonamiento Verbal</h2>
            <p>---</p>
        </div>
        <div id="detallesMatematicas" class="w3-container themeDescription" style="display:none">
            <h2>Detalles Matematicas</h2>
            <p>---</p>
        </div>
        <div id="detallesComunicacion" class="w3-container themeDescription" style="display:none">
            <h2>Detalles Comunicacion</h2>
            <p>---</p>
        </div>
        <div id="detallesCTA" class="w3-container themeDescription" style="display:none">
            <h2>Detalles CTA</h2>
            <p>---</p>
        </div>


    </body>

</html>

