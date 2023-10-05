package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Habilities;
import com.tg.domain.Hero;
import com.tg.domain.People;
import com.tg.dto.HabilitiesDto;
import com.tg.dto.HeroDto;
import com.tg.dto.PeopleDto;

@Service
public interface HeroService {
	
	public List<Hero> consultarTodosLosHeros() throws Exception;
	public Hero consultarHeroPorId(Long heroId) throws Exception;
	public Hero guardarHero(HeroDto heroDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Hero modificarHero(HeroDto heroDto) throws Exception;
	public void eliminarHero(Long heroId) throws Exception;	
	public List<People> consultarHeroPorNombre(PeopleDto peopleDto, Long heroId)throws Exception;
	public List<Hero> consultarHeroPorHabilidad(HabilitiesDto habilitiesDto)throws Exception;

}