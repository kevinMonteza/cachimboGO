function data(nombre) {
    var respuesta;
    switch (nombre) {
        case "Aritmética":
            respuesta = "La Aritmética es la más antigua y simple de las ramas de la matemática en la que se han desarrollado las principales operaciones matemáticas conocidas por el hombre, a saber: Adición (Suma), Sustracción (Resta), Multiplicación y División. La aritmética se encarga de realizar con números y simbológica en conjunto con las operaciones antes mencionadas, el desarrollo de propiedades y  habilidades las cuales pueden ser usadas en la vida cotidiana y materias de estudio que impliquen a la matemática como base fundamental de aprendizaje.";
            break;
        case "Razonamiento Verbal":
            respuesta = "El razonamiento es el conjunto de actividades mentales que consiste en la conexión de ideas de acuerdo a ciertas reglas. En el caso del razonamiento verbal, se trata de la capacidad para razonar con contenidos verbales, estableciendo entre ellos principios de clasificación, ordenación, relación y significados.";
            break;
        case "Razonamiento Matemático":
            respuesta = "Habilidad para utilizar y relacionar los números, sus operaciones básicas, los símbolos y las formas de expresión y razonamiento matemático, tanto para producir e interpretar distintos tipos de información, como para ampliar el conocimiento sobre aspectos cuantitativos y espaciales de la realidad, y para resolver problemas relacionados con la vida cotidiana y con el mundo laboral.";
            break;
        case "Biología":
            respuesta = "Ciencia natural que se dedica a analizar las propiedades y las características de los organismos vivos, centrándose en su origen y en su desarrollo.";
            break;
        case "Historia del Perú":
            respuesta = "Esta asignatura tiene como propósito el análisis y la reinterpretación de los procesos históricos peruanos enmarcados dentro del contexto mundial, en diálogo permanente entre el pasado y el presente.";
            break;
        case "Ingles":
            respuesta = "Este curso va dirigido a estudiantes interesados en aprender y consolidar sus conocimientos del inglés como lengua extranjera, desarrollando su competencia comunicativa intercultural de una forma dinámica, atendiendo a todos los contenidos lingüísticos y a las cuatro destrezas, mientras descubren la riqueza del mundo anglosajón a través de sus culturas de una manera real y divertida.";
            break;
        case "Educación Cívica":
            respuesta = "La educación cívica,es un tipo de educación dirigida a las relaciones sociales que busca fortalecer los espacios de convivencia social entre las personas; también enseña la solidaridad y la cooperación, la convivencia social ya sea dentro del plantel educativo o en la sociedad.";
            break;
        case "Álgebra":
            respuesta = "El álgebra se define como aquella rama de las matemáticas encargada de estudiar los números y las propiedades de los mismos.";
            break;
    }
    return respuesta;
}

$(document).ready(function () {
    $.get('Controller', {
        instruccion: "getMonedas"
    }, function (response) {
        // console.log(response);
        $("#mostrarMonedas").empty().append(response);
    });
    $("#asignaturas").hover(function () {
        getAsigaturas();
    });
    $("#ComprarMonedas").hover(function () {
        $.get('Controller', {
            instruccion: "getMonedas"
        }, function (response) {
            // console.log(response);
            $("#mostrarMonedas").empty().append(response);
        });
    });

    function getAsigaturas() {
        $.get('Controller', {
            instruccion: "asignaturas"
        }, function (response) {
            // console.log(response);
            $("#asignaturasBoton").empty();
            $("#asignaturasBoton").append(response);
        });
    }


    $("#perfil").click(function () {
        var bt = $("#modalBody");
        $.get('Controller', {
            instruccion: "perfil"
        }, function (response) {
            // console.log(response);
            bt.empty();
            bt.append(response);
        });
    });

    $("#tienda").click(function () {
        listarArticulosTienda();
    });

    $("#ComprarMonedas").click(function () {
        $.get('Controller', {
            instruccion: "comprarMonedas"
        }, function (response) {
            // console.log(response);
            document.getElementById("modalHeaderTitulo").innerHTML = "Comprar Monedas";
            var bt = $("#modalBody");
            bt.empty().append(response);
        });
    });

});

