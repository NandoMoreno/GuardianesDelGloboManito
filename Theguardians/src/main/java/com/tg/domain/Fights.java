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
@Table(name= "fights", schema = "public")
@Data //Me genera gets and setters 
@AllArgsConstructor //Todos los atributos de mi clase
@NoArgsConstructor //Crea constructor vacio
public class Fights implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //Mi atributo id va a ser la llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//El valor va a ser generado cada que se crea un objeto
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "villain_id", nullable = false)
	private Long villainId;
	
	@Column(name = "hero_id", nullable = false)
	private Long heroId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVillainId() {
		return villainId;
	}

	public void setVillainId(Long villainId) {
		this.villainId = villainId;
	}

	public Long getHeroId() {
		return heroId;
	}

	public void setHeroId(Long heroId) {
		this.heroId = heroId;
	}

	public Fights(Long id, Long villainId, Long heroId) {
		super();
		this.id = id;
		this.villainId = villainId;
		this.heroId = heroId;
	}

	public Fights() {
		super();
	}

}
