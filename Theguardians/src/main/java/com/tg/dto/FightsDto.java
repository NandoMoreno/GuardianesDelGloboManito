package com.tg.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FightsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long villainId;
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
	public FightsDto(Long id, Long villainId, Long heroId) {
		super();
		this.id = id;
		this.villainId = villainId;
		this.heroId = heroId;
	}
	public FightsDto() {
		super();
	}


}
