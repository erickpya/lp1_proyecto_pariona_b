package com.cibertec.dao;

import java.util.List;

import com.cibertec.entidad.Countries;

public interface ICountriesDao {

	// GUARDAR
	int guardar(Countries objCountries);
	// ACTUALIZAR
	int actualizar(Countries objCountries);
	// ELIMINAR
	int eliminar(String countryId);
	// CONSULTAR TODO
	List<Countries> consultar();
	// CONSULTAR POR ID
	Countries consultarPorId(String countryId);
	
	
}
