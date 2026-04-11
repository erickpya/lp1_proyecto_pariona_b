package com.cibertec.dao;

import java.util.List;
import com.cibertec.entidad.Regions;

public interface IRegionsDao {
	
	// Operaciones de escritura
	int guardar(Regions objRegion);
	int actualizar(Regions objRegion);
	int eliminar(int codigo);
	
	// Operaciones de lectura
	List<Regions> consultar();
	Regions consultarPorId(int codigo);
}


