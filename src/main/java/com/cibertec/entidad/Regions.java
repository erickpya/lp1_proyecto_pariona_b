package com.cibertec.entidad;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regions {

	private int regionId;
	private String regionName;
	private Boolean estado;
	private LocalDateTime fechaRegistro;
	private LocalDateTime fechaActualizacion;
	
	
	
	
}
