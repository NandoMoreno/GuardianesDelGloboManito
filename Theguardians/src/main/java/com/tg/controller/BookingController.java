package com.tg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tg.dto.BookingDto;
import com.tg.service.BookingService;

@CrossOrigin("*")//Permite que todos los puertos tienen acceso
@RestController // Utilice APis rest
@RequestMapping("/api/booking") // Ruta donde va ser llamada mi Api
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/consultarreservas")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarReservas(){

        try {
            return ResponseEntity.ok().body(bookingService.consultarTodasLasReservas());
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/guardarreserva")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarReserva(@RequestBody BookingDto bookingDto){

        try {
            return ResponseEntity.ok().body(bookingService.guardarReserva(bookingDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PutMapping("/actualizarreserva")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> actualizarReserva(@RequestBody BookingDto bookingDto){

        try {
            return ResponseEntity.ok().body(bookingService.modificarReserva(bookingDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/eliminarreserva")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> eliminarReserva(@RequestParam("id") Long bookingId){

        try {
        	bookingService.eliminarReserva(bookingId);
            return ResponseEntity.ok(bookingId);
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
