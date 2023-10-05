package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Event;
import com.tg.dto.EventDto;

@Service
public interface EventService {
	
	public List<Event> consultarTodosLosEventos() throws Exception;
	public Event consultarEventosPorId(Long eventId) throws Exception;
	public Event guardarEventos(EventDto eventDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Event modificarEventos(EventDto eventDto) throws Exception;
	public void eliminarEventos(Long eventId) throws Exception;

}
