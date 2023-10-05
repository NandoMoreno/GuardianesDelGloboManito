package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Fights;
import com.tg.dto.FightsDto;

@Service
public interface FightsService {
	
	public List<Fights> consultarTodasLasFights() throws Exception;
	public Fights consultarFightsPorId(Long fightsId) throws Exception;
	public Fights guardarFights(FightsDto fightsDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Fights modificarFights(FightsDto fightsDto) throws Exception;
	public void eliminarFights(Long fightsId) throws Exception;

}
