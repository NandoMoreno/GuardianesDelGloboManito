package com.tg.domain;

import java.io.Serializable;

import com.tg.dto.HeroDto;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Serializable para hacer un serial "Cada clase debe estar serializada"

@NamedNativeQuery(name = "Hero.consultarHeroes", query = "", resultSetMapping = "consultarHeroes")

@SqlResultSetMapping(name="consultarHeroes", 
classes = { @ConstructorResult(targetClass = HeroDto.class,
	columns = {
			@ColumnResult(name = "peopleId", type = Long.class),
			@ColumnResult(name = "id", type = Long.class),
			@ColumnResult(name = "name", type = String.class),
			@ColumnResult(name = "edad", type = Long.class),
			@ColumnResult(name = "rangoEdad", type = String.class),
			@ColumnResult(name = "wins", type = Long.class),
			@ColumnResult(name = "habilidad", type = Long.class),
			@ColumnResult(name = "nombreHabilidad", type = String.class),
		} )})

@NamedNativeQuery(name = "Hero.consultarHeroePorNombre", query = "", resultSetMapping = "consultarHeroePorNombre")

@SqlResultSetMapping(name="consultarHeroePorNombre", 
classes = { @ConstructorResult(targetClass = HeroDto.class,
	columns = {
			@ColumnResult(name = "peopleId", type = Long.class),
			@ColumnResult(name = "id", type = Long.class),
			@ColumnResult(name = "name", type = String.class),
			@ColumnResult(name = "edad", type = Long.class),
			@ColumnResult(name = "rangoEdad", type = String.class),
			@ColumnResult(name = "wins", type = Long.class),
			@ColumnResult(name = "habilidad", type = Long.class),
			@ColumnResult(name = "nombreHabilidad", type = String.class),
		} )})

@Entity //Modelo de clase para basededatos 
@Table(name= "hero", schema = "public")
@Data //Me genera gets and setters 
@AllArgsConstructor //Todos los atributos de mi clase
@NoArgsConstructor //Crea constructor vacio
public class Hero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id //Mi atributo id va a ser la llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //El valor va a ser generado cada que se crea un objeto
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "wins")
	private Long wins;
	
	@Column(name = "people_id", nullable = false)
	private Long peopleId;
	
	@Column(name = "hability")
	private Long hability;
	
}
