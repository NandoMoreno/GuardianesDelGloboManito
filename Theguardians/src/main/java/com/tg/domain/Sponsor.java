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
@Table(name= "sponsor", schema = "public")
@Data //Me genera gets and setters 
@AllArgsConstructor //Todos los atributos de mi clase
@NoArgsConstructor //Crea constructor vacio
public class Sponsor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id //Mi atributo id va a ser la llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//El valor va a ser generado cada que se crea un objeto
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "people_id", nullable = false)
	private Long peopleId;
	
	@Column(name = "hero_id", nullable = false)
	private Long heroId;

	@Column(name = "money_amount", nullable = false)
	private String moneyAmount;
	
	@Column(name = "money_source", nullable = false)
	private String moneySource;
	
}
