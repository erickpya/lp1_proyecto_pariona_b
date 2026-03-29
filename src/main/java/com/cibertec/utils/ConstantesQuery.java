package com.cibertec.utils;

public class ConstantesQuery {
	
	/*INICIO QUERY PARA LA TABLA COUNTRIES*/
	// insertar
	// insert into countries(country_name, region_id) values (?,?)
	public static final String QUERY_COUNTRIES_INSERTAR 
			= "insert into countries(country_name, region_id) values (?,?)";
	// consultar todo
	// select country_id, country_name, region_id from countries
	
	// eliminar
	// delete from countries where country_id= ?
	
	// consultar por id
	// select country_id, country_name, region_id from countries
	// where country_id=?
	
	// actualizar
	// update countries set country_name=?, region_id=?
	// where country_id=?
	
	
	/*FIN QUERY PARA LA TABLA COUNTRIES*/

	/* PARA OTRAS TABLAS ......*/
	
	
}
