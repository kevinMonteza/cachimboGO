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



        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="JQuery/jquery-3.1.1.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                //  document.getElementById("modalHeaderTitulo").value = nameCourse;                
                // document.getElementById("modalHeaderTitulo").innerHTML = nameCourse;

                document.getElementById("buttonModalRuedaNormal").style.display = "block";

                var bt = $("#temasBoton");
                console.log("OpenCourse Parametro : ", nameCourse);
                document.getElementById("temas").innerHTML = nameCourse;
                $("#subtemas").empty();
                document.getElementById("subtemas").innerHTML="subtemas";

                document.getElementById("temas").value = nameCourse;
                cambiarContenido(nameCourse, "El conteido de este curso......");
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
                //  document.getElementById("modalHeaderTitulo").value = nameTheme;                
                //  document.getElementById("modalHeaderTitulo").innerHTML = nameTheme;

                document.getElementById("buttonModalRuedaNormal").style.display = "block";

                console.log("OpenTheme Parametro : ", idTheme);
                document.getElementById("subtemas").innerHTML = nameTheme;
                document.getElementById("subtemas").value = nameTheme;
                var bt = $("#subTemasBoton");
                $.get('Controller', {
                    instruccion: "subtemas",
                    id: idTheme
                }, function (response) {
                    //console.log(response); // aca recibe los temas de cada curso                    
                    bt.empty();
                    bt.append(response);
                });
            }
            function openSubTheme(idSubTheme, nameSubTheme) {
                //  document.getElementById("modalHeaderTitulo").value = nameSubTheme;                
                document.getElementById("modalHeaderTitulo").innerHTML = nameSubTheme;
                document.getElementById("buttonModalRuedaNormal").style.display = "block";

                var bt = $("#modalBody");
                $.get('Controller', {
                    instruccion: "preguntas",
                    id: idSubTheme
                }, function (response) {
                    console.log(response); // aca recibe los temas de cada curso                    
                    bt.empty();
                    bt.append(response);
                });
            }
            function listarArticulosTienda() {
                    document.getElementById("modalHeaderTitulo").innerHTML = "TIENDA";
                    var bt = $("#modalBody");
                    $.get('Controller', {
                        instruccion: "tienda"
                    }, function (response) {
                        console.log(response); // aca recibe los temas de cada curso                    
                        bt.empty();
                        bt.append(response);
                    });
            }
            function cambiarContenido(titulo, contenido) {
                $("#titulo").html(titulo);
                $("#contenido").html(contenido + titulo);

            }
            function ruedaNormal() {


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
                <button type="button" class="w3-button w3-border-right" id="asignaturas" value="Asignaturas">Asignaturas</button>
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
            <div>
                <button id="tienda" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="listarArticulosTienda()"><spam>Tienda</spam></button>
            </div>
            <h2 id="titulo">Bienvenidos</h2>
            <p id="contenido">---</p>
            <button id="buttonModalRuedaNormal" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ruedaNormal()">Nueva Rueda</button>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">

            <div class="modal-dialog modal-lg">
                <!-- Modal content-->
                <div id="modalContent" class="modal-content">
                    <div id="modalHeader" class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 id="modalHeaderTitulo" class="modal-title" value="">Rueda de Preguntas</h4>
                    </div>
                    <div id="modalBody" class="modal-body">
                        <p>Rueda de Preguntas</p>
                    </div>
                    <div class="modal-footer">
                        <button id="modalFooterGuardar"type="button" class="btn btn-default" data-dismiss="modal">Guardar</button>
                        <button id="modalFooterCerrar" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>

                </div>

            </div>

        </div>

    </body>

</html>

