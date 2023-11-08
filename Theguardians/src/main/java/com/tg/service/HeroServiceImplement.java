package com.tg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Habilities;
import com.tg.domain.Hero;
import com.tg.domain.People;
import com.tg.dto.HabilitiesDto;
import com.tg.dto.HeroDto;
import com.tg.dto.PeopleDto;
import com.tg.repository.HabilitiesRepository;
import com.tg.repository.HeroRepository;
import com.tg.repository.PeopleRepository;

import jakarta.transaction.Transactional;

@Service
public class HeroServiceImplement implements HeroService {

	@Autowired
	private HeroRepository heroRepository;

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private HabilitiesRepository habilitiesRepository;
	
	@Transactional
	@Override
	public List<HeroDto> consultarTodosLosHeros() throws Exception {

		// TODO Auto-generated method stub
		List<HeroDto> listaHero = heroRepository.consultarHeroes();
		if (listaHero.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");
		} else {
			return listaHero;
		}
	}

	@Override
	public Hero consultarHeroPorId(Long heroId) throws Exception {

		// TODO Auto-generated method stub
		Optional<Hero> hero = heroRepository.findById(heroId);
		if (hero.isEmpty()) {
			throw new Exception("No existe ese elemento");
		} else {
			return hero.get();
		}
	}

	@Override
	public Hero guardarHero(HeroDto heroDto) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(heroDto);
		if (heroDto == null) {
			throw new Exception("No se recibieron datos");
		}

		if (heroDto.getWins() < 0) {
			throw new Exception("Las wins no pueden ser menor a 0");
		}

		if (heroDto.getPeopleId() < 0) {
			throw new Exception("El id de la persona debe ser un numero");
		}
		
		Optional<People> personaABuscar = peopleRepository.findById(heroDto.getPeopleId());
		
		if (!personaABuscar.isPresent()) {
			throw new Exception("La persona base del heroe no existe");
		}

		Hero heroGuardar = new Hero();
		
		System.out.println(heroDto.getHability());
		
		heroGuardar.setWins(heroDto.getWins());
		heroGuardar.setPeopleId(heroDto.getPeopleId());
		heroGuardar.setHability(heroDto.getHability());
		
		return heroRepository.save(heroGuardar);
	}

	@Override
	public Hero modificarHero(HeroDto heroDto) throws Exception {
		// TODO Auto-generated method stub

		if (heroDto == null) {
			throw new Exception("No se recibieron datos");
		}

		if (heroDto.getId() < 0) {
			throw new Exception("El id no puede ser menor a 0");
		}

		if (heroDto.getWins() < 0) {
			throw new Exception("Las wins no pueden ser menor a 0");
		}

		if (heroDto.getPeopleId() < 0) {
			throw new Exception("El id no puede ser menor a 0");
		}

		Optional<Hero> heroBuscar = heroRepository.findById(heroDto.getId());

		if (!heroBuscar.isPresent()) {
			throw new Exception("No existe el heroe que se quiere modificar");
		}

		Hero heroModificar = new Hero();
		

		heroModificar.setId(heroDto.getId());
		heroModificar.setWins(heroDto.getWins());
		heroModificar.setPeopleId(heroDto.getPeopleId());

		return heroRepository.save(heroModificar);
	}

	@Override
	public void eliminarHero(Long heroId) throws Exception {
		// TODO Auto-generated method stub

		// Se valida que el id que se recibe no sea nulo
		if (heroId == null) {
			throw new Exception("El id no puede ser nulo");
		}

		// Se instacia la busqueda de la persona en la base de datos
		Optional<Hero> heroBuscar = heroRepository.findById(heroId);

		// Se valida que la persona no exista en la base de datos
		if (!heroBuscar.isPresent()) {
			throw new Exception("No existe la persona que se quiere eliminar");
		}

		/*
		 * Despues de validar que la personas si exista consultamos esa persona y la
		 * guardamos en un objeto de ese tipo
		 */
		Hero hero = heroBuscar.get();

		/*
		 * Luego de haber hecho todas las consulta se procede a eliminar la persona
		 */
		heroRepository.delete(hero);
	}

	@Override
	public List<HeroDto> consultarHeroPorNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		
		if (nombre.equals("")) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		List<HeroDto> heroeABuscar= heroRepository.consultarHeroePorNombre(nombre);
		
		if (heroeABuscar.isEmpty()) {
			throw new Exception("Ese heroe no existe");
		}else {
			return heroeABuscar;
		}
	}

	@Override
	public List<Hero> consultarHeroPorHabilidad(Long id) throws Exception {
		// TODO Auto-generated method stub
		
		if (id < 0) {
			throw new Exception("El id no debe de estar vacio");
		}
		
        Optional<Habilities> HabilidadABuscar = habilitiesRepository.findById(id);
		
        if (!HabilidadABuscar.isPresent()) {
        	throw new Exception("No existe esa habilidad");
        } 

        List<Hero> heroesPorHabilidad = heroRepository.findByHability(id); 
        
		if (heroesPorHabilidad.isEmpty()) {
			throw new Exception("No hay ningun heroe con esta habilidad");
		}else {
			return heroesPorHabilidad;
		}
	}


}
