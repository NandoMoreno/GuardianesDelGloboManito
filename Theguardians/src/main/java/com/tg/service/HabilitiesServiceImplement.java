package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Habilities;
import com.tg.dto.HabilitiesDto;
import com.tg.repository.HabilitiesRepository;

@Service
public class HabilitiesServiceImplement implements HabilitiesService{
	
	@Autowired
	private HabilitiesRepository habilitiesRepository;

	@Override
	public List<Habilities> consultarTodasLasHabilidades() throws Exception {
		
		// TODO Auto-generated method stub
		List<Habilities> listaHabilities = habilitiesRepository.findAll();
		if (listaHabilities.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");	
		}
		else {
			return listaHabilities;
		}
	}

	@Override
	public Habilities consultarHabilidadesPorId(Long habilitiesId) throws Exception {
		
		// TODO Auto-generated method stub
		Optional<Habilities> habilities = habilitiesRepository.findById(habilitiesId);
		if (habilities.isEmpty()) {
			throw new Exception("No existe ese elemento");	
		}
		else {
			return habilities.get();
		}	
	}

	@Override
	public Habilities guardarHabilidades(HabilitiesDto habilitiesDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Habilities modificarHabilidades(HabilitiesDto habilitiesDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarHabilidades(Long habilitiesId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
