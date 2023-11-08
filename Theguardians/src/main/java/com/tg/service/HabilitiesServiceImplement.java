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
		if (habilitiesDto == null) {
			throw new Exception("La habilidad no puede ser nula");
		}
		
		if (habilitiesDto.getName().equals("")) {
			throw new Exception("El nombre de la habilidad no puede estar vacio");
		}
		
		Habilities habilidad = new Habilities();
		
		habilidad.setName(habilitiesDto.getName());
		
		return habilitiesRepository.save(habilidad);
	}

	@Override
	public Habilities modificarHabilidades(HabilitiesDto habilitiesDto) throws Exception {
		// TODO Auto-generated method stub
		if (habilitiesDto == null) {
			throw new Exception("La habilidad no puede ser nula");
		}
		
		if (habilitiesDto.getId() < 0) {
			throw new Exception("El id de la habilidad no puede ser nulo");
		}
		
		if (habilitiesDto.getName().equals("")) {
			throw new Exception("El nombre de la habilidad no puede estar vacio");
		}
		
		Habilities habilidad = new Habilities();
		
		habilidad.setId(habilitiesDto.getId());
		habilidad.setName(habilitiesDto.getName());
		
		return habilitiesRepository.save(habilidad);
	}

	@Override
	public void eliminarHabilidades(Long habilitiesId) throws Exception {
		// TODO Auto-generated method stub
		if (habilitiesId < 0) {
			throw new Exception("El id de la habilidad no puede ser nulo");
		}
		
		Optional<Habilities> habilidad = habilitiesRepository.findById(habilitiesId);
		
		if (habilidad.isPresent()) {
			habilitiesRepository.delete(habilidad.get());			
		}else {
			throw new Exception("No existe esa habilidad");
		}
	}

	@Override
	public List<Habilities> consultarHabilidadesPorNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		if (nombre.equals("")) {
			throw new Exception("El nombre de la habilidad no puede estar vacio");
		}
		
		List<Habilities> habilidad = habilitiesRepository.findByName(nombre);
		
		if (habilidad.isEmpty()) {
			throw new Exception("No existe la habilidad llamada "+nombre);
		}else {
			return habilidad;
		}
	}

}
