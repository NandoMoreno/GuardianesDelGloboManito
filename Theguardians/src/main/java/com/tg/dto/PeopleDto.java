package com.tg.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private int age;
	private String ageRank;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAgeRank() {
		return ageRank;
	}
	public void setAgeRank(String ageRank) {
		this.ageRank = ageRank;
	}
	public PeopleDto(Long id, String name, int age, String ageRank) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.ageRank = ageRank;
	}
	public PeopleDto() {
		super();
	}


}
