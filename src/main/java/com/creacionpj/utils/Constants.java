package com.creacionpj.utils;
public final class Constants {
;
    private Constants(){
        throw new  UnsupportedOperationException("Esta es Una Class de Utilidad.");
    }

    //GENERAL
    public static final String VALOR_NOM = "Valor";
    public static final String PREDETERMINADO_NOM = "Predeterminado";
    public static final String SUBIDA_OTROS_TABLA = "Tabla_de_Otros";
    public static String DOS_PUNTOS = ":";
    //FK
    public static final String SUBIDA_FK = "Subida_FK";
    public static final String CLASES_FK = "Clase_FK";
    public static final String EQUIPO_FK = "Equipo_FK";
    public static final String BAGAJE_FK = "Bagaje_FK";
    public static final String HERENCIA_FK = "Herencia_FK";
    public static final String LIBRE_FK = "Libre_FK";
    public static final String HABILIDADES_FK = "Habilidades_FK";
    public static final String STATS_FK = "Estadisticas_FK";
    public static final String COMPETENCIA_FK = "Competencias_FK";
    public static final String ASCENDENCIA_FK = "Ascendencia_FK";
    public static final String REQUISITOS_FK = "Requisito_FK";
    public static final String RASGOS_FK = "Rasgos_FK";
    public static final String DOTES_FK = "Dotes_FK";
    public static final String HECHIZO_FK = "Hechizo_FK";
    public static final String SUBIDA_NIVEL_FK = "Subida_Nivel_FK";


    //CLASES
    public static final String CLASES_TABLA_NOM="Clase_TABLA";
    public static final String ESTADISTICAS_CLASE = "Estadisticas_Clase";
    public static final String COMPETENCIA_CLASE = "Competencias_Clase";
    public static final String IDIOMAS = "Idiomas";
    public static final String ESPECIAL = "Especial";
    public static final String DOTES = "Dotes";
    public static final String CLASE_ID = "Clase_Id";
    public static final String REQUISITO_CLASE = "Clase_Requerida";
    public static final String HABILIDADES_CLASE = "Habilidades_Clase";
    public static final String CLASE_NOMBRE = "Nombre_Clase";
    public static final String CLASE_TRADICION = "Tradición mágica de la Clase";
    
    //ESTADISTICAS
    public static final String STATS_NOM = "Estadisticas_TABLA";
    public static final String FUERZA_NOM = "Fuerza";
    public static final String CARISMA_NOM = "Carisma";
    public static final String SABIDURIA_NOM = "Sabiduria";
    public static final String INTELIGENCIA_NOM = "Inteligencia";
    public static final String CONSTITUCION_NOM = "Constitución";
    public static final String DESTREZA_NOM = "Destreza";
    public static final String SUBIDA_STATS_NOM = "Subida_Estadisticas";
    public static final String STATS_OPCIONES = "Estadisticas_Opcionales";
    public static final String STATS_FIJO = "Estadisticas_Predeterminadas";
    
    //COMPETENCIAS
    public static final String COMPETENCIAS_TABLA_NOM= "Competencias_TABLA";
    public static final String SIN_ARMADURAS_NOM = "Sin_Armadura";
    public static final String ARMADURAS_LIGERAS_NOM = "Armadura_Ligera";
    public static final String ARMADURAS_MEDIAS_NOM = "Armadura_Media";
    public static final String ARMADURAS_PESADAS_NOM = "Armadura_Pesada";
    public static final String FORTALEZA_NOM = "Fortaleza";
    public static final String REFLEJOS_NOM = "Reflejos";
    public static final String VOLUNTAD_NOM = "Voluntad";
    public static final String SIN_ARMAS_NOM = "Sin_Armas";
    public static final String ARMAS_SIMPLES_NOM = "Armas_Simples";
    public static final String ARMAS_MARCIALES_NOM = "Armas_Marciales";
    public static final String ARMAS_AVANZADAS_NOM = "Armas_Avanzadas";
    public static final String PERCEPCION_NOM = "Percepción";
    public static final String PROFICIENCY_ID = "Competencia_Id";
    public static final String SUBIDA_COMPETENCIA_NOM = "Subida_Competencias_Combate";
    public static final String COMPETENCIAS_OPCIONES = "Opciones_Competencias_Combate";
    public static final String COMPETENCIAS_BASE = "Competencias_Base";    
    
