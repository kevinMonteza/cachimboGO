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
    }
    return respuesta;
}