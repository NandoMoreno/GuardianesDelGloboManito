package com.tg.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilitiesDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Long villainId;
	private Long heroId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public HabilitiesDto(Long id, String name, Long villainId, Long heroId) {
		super();
		this.id = id;
		this.name = name;
		this.villainId = villainId;
		this.heroId = heroId;
	}
	public HabilitiesDto() {
		super();
	}

}
