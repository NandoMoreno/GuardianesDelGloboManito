package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Hero;
import com.tg.dto.HeroDto;

@Service
public interface HeroService {
	
	public List<HeroDto> consultarTodosLosHeros() throws Exception;
	public Hero consultarHeroPorId(Long heroId) throws Exception;
	public Hero guardarHero(HeroDto heroDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Hero modificarHero(HeroDto heroDto) throws Exception;
	public void eliminarHero(Long heroId) throws Exception;	
	public List<HeroDto> consultarHeroPorNombre(String nombre)throws Exception;
	public List<Hero> consultarHeroPorHabilidad(Long id)throws Exception;

}
