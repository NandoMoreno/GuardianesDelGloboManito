package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.People;
import com.tg.dto.PeopleDto;
import com.tg.repository.PeopleRepository;
import com.tg.util.CONSTANTES;

@Service
public class PeopleServiceImplement implements PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Override
	public List<People> consultarTodasLasPeople() throws Exception {
		
		// TODO Auto-generated method stub
		List<People> listaPeople = peopleRepository.findAll();
		if (listaPeople.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");	
		}
		else {
			return listaPeople;
		}	
	}

	@Override
	public People consultarPeoplePorId(Long peopleId) throws Exception {
		
		// TODO Auto-generated method stub
		Optional<People> people = peopleRepository.findById(peopleId);
		if (people.isEmpty()) {
			throw new Exception("No existe ese elemento");	
		}
		else {
			return people.get();
		}		
	}

	@Override
	public People guardarPeople(PeopleDto peopleDto) throws Exception {
		// TODO Auto-generated method stub
		if (peopleDto == null) {
			throw new Exception("No se recibieron datos");
		}
		
		if (peopleDto.getName().equals("")) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		if (peopleDto.getAge() < 0) {
			throw new Exception("La edad no puede ser nula ");
		}
		
		People personaGuardar = new People();
		
		personaGuardar.setName(peopleDto.getName());
		personaGuardar.setAge(peopleDto.getAge());
		personaGuardar.setAgeRank(CONSTANTES.EDADES.devolverEdad(peopleDto.getAge()));
		
		return peopleRepository.save(personaGuardar);
	}

	@Override
	public People modificarPeople(PeopleDto peopleDto) throws Exception {
		// TODO Auto-generated method stub
		if (peopleDto == null) {
			throw new Exception("No se recibieron datos");
		}
		
		if (peopleDto.getId()== null) {
			throw new Exception("El id no puede ser nulo");
		}
		
		if (peopleDto.getName().equals("")) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		if (peopleDto.getAge() < 0) {
			throw new Exception("La edad no puede ser nula ");
		}
		
		if (peopleDto.getAgeRank().equals("")) {
			throw new Exception("El rango de edad no puede estar vacio");
		}
		
		Optional<People> personaBuscar = peopleRepository.findById(peopleDto.getId());
		 
		if (!personaBuscar.isPresent()) {
			throw new Exception("No existe la persona que se quiere modificar");
		}
		
		People people = new People();
		
		System.out.println(peopleDto.getAge());
		people.setId(peopleDto.getId());
		people.setName(peopleDto.getName());
		people.setAge(Long.valueOf(peopleDto.getAge()));
		people.setAgeRank(CONSTANTES.EDADES.devolverEdad(peopleDto.getAge()));
		
		return peopleRepository.save(people);
	}

	@Override
	public void eliminarPeople(Long peopleId) throws Exception {
		
		//Se valida que  el id que se recibe no sea nulo
		if (peopleId == null) {
			throw new Exception("El id no puede ser nulo");
		}
		
		//Se instacia la busqueda de la persona en la base de datos
		Optional<People> personaBuscar = peopleRepository.findById(peopleId);
		
		//Se valida que la persona no exista en la base de datos
		if (!personaBuscar.isPresent()) {
			throw new Exception("No existe la persona que se quiere eliminar");
		}
		
		/*Despues de validar que la personas si exista 
		consultamos esa persona y la guardamos en un objeto de ese tipo */
		People people = personaBuscar.get();
		
		/*Luego de haber hecho todas las consulta
		 * se procede a eliminar la persona */
		peopleRepository.delete(people);		
	}

	@Override
	public List<People> encontrarPeoplePorEdad(Long edad) throws Exception {
		// TODO Auto-generated method stub
		if(edad < 0) {
			throw new Exception("La edad no puede ser nula");
		}
		
		List<People> personasPorEdad = peopleRepository.findByAge(edad);
		
		if (personasPorEdad.isEmpty()) {
			throw new Exception("No hay ninguna persona con esa edad");
		}else {
			return personasPorEdad;
		}
	}

	@Override
	public List<People> encontrarPeoplePorRangoDeEdad(String rango) throws Exception {
		// TODO Auto-generated method stub
		if (rango.equals("")) {
			throw new Exception("El rango no puede ser nulo");
		}
		
		List<People> personasAencontrarPorRango = peopleRepository.findByAgeRank(rango);
		
		if (personasAencontrarPorRango.isEmpty()) {
			throw new Exception("No hay pesonas en este rango de edad o el rango no existe");
		}else {
			return personasAencontrarPorRango;
		}
	}

	@Override
	public List<People> encontrarPeoplePorNombre(String name) throws Exception {
		// TODO Auto-generated method stub
		if (name.equals("")) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		List<People> personasAencontrarPorNombre = peopleRepository.findByNameIs(name);
		
		if (personasAencontrarPorNombre.isEmpty()) {
			throw new Exception("No existe persona con ese nombre");
		}else {
			return personasAencontrarPorNombre;
		}
	}
}
