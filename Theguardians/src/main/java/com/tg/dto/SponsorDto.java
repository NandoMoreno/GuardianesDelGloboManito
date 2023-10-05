package com.tg.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SponsorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long peopleId;
	private Long heroId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Long peopleId) {
		this.peopleId = peopleId;
	}
	public Long getHeroId() {
		return heroId;
	}
	public void setHeroId(Long heroId) {
		this.heroId = heroId;
	}
	public SponsorDto(Long id, Long peopleId, Long heroId) {
		super();
		this.id = id;
		this.peopleId = peopleId;
		this.heroId = heroId;
	}
	public SponsorDto() {
		super();
	}
	
	
}
