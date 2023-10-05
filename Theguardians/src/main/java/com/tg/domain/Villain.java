package com.tg.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Modelo de clase para basededatos 
@Table(name= "villain", schema = "public")
@Data //Me genera gets and setters 
@AllArgsConstructor //Todos los atributos de mi clase
@NoArgsConstructor //Crea constructor vacio
public class Villain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id //Mi atributo id va a ser la llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//El valor va a ser generado cada que se crea un objeto
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "power")
	private String power;
	
	@Column(name = "people_id", nullable = false)
	private Long peopleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Long getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}

	public Villain(Long id, String origin, String power, Long peopleId) {
		super();
		this.id = id;
		this.origin = origin;
		this.power = power;
		this.peopleId = peopleId;
	}

	public Villain() {
		super();
	}

}
