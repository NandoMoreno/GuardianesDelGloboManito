package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Booking;
import com.tg.dto.BookingDto;

@Service
public interface BookingService {
	/**
	 * Consulta las reservas
	 * @return Retorna todas las reservas
	 * @throws Exception
	 */
	public List<Booking> consultarTodasLasReservas() throws Exception;
	public Booking consultarReservaPorId(Long bookingId) throws Exception;
	public Booking guardarReserva(BookingDto bookingDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Booking modificarReserva(BookingDto bookingDto) throws Exception;
	public void eliminarReserva(Long bookingId) throws Exception;
	

}