    //HABILIDADES
    public static final String HABILIDADES_TABLA_NOM = "Habilidades_TABLA";
    public static final String ACROBACIAS_NOM = "Acrobacias";
    public static final String ARCANO_NOM = "Arcano";
    public static final String ARTESANIA_NOM = "Artesania";
    public static final String ATLETISMO_NOM = "Atletismo";
    public static final String DIPLOMACIA_NOM = "Diplomacia";
    public static final String ENGANO_NOM = "Engaño";
    public static final String INTERPRETACION_NOM = "Interpretación";
    public static final String INTIMIDACION_NOM = "Intimidación";
    public static final String LATROCINIO_NOM = "Latrocinio";
    public static final String MEDICINA_NOM = "Medicina";
    public static final String NATURALEZA_NOM = "Naturaleza";
    public static final String OCULTISMO_NOM = "Ocultismo";
    public static final String RELIGION_NOM = "Religión";
    public static final String SIGILO_NOM = "Sigilo";
    public static final String SOCIEDAD_NOM = "Sociedad";
    public static final String SUPERVIVENCIA_NOM = "Supervivencia";
    public static final String SABER_NOM = "Saber";
    public static final String SUBIDA_HABILIDAD_NOM = "Subida_Habilidad";
    public static final String HABS_OPCIONES = "Habilidades_Opcionales";
    public static final String HABS_NOM = "Habilidades";
    public static final String HABS_FIJO = "Habilidades_Fijas";

    //Ascendencia
    public static final String ASCENDENCIA_TABLE_NOM = "Ascendencia_TABLA";
    public static final String DOTES_ASCENDENCIA = "Dotes_Ascendencia";
    public static final String RASGOS_ASCENDENCIA = "Rasgos_Ascendencia";
    public static final String VELOCIDAD_NOM = "Velocidad";
    public static final String ESTADISTICAS_ASCENDENCIA = "Estadisticas_Ascendencia";
    public static final String TAMANO_NOM = "Tamaño";
    public static final String VIDA_NOM = "Puntos_de_Golpe";  

    //BAGAJE
    public static final String BAGAJE_TABLE_NOM= "Bagaje_TABLA";
    public static final String HABILIDADES_BAGAJE = "Habilidades_Bagaje";
    public static final String ESTADISTICAS_BAGAJE = "Estadisticas_Bagaje";
    public static final String BAGAJE_DESCRIPCION = "Descripción_Bagaje";
    public static final String BAGAJE_NOM = "Nombre_Bagaje";

    //EQUIPO
    public static final String EQUIPO_TABLE_NOM="Equipo_TABLA";
    public static final String EQUIPO_NOM = "Nombre_De_La_Pieza";
    public static final String PRECIO = "Precio";
    public static final String BONUS = "Bonificador";
    public static final String EFECTO = "Efecto";
    public static final String EQUIPO_ID = "Equipo_Id";
    public static final String PESO = "Peso";
    public static final String EQUIPO_TIPO = "Equipo_Tipo";
    public static final String EQUIPO_DANO = "Daño del Equipo";
    public static final String MODIFICADOR_EQUIPO = "Modificadores del Equipo";
    public static final String EQUIPO_EQUIPADO = "Está_equipado";
    
    //PERSONAJE
    public static final String PJ_TABLE_NOM="Personaje_TABLA";
    public static final String LVL_NOM = "Nivel_Personaje";
    public static final String NOMBRE_NOM = "Nombre_Personaje";
    public static final String PERSONAJE_ID = "Personaje_Id";
    public static final String LIBRE_TABLE_NOM="Elección_Personaje";

    //DOTE
    public static final String DOTE_TABLE_NOM = "Dote_TABLA";
    public static final String DOTE_ID = "Dote_Id";
    public static final String DOTE_NOM = "Nombre_Dote";
    public static final String DOTE_DESCRIPCION = "Descripcion_Dote";
    public static final String DOTE_TIPO = "Tipo_Dote";
    public static final String DOTES_BAGAJE = "Dotes_Bagaje";

    //HUECOS DOTE
    public static final String HUECOS_DOTE_NOM_TABLA= "Huecos_Dotes_TABLA";
    public static final String HUECO_DOTE = "Dote_Hueco";
    public static final String HUECO_TIPO_DOTE = "Tipo_Dote_hueco";
    public static final String HUECO_NIVEL_DOTE = "Nivel_Hueco_Dote";
    public static final String HUECO_PERSONAJE = "Hueco_Dote_Personaje";

    //REQUISITO
    public static final String REQUISITO_TABLE_NOM = "Requisitos_TABLA";
    public static final String REQUISITOS_NOM = "Requisito";
    public static final String REQUISITOS_OPCIONES = "Requisitos_Opcion";
    public static final String REQUISITO_DOTE = "Dote_Requerida";
    public static final String REQUISITO_ASCENDENCIA = "Ascendencia_Requerida";
    public static final String HERENCIA_REQUISITO = "Requisito_Herencia";
    public static final String REQUISITO_STAT = "Requisito_Estadisticas";
    public static final String REQUISITO_EQUIPO = "Requisito_Equipo";
    public static final String REQUISITO_HABILIDAD = "Requisito_Habilidad";

