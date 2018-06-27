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
        <link href="CSS/style.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="JQuery/jquery-3.1.1.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="JS/datos.js" type="text/javascript"></script>
        <script src="JS/miScript.js" type="text/javascript"></script>
        <style type="text/css">
            .rojo{
                background-color: #ff3333;
            }
            .verde{
                background-color: #00cc00;
            }
            body{
                background-color: #ffc885;
            }
        </style>


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
        <div class="">
            <image src="img/fondo.png" style="width: 100%; height: 200px;"/>
        </div>
        <div id="headerBar" class="w3-bar w3-green w3-card-4" style="background-color:#00ffff;">
            <div class="w3-dropdown-hover">
                <button type="button" class="w3-button w3-border-right w3-green" id="inicio">Inicio</button>
                <div class="w3-dropdown-content w3-bar-block w3-card-4" id="subMenuInicio">
                    <button class="w3-bar-item w3-button" id="perfil" data-toggle="modal" data-target="#myModal">Perfil</button>
                    <button class="w3-bar-item w3-button" data-toggle="modal" data-target="#myModal" id="tienda">Tienda</button>
                    <a class="w3-bar-item w3-button" href="#" id="salir">Cerrar Sesion</a>
                </div> 
            </div>

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
                <a href="#" class="w3-bar-item w3-button w3-green w3-border-right">Go</a>                
            </div> 
        </div>


        <div id="inicio" class="w3-panel w3-leftbar w3-sand w3-xxlarge w3-serif inicio">
            <div class="w3-panel">
                <button id="tienda" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="listarArticulosTienda()"><spam>Tienda</spam></button>
            </div>
            <div class="w3-panel">
                <button id="ComprarMonedas" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" title="Comprar">Monedas:  <spam id="mostrarMonedas" style="font-family:Courier New;"></spam></button>
            </div>

            <div>
                <h2 id="titulo">Bienvenidos</h2>
                <p id="contenido">---</p>
                <button id="buttonModalRuedaNormal" type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" onclick="ruedaNormal()" style="display : none;">Nueva Rueda</button>
            </div>

        </div>


        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">

            <div class="modal-dialog modal-lg">
                <!-- Modal content-->
                <div id="modalContent" class="modal-content">
                    <div id="modalHeader" class="modal-header">
                        <button id="cerrarModal" type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 id="modalHeaderTitulo" class="modal-title" value="">Rueda de Preguntas</h4>
                    </div>
                    <div id="modalBody" class="modal-body">
                        <p>Rueda de Preguntas</p>
                    </div>
                    <div class="modal-footer">
                        <!-- <button id="modalFooterGuardar"type="button" class="btn btn-default" data-dismiss="modal">Guardar</button>
                         <button id="modalFooterCerrar" type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button> -->
                    </div>

                </div>

            </div>

        </div>

    </body>

</html>

