package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Fights;
import com.tg.dto.FightsDto;
import com.tg.repository.FightsRepository;

@Service
public class FightsServiceImplement implements FightsService {
	
	@Autowired
	private FightsRepository fightsRepository;

	@Override
	public List<Fights> consultarTodasLasFights() throws Exception {
		
		// TODO Auto-generated method stub
		List<Fights> listaFights = fightsRepository.findAll();
		if (listaFights.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");	
		}
		else {
			return listaFights;
		}
		
	}

	@Override
	public Fights consultarFightsPorId(Long fightsId) throws Exception {
		
		// TODO Auto-generated method stub
		Optional<Fights> fights = fightsRepository.findById(fightsId);
		if (fights.isEmpty()) {
			throw new Exception("No existe ese elemento");	
		}
		else {
			return fights.get();
		}	
	}

	@Override
	public Fights guardarFights(FightsDto fightsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fights modificarFights(FightsDto fightsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarFights(Long fightsId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
