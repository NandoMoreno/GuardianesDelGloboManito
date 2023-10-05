package com.tg.controller;

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

import com.tg.dto.SponsorDto;
import com.tg.service.SponsorService;

@CrossOrigin("*")//Permite que todos los puertos tienen acceso
@RestController // Utilice APis rest
@RequestMapping("/api/sponsor") // Ruta donde va ser llamada mi Api
public class SponsorController {
	
	private SponsorService sponsorService;
	
	@GetMapping("/consultarsponsor")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarSponsor(){

        try {
            return ResponseEntity.ok().body(sponsorService.consultarTodasLasSponsors());
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/guardarsponsor")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarSponsor(@RequestBody SponsorDto sponsorDto){

        try {
            return ResponseEntity.ok().body(sponsorService.guardarSponsor(sponsorDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PutMapping("/actualizarsponsor")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> actualizarSponsor(@RequestBody SponsorDto sponsorDto){

        try {
            return ResponseEntity.ok().body(sponsorService.modificarSponsor(sponsorDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/eliminarsponsor")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> eliminarSponsor(@RequestParam("id") Long SponsorId){

        try {
        	sponsorService.eliminarSponsor(SponsorId);
            return ResponseEntity.ok(SponsorId);
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
