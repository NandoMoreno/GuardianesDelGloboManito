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
		
		if (villainDto == null) {
			throw new Exception("El villano no puede estar vacio");	
		}
		
		Villain villano = new Villain();
		
		villano.setDebility(villainDto.getDebilityId());
		villano.setHability(villainDto.getHability());
		villano.setPeopleId(villainDto.getPeopleId());

		return villainRepository.save(villano);
	}

	@Override
	public Villain modificarVillain(VillainDto villainDto) throws Exception {
		// TODO Auto-generated method stub
		if (villainDto == null) {
			throw new Exception("El villano no puede estar vacio");	
		}
		
		if (villainDto.getId() < 0) {
			throw new Exception("El id del villano no puede estar vacio");	
		}
		
		Optional<Villain> villanoABuscar = villainRepository.findById(villainDto.getId());
		
		if (!villanoABuscar.isPresent()) {
			throw new Exception("No existe el villano a modificar");
		}
		
		Villain villano = new Villain();
		
		villano.setId(villainDto.getId());
		villano.setDebility(villainDto.getDebilityId());
		villano.setHability(villainDto.getHability());
		villano.setPeopleId(villainDto.getPeopleId());

		return villainRepository.save(villano);
	}

	@Override
	public void eliminarVillain(Long villainId) throws Exception {
		// TODO Auto-generated method stub
		if (villainId < 0) {
			throw new Exception("El id no puede ser nulo");
		}
		
		Optional<Villain> villanoABuscar = villainRepository.findById(villainId);
		
		if (!villanoABuscar.isPresent()) {
			throw new Exception("No existe el villano a modificar");
		}else {
			villainRepository.delete(villanoABuscar.get());			
		}
	}

	@Override
	public List<Villain> encontrarVillanoPorHabilidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		if (id < 0) {
			throw new Exception("El id no puede ser nulo");
		}
		
		List<Villain> villanoAB = villainRepository.findByHability(id);
		
		if (villanoAB.isEmpty()) {
			throw new Exception("No existen villanos con esa habilidad");
		}else {
			return villanoAB;
		}
	}

	@Override
	public List<Villain> encontrarVillanoPorDebilidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		if (id < 0) {
			throw new Exception("El id no puede ser nulo");
		}

		List<Villain> villanoAB = villainRepository.findByDebility(id);
		
		if (villanoAB.isEmpty()) {
			throw new Exception("No existen villanos con esa debilidad");
		}else {
			return villanoAB;
		}
	}

}