function openCourse(idCourse, nameCourse) {
    //  document.getElementById("modalHeaderTitulo").value = nameCourse;                
    // document.getElementById("modalHeaderTitulo").innerHTML = nameCourse;

    document.getElementById("buttonModalRuedaNormal").style.display = "none";

    var bt = $("#temasBoton");
    //console.log("OpenCourse Parametro : ", nameCourse);
    document.getElementById("temas").innerHTML = nameCourse;
    $("#subtemas").empty();
    document.getElementById("subtemas").innerHTML = "subtemas";

    document.getElementById("temas").value = nameCourse;
    cambiarContenido(nameCourse, "El contenido de este curso......");
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

    document.getElementById("buttonModalRuedaNormal").style.display = "none";

    cambiarContenido(nameTheme, "El contenido de este curso......");

    //console.log("OpenTheme Parametro : ", idTheme);
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
    document.getElementById("modalHeaderTitulo").value = nameSubTheme;
    document.getElementById("buttonModalRuedaNormal").style.display = "block";

    cambiarContenido(nameSubTheme, "El contenido de este curso......");

    var bt = $("#modalBody");
    $.get('Controller', {
        instruccion: "preguntas",
        id: idSubTheme
    }, function (response) {
        //console.log(response); // aca recibe los temas de cada curso                    
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
        //console.log(response); // aca recibe los temas de cada curso                    
        bt.empty();
        bt.append(response);
    });
}
function cambiarContenido(titulo, contenido) {
    var dat = data(titulo);
    console.log(dat);
    $("#titulo").html(titulo);
    $("#contenido").html(contenido + dat);

}
function ruedaNormal() {}
function buyArticulo(idArticulo, costo) {
    $.get('Controller', {
        instruccion: "compras",
        id: idArticulo,
        costo: costo
    }, function (response) {
        // console.log(response);
        alert(response);
        // bt.empty();
        // bt.append(response);
    });
}
function mostrar(tipo) {
    $("#" + tipo).slideToggle();
}
function pagar(tipo) {
    let monto = $('input[name="valor"]:checked').val();
    alert(monto);
    $.get('Controller', {
        instruccion: "pagar",
        tipo: tipo,
        monto: monto
    }, function (response) {
        // console.log(response);
        alert(response);
        $("#" + tipo).hide();
        // bt.empty();
        // bt.append(response);
    });
}
function desabilitar() {
    if (!document.getElementById("myRadio1").disabled) {
        document.getElementById("myRadio1").disabled = true;
        document.getElementById("myRadio2").disabled = true;
        document.getElementById("myRadio3").disabled = true;
        document.getElementById("myRadio4").disabled = true;
        document.getElementById("myRadio5").disabled = true;
    }
}
var obj = {};
function radioEnviar(idPregunta, clave) {
    let val = document.getElementById("preguntita").innerHTML;
    desabilitar();
    //console.log(idPregunta, " - ", clave);
    var bt = $("#" + idPregunta);
    $.get('Controller', {
        instruccion: "respuesta",
        idP: idPregunta,
        c: clave
    }, function (response) {
        //console.log(response); // aca recibe los temas de cada curso                    
        bt.empty();
        bt.append(response);
        $("#enunciado").removeClass();
        if (response === "Correcta") {
            obj[val] = "correcta";
            //alert("entro");
            $("#enunciado").addClass("verde");
            //$("#btonSgt").slideDown();
        }
        if (response === "Incorrecta") {
            obj[val] = "incorrecta";
            $("#enunciado").addClass("rojo");
            //$("#btonSgt").slideUp();
        }
        $("#btonSgt").slideDown();
    });

}

function siguiente(i) {

    var bt = $("#modalBody");
    $.get('Controller', {
        instruccion: "next"
    }, function (response) {
        if (response === "fin") {
            mostrarResumen();
            // cerrarModal();
            return false;
        } else {
            //console.log(response); // aca recibe los temas de cada curso
            bt.empty();
            bt.append(response);
            bt.show("slow");
        }
    });
}
function mostrarResumen() {
    $("#modalBody").empty();
    for (i in obj) {
        let node = document.createElement("LABEL");
        let nodeL = document.createElement("LABEL");
        let br = document.createElement("BR");
        let textnodeL;
        if (obj[i] === "correcta") {
            textnodeL = document.createTextNode("correcta");
            nodeL.className = "verde";
        } else {
            textnodeL = document.createTextNode("incorrecta");
            nodeL.className = "rojo";
        }
        let textnode = document.createTextNode(i);
        nodeL.appendChild(textnodeL);
        node.appendChild(textnode);
        document.getElementById("modalBody").appendChild(node);
        document.getElementById("modalBody").appendChild(nodeL);
        document.getElementById("modalBody").appendChild(br);

        //console.log(i, obj[i]);
    }
    setTimeout(cerrarModal, 3000);
}


function cerrarModal() {
    $("#myModal").modal('hide');
    document.getElementById("buttonModalRuedaNormal").style.display = "none";
    document.getElementById("contenido").innerHTML = "Felicidades, terminaste este contenido satisfactoriamente";
    document.getElementById("contenido").style.display = "block";
}
