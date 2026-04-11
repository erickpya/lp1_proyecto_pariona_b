package com.cibertec.pruebas;
import java.util.List;

import com.cibertec.dao.IRegionsDao;
import com.cibertec.dao.impl.RegionsDaoImpl;
import com.cibertec.entidad.Regions;

public class ProbandoRegionsProc {

	// main (Control + Espacio)
	public static void main(String[] args) {
		
		// INTERFACE     -    CLASE DE IMPLEMENTACION
		IRegionsDao regionDao = new RegionsDaoImpl();
		
		// Probando el procedimiento de insertar
		Regions objRegion = new Regions();
		objRegion.setRegionName("AFRICA");
		int insertar = regionDao.guardar(objRegion);
		System.out.println("Insertando : " + insertar);
		
		// Probando el procedimiento de actualizar
		Regions objRegion2 = new Regions();
		objRegion2.setRegionId(3);
		objRegion2.setRegionName("AMERICA DEL NORTE");
		objRegion2.setEstado(false);
		int actualizar = regionDao.actualizar(objRegion2);
		System.out.println("Actualizando : " + actualizar);
		
		// Probando el procedimiento de eliminar
		
		int eliminar = regionDao.eliminar(5);
		System.out.println("Eliminar: " + eliminar);
		
		// Probando el procedimiento de consultar
		
		List<Regions> listado = regionDao.consultar();
		
		for( Regions x: listado ) {
			System.out.println(x.toString());
		}
		
		
		
		
		
		
		
		
		
	}
	
	
}