    //LIBRE
    public static final String ESTADISTICAS_LIBRE = "Estadisticas_elegidas";
    public static final String HABILIDADES_LIBRE = "Habilidades_elegidas";
    
    //ASCENDENCIA Y HERENCIA
    public static final String ASCENDENCIA_HERENCIA = "Herencia_Ancestria";
    public static final String ASCENDENCIA_NOM = "Nombre_Ascendencia";
    public static final String HERENCIA_TABLE_NOM = "Herencia";
    public static final String HERENCIA_NOM = "Nombre_Herencia";
    public static final String HERENCIA_DESCRIPCION = "Descripción_Herencia";
    public static final String HERENCIA_NO_PERTENECE = "La Herencia no pertenece a este Ascendencia.";

    //ERRORES DE BUSQUEDA
    public static final String EQUIPO_NO_ENCONTRADO = "El Equipo no Existe.";
    public static final String ASCENDENCIA_NO_ENCONTRADA = "La Ascendencia no Existe.";
    public static final String HERENCIA_NO_ENCONTRADA = "La Herencia no Existe.";
    public static final String BAGAJE_NO_ENCONTRADO = "El Bagaje no existe.";
    public static final String CLASE_NO_ENCONTRADA = "La Clase no existe.";
    public static final String DOTE_NO_ENCONTRADA = "La Dote no existe.";
    public static final String PJ_NO_ENCONTRADO = "El Personaje no existe.";
    public static final String SUBIDA_NO_ENCONTRADA = "La Subida no es correcta.";
    public static final String STATS_DUPLICADOS = "Las Estadisticas están duplicadas.";
    public static final String HECHIZO_NO_ENCONTRADO = "El Hechizo no Existe.";    

    //CANTIDADES
    public static final String CANTIDAD_COMPETENCIAS = "Cantidad_Competencias";
    public static final String CANTIDAD_ESTADISTICAS = "Cantidad_Estadisticas";
    public static final String CANTIDAD_DOTES_ASCENDENCIA = "Cantidad_Dote_Ascendencia";
    public static final String CANTIDAD_DOTES_GENERAL = "Cantidad_Dote_General";
    public static final String CANTIDAD_DOTES_HABILIDAD = "Cantidad_Dote_Habilidad";
    public static final String CANTIDAD_DOTES_CLASE = "Cantidad_Dote_Clase";
    public static final String CANTIDAD_HABILIDADES = "Cantidad_Habilidades";
    public static final String TOTAL_HABILIDAD = "Cantidad_Habilidades_Elegir";
    public static final String TOTAL_ESTADISTICAS = "Cantidad_Estadisticas_Subir";
    public static final String SUBIDA_NIVEL_NOM = "Subida_Nivel";

    //ELECCIONES
    public static final String OPCIONES_STATS_CLASE = "Estadisticas_Disponibles_Clase";
    public static final String TIPO_ESTADISTICA = "Estadisticas_A_Elegir";
    public static final String OPCIONES_HABILIDAD = "Habilidades_Disponibles";
    public static final String TIPO_HABILIDAD = "Habilidades_A_Elegir";
    public static final String LIBRE_OPCIONES_STATS = "Opciones_Estadisticas_Elegir";
    public static final String LIBRE_OPCIONES_HABS = "Opciones_Habilidades_Elegir";
    public static final String OPCIONES_STATS_BAGAJE = "Estadisticas_disponibles_Bagaje";

    //RASGOS
    public static final String RASGOS_NOM = "Rasgos";
    public static final String RASGOS_EQUIPO = "Rasgos de Equipo";
    public static final String RASGOS = "Rasgos";
    public static final String RASGOS_NOMBRE = "Nombre del Rasgo";
    public static final String RASGOS_DESC = "Descripcion del Rasgo";
    public static final String RASGOS_ID = "Id de Rasgos";
    public static final String RASGOS_DOTE = "Rasgos de Dote";

