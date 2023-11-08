package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Habilities;
import com.tg.dto.HabilitiesDto;

@Service
public interface HabilitiesService {
	
	public List<Habilities> consultarTodasLasHabilidades() throws Exception;
	public Habilities consultarHabilidadesPorId(Long habilitiesId) throws Exception;
	public List<Habilities> consultarHabilidadesPorNombre(String nombre) throws Exception;
	public Habilities guardarHabilidades(HabilitiesDto habilitiesDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Habilities modificarHabilidades(HabilitiesDto habilitiesDto) throws Exception;
	public void eliminarHabilidades(Long habilitiesId) throws Exception;

}
