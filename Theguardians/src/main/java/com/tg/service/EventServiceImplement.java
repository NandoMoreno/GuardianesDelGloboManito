package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Event;
import com.tg.dto.EventDto;
import com.tg.repository.EventRepository;

@Service
public class EventServiceImplement implements EventService{
	
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> consultarTodosLosEventos() throws Exception {
		
		// TODO Auto-generated method stub
		List<Event> listaEvent = eventRepository.findAll();
		if (listaEvent.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");	
		}
		else {
			return listaEvent;
		}
	}

	@Override
	public Event consultarEventosPorId(Long eventId) throws Exception {
		
		// TODO Auto-generated method stub
		Optional<Event> event = eventRepository.findById(eventId);
		if (event.isEmpty()) {
			throw new Exception("No existe ese elemento");	
		}
		else {
			return event.get();
		}
	}

	@Override
	public Event guardarEventos(EventDto eventDto) throws Exception {
		// TODO Auto-generated method stub
		if (eventDto == null) {
			throw new Exception("No se recibieron datos");
		}
		
		if (eventDto.getId() < 0) {
			throw new Exception("El nombre no puede estar vacio");
		}
		
		return null;
	}

	@Override
	public Event modificarEventos(EventDto eventDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarEventos(Long eventId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
