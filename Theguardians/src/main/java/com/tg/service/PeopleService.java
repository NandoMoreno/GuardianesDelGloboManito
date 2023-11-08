package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.People;
import com.tg.dto.PeopleDto;

@Service
public interface PeopleService {
	
	/**
	 * Metodo que consulta toda la people que esta activa en culiacan
	 * @return Una lista de personas
	 * @throws Exception
	 */
	public List<People> consultarTodasLasPeople() throws Exception;
	
	/**
	 * Metodo que consulta una persona por el id
	 * @param peopleId
	 * @return La informacion de esa persona en caso de que exista
	 * @throws Exception
	 */
	public People consultarPeoplePorId(Long peopleId) throws Exception;
	
	/**
	 * Metodo que guarda una persona
	 * @param peopleDto
	 * @return La persona a guardar en caso de sea exitoso
	 * @throws Exception
	 */
	public People guardarPeople(PeopleDto peopleDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	
	/**
	 * Metodo para modificar una persona
	 * @param peopleDto
	 * @return La persona modificada
	 * @throws Exception
	 */
	public People modificarPeople(PeopleDto peopleDto) throws Exception;
	
	/**
	 * Metodo para eliminar una persona
	 * @param peopleId
	 * @throws Exception
	 */
	public void eliminarPeople(Long peopleId) throws Exception;

	/**
	 * Metodo para encontrar a una persona con la edad
	 * @param edad
	 * @return
	 * @throws Exception
	 */
	public List<People> encontrarPeoplePorNombre(String name) throws Exception;
	
	/**
	 * Metodo para encontrar a toda la people con una edad 
	 * @param edad
	 * @return
	 * @throws Exception
	 */
	public List<People> encontrarPeoplePorEdad(Long edad) throws Exception;
	
	/**
	 * Metodo para encontrar la people en un rango de edad
	 * @param rango
	 * @return
	 * @throws Exception
	 */
	public List<People> encontrarPeoplePorRangoDeEdad(String rango) throws Exception;
}
