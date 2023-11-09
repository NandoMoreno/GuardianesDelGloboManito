package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Debilities;
import com.tg.dto.DebilitiesDto;

@Service
public interface DebilitiesService {

	public List<Debilities> consultarTodasLasDebilidades() throws Exception;
	public Debilities consultarDebilidadesPorId(Long debilitiesId) throws Exception;
	public Debilities guardarDebilidades(DebilitiesDto debilitiesDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Debilities modificarDebilidades(DebilitiesDto debilitiesDto) throws Exception;
	public void eliminarDebilidades(Long debilitiesId) throws Exception;
	public List<Debilities> encontrarDebilidadPorNombre(String nombre) throws Exception;
}
