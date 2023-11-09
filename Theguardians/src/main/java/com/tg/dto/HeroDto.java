package com.tg.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long id;
	private Long wins;
	private Long peopleId;
	private String name; 
	private Long edad;
	private String rangoEdad;
	private Long hability;
	private String nombreHabilidad;
	
	public HeroDto(
			Long peopleId, 
			Long id, 
			String name, 
			Long edad, 
			String rangoEdad, 
			Long wins,
			Long habilidad,
			String nombreHabilidad) {
		super();
		this.peopleId = peopleId;
		this.id = id;
		this.name = name;
		this.edad = edad;
		this.rangoEdad = rangoEdad;
		this.wins = wins;
		this.hability = habilidad;
		this.nombreHabilidad = nombreHabilidad;
	}
	
	
	
}
