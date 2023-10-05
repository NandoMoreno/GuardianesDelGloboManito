package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Debilities;
import com.tg.dto.DebilitiesDto;
import com.tg.repository.DebilitiesRepository;
@Service
public class DebilitiesServiceImplement implements DebilitiesService {
	
	@Autowired //Inyecta dependecias 
	private DebilitiesRepository debilitiesRepository;

	@Override
	public List<Debilities> consultarTodasLasDebilidades() throws Exception {
		
		// TODO Auto-generated method stub
		List<Debilities> listaDebilities = debilitiesRepository.findAll();
		if (listaDebilities.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");	
		}
		else {
			return listaDebilities;
		}
	}

	@Override
	public Debilities consultarDebilidadesPorId(Long debilitiesId) throws Exception {
		
		// TODO Auto-generated method stub
		Optional<Debilities> debility = debilitiesRepository.findById(debilitiesId);
		if (debility.isEmpty()) {
			throw new Exception("No existe ese elemento");	
		}
		else {
			return debility.get();
		}
	}

	@Override
	public Debilities guardarDebilidades(DebilitiesDto debilitiesDto) throws Exception {
		// TODO Auto-generated method stub
		
		if (debilitiesDto == null) {
			throw new Exception("No se recibieron datos");
		}
		
		if (debilitiesDto.getName().equals("")) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		if (debilitiesDto.getHeroId()== null) {
			throw new Exception("No se encontro el id de hero");
		}
		
		Debilities debilidadGuardar = new Debilities();
		
		debilidadGuardar.setName(debilitiesDto.getName());
		debilidadGuardar.setHeroId(debilitiesDto.getHeroId());
		
		return debilitiesRepository.save(debilidadGuardar);
	}

	@Override
	public Debilities modificarDebilidades(DebilitiesDto debilitiesDto) throws Exception {
		// TODO Auto-generated method stub
		
		if (debilitiesDto == null) {
			throw new Exception("No se recibieron datos");
		}
		
		if (debilitiesDto.getId() == null) {
			throw new Exception("El id no puede ser nulo");
		}
		
		if (debilitiesDto.getName().equals("")) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		if (debilitiesDto.getHeroId()== null) {
			throw new Exception("No se encontro el id de hero");
		}
		
		Optional<Debilities> debilidadBuscar = debilitiesRepository.findById(debilitiesDto.getId());
		 
		if (!debilidadBuscar.isPresent()) {
			throw new Exception("No existe la persona que se quiere modificar");
		}
		
		Debilities debilidad = new Debilities();
		
		debilidad.setId(debilitiesDto.getId());
		debilidad.setName(debilitiesDto.getName());
		debilidad.setHeroId(debilitiesDto.getHeroId());
		
		return debilitiesRepository.save(debilidad);
	}

	@Override
	public void eliminarDebilidades(Long debilitiesId) throws Exception {
		// TODO Auto-generated method stub
		
		//Se valida que  el id que se recibe no sea nulo
				if (debilitiesId == null) {
					throw new Exception("El id no puede ser nulo");
				}
		//Se instacia la busqueda de la persona en la base de datos
		Optional<Debilities> debilidadBuscar = debilitiesRepository.findById(debilitiesId);
				
		//Se valida que la persona no exista en la base de datos
		if (!debilidadBuscar.isPresent()) {
			throw new Exception("No existe la persona que se quiere eliminar");
				}
				
		/*Despues de validar que la personas si exista 
		consultamos esa persona y la guardamos en un objeto de ese tipo */
		Debilities debilidad = debilidadBuscar.get();
				
		/*Luego de haber hecho todas las consulta
		 se procede a eliminar la persona */
		debilitiesRepository.delete(debilidad);
	}

}
