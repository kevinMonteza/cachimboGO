<%-- 
    Document   : index
    Created on : Jun 2, 2018, 10:59:50 PM
    Author     : kmont
--%>

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
        <script type="text/javascript">
            $(document).ready(function () {
                $.get('Controller', {
                    instruccion: "asignaturas"
                }, function (response) {
                    // console.log(response);
                    $("#asignaturasBoton").append(response);
                });
            });
            function openCourse(idCourse, nameCourse) {
                var bt = $("#temasBoton");
                console.log("OpenCourse Parametro : ", nameCourse);
                document.getElementById("temas").innerHTML = nameCourse;
                cambiarContenido(nameCourse,"El conteido de este curso......");
                $.get('Controller', {
                    instruccion: "temas",
                    id: idCourse
                }, function (response) {
                    //console.log(response); // aca recibe los temas de cada curso                    
                    bt.empty();
                    bt.append(response);
                });
            }
            function openTheme(idTheme, nameTheme) {
                console.log("OpenTheme Parametro : ", idTheme);
                document.getElementById("subtemas").innerHTML = nameTheme;
                var bt = $("#subTemasBoton");
                $.get('Controller', {
                    instruccion: "subtemas",
                    id: idTheme
                }, function (response) {
                    console.log(response); // aca recibe los temas de cada curso                    
                    bt.empty();
                    bt.append(response);
                });
            }
            function cambiarContenido(titulo,contenido){
                 $("#titulo").html(titulo);
                 $("#contenido").html(contenido+titulo);
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
                <button type="button" class="w3-button w3-border-right" id="asignaturas">Asignaturas</button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4" id="asignaturasBoton">
                </div> 
            </div>
            <div class="w3-dropdown-hover">
                <button type="button" class="w3-button w3-border-right" id="temas">Temas</button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4" id="temasBoton">
                </div>
            </div>
            <div class="w3-dropdown-hover">
                <button type="button" class="w3-button w3-border-right" id="subtemas">Subtemas</button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4" id="subTemasBoton">
                </div> 
            </div>
            <div style="float: right;">
                <input type="text" class="w3-bar-item w3-input" placeholder="Search..">
                <a href="#" class="w3-bar-item w3-button w3-grey w3-border-right">Go</a>
            </div> 
        </div>

        <div id="inicio" class="w3-container inicio">
            <h2 id="titulo">Bienvenidos</h2>
            <p id="contenido">---</p>
        </div>
    </body>

</html>

