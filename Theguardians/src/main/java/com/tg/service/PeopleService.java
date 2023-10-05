package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.People;
import com.tg.dto.PeopleDto;

@Service
public interface PeopleService {
	
	public List<People> consultarTodasLasPeople() throws Exception;
	public People consultarPeoplePorId(Long peopleId) throws Exception;
	public People guardarPeople(PeopleDto peopleDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public People modificarPeople(PeopleDto peopleDto) throws Exception;
	public void eliminarPeople(Long peopleId) throws Exception;

}
