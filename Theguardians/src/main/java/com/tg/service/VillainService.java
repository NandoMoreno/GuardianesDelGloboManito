package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Villain;
import com.tg.dto.VillainDto;

@Service
public interface VillainService {
	
	public List<Villain> consultarTodasLasVillains() throws Exception;
	public Villain consultarVillainPorId(Long villainId) throws Exception;
	public Villain guardarVillain(VillainDto villainDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Villain modificarVillain(VillainDto villainDto) throws Exception;
	public void eliminarVillain(Long villainId) throws Exception;
	public List<Villain> encontrarVillanoPorHabilidad(Long id) throws Exception;
	public List<Villain> encontrarVillanoPorDebilidad(Long id) throws Exception;

}
