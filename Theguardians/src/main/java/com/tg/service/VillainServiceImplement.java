package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Villain;
import com.tg.dto.VillainDto;
import com.tg.repository.VillainRepository;

@Service
public class VillainServiceImplement implements VillainService{
	
	@Autowired
	private VillainRepository villainRepository;

	@Override
	public List<Villain> consultarTodasLasVillains() throws Exception {
		
		// TODO Auto-generated method stub
		List<Villain> listaVillain = villainRepository.findAll();
		if (listaVillain.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");	
		}
		else {
			return listaVillain;
		}
	}

	@Override
	public Villain consultarVillainPorId(Long villainId) throws Exception {
		
		// TODO Auto-generated method stub
		Optional<Villain> villain = villainRepository.findById(villainId);
		if (villain.isEmpty()) {
			throw new Exception("No existe ese elemento");	
		}
		else {
			return villain.get();
		}	
	}

	@Override
	public Villain guardarVillain(VillainDto villainDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Villain modificarVillain(VillainDto villainDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarVillain(Long villainId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
