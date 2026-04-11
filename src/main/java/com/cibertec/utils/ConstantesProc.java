package com.cibertec.utils;

public class ConstantesProc {
	
	// INICIO PROCEDIMIENTOS DE LA TABLA REGIONS
	public static final String USP_REGIONS_INSERTAR
				= "{call usp_regions_guardar (?) }";
	
	public static final String USP_REGIONS_ACTUALIZAR
				= "{call usp_regions_actualizar (?,?,?) }";
	
	public static final String USP_REGIONS_ELIMINAR 
	  			= "{call usp_regions_eliminar (?) }";
	
	public static final String USP_REGIONS_CONSULTAR 
				= "{call usp_regions_consultar ()}";
	
	public static final String USP_REGIONS_CONSULTAR_X_ID 
				= "{call usp_regions_consultarXId (?)}";
	
	
	// FIN PROCEDIMIENTOS DE LA TABLA REGIONS

	
}