    //HECHIZOS
    public static final String HECHIZOS_NOM_TABLE = "Hechizos";
    public static final String HECHIZOS_NIVEL = "Nivel_Hechizo";
    public static final String HECHIZOS_NOM = "Nombre_Hechizo";
    public static final String HECHIZOS_DESCRIPCION = "Descripción_Hechizo";
    public static final String HECHIZOS_POTENCIA_LVL = "Nivel_Potenciación_Hechizo";
    public static final String HECHIZOS_DANO = "Daño_Hechizo";
    public static final String HECHIZOS_POTENCIA_EFECTO = "Efecto_Potenciación_Hechizo";
    public static final String HECHIZOS_SALVACION = "Tirada_Salvación";
    public static final String HECHIZOS_ALCANCE = "Alcance_Hechizo";
    public static final String HECHIZOS_DURACION = "Duración_Hechizo";
    public static final String HECHIZOS_OBJETIVOS = "Objetivos_Hechizo";
    public static final String HECHIZOS_AREA = "Area_Hechizo";
    public static final String RASGOS_HECHIZO = "Rasgos_Hechizo";
    public static final String HECHIZOS_TRADICION = "Tradiciones_Hechizo";
    public static final String TRADICION_NOM = "Tradiciones";
    public static final String HECHIZOS_ACCIONES = "Acciones_Hechizo";
    public static final String ACCIONES_NOM = "Acciones";

    //HUECOS HECHIZO
    public static final String HUECO_HECHIZO_NOM_TABLA = "Huecos_Hechizos_TABLA";
    public static final String HUECO_NIVEL_HECHIZO = "Nivel_Hueco_Hechizo";
    public static final String HUECO_HECHIZO = "Hechizo_Hueco";

    //MODIFICADORES
    public static final String MODIFICADOR_NOM_TABLE="Modificadores";
    public static final String PENALIZADOR = "Penalizador";
    public static final String MODIFICIADOR_OBJETIVO = "Objetivo_Modificador";
    public static final String MODIFICADOR_VALOR = "Valor_Modificador";
    public static final String MODIFICADOR_FK = "Modificador_FK";
    public static final String MODIFICADOR_TIPO = "Tipo_Modificador";
    public static final String MODIFICADOR_DOTE = "Modificadores_Dotes";
    public static final String MODIFICADOR_HECHIZO = "Modificadores_Hechizos";
    public static final String SUBIDA_OTROS = "Efectos_Extras_Subida_Nivel";
    public static final String MODIFICADOR_NIVEL = "Modificadores_Subida_Nivel";
    public static final String CONJURO_COMP = "CD_Conjuro";
    public static final String CLASE_COMP = "CD_Clase";
    public static final String SUBIDA_REQUISITO = "Requisitos_Subida_Nivel";
    public static final String RASGO_NO_ENCONTRADO = "No se ha encontrado el Rasgo";
    public static final String ENTRADA_VACIA = "No se han introducido datos.";
    public static final String NIVEL_FUERA_RANGO = "El nivel indicado debe estar entre 1 y 20";
    public static final String SUBIDA_NIVEL_NO_ENCONTRADA = "Subida de Nivel no encontrada";
    public static final String CLASE_SIN_SUBIDA_NIVEL = "Esta clase no tiene subida de Nivel";
    public static final String SUBIDA_NIVEL_YA_EXISTE = "Una subida de nivel para esta clase y nivel ya existe.";
    public static final String ERROR_DESCONOCIDO = "Error desconocido.";
    public static final String ID_FUERA_RANGO = "El id indicado está fuera de rango";
    public static final String EQUIPO_GRUPO = "Grupo_Equipo";
    public static final String EQUIPO_CATEGORIA = "Categoria_Equipo";
    public static final String NIVEL_MAXIMO_ALCANZADO = "No se puede subir el personaje por encima del nivel 20.";
    public static final String ESTADISTICAS_NO_PERMITIDAS = "No es permite seleccionar alguna de estas estadísticas.";
    public static final String ESTADISTICAS_EXCESIVAS = "Se han seleccionado Estadísticas de más.";
    public static final String ESTADISTICAS_REPETIDAS = "Estadísticas duplicadas.";
    public static final String HABILIDADES_REPETIDAS = "Habilidades duplicadas.";
    public static final String HABILIDADES_NO_PERMITIDAS = "No se permite seleccionar alguna de estas habilidades.";
    public static final String HABILIDADES_EXCESIVAS = "Se han seleccionado Habilidades de más.";
    public static final String ELECCION_ESTADISTICAS = "Elección_Estadisticas";
    public static final String ELECCION_HABILIDADES = "Elección_Habilidades";
    public static final String NIVEL_MINIMO_ALCANZADO = "El personaje se encuentra a nivel mínimo.";
    public static final String PJ_FK = "Personaje_FK";
    public static final String HUECO_DOTE_EN_USO = "El hueco ya tiene una dote.";
    public static final String HUECO_NO_ENCONTRADO = "Hueco no encontrado.";
    public static final String DOTE_REQUISITO_NO_CUMPLIDO = "La dote no cumple con los requisitos.";
    public static final String DOTE_TIPO_INCORRECTO = "Esta dote no es del tipo adecuado.";
}
