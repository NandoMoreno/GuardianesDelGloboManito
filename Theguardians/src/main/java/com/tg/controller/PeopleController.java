package com.tg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tg.dto.PeopleDto;
import com.tg.service.PeopleService;

@CrossOrigin("*")//Permite que todos los puertos tienen acceso
@RestController // Utilice APis rest
@RequestMapping("/api/people") // Ruta donde va ser llamada mi Api
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/consultarpersonas")// Indicar a el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarPersonas(){

        try {
            return ResponseEntity.ok().body(peopleService.consultarTodasLasPeople());
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@GetMapping("/consultarpersonaspornombre")// Indicar a el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarPersonasPorNombre(@RequestParam("nombre") String nombre){

        try {
            return ResponseEntity.ok().body(peopleService.encontrarPeoplePorNombre(nombre));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@GetMapping("/consultarpersonasporedad")// Indicar a el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarPersonasPorEdad(@RequestParam("edad") Long edad){

        try {
            return ResponseEntity.ok().body(peopleService.encontrarPeoplePorEdad(edad));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@GetMapping("/consultarpersonasporrango")// Indicar a el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarPersonasPorEdad(@RequestParam("rango") String rango){

        try {
            return ResponseEntity.ok().body(peopleService.encontrarPeoplePorRangoDeEdad(rango));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/guardarpersona")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> guardarPersona(@RequestBody PeopleDto peopleDto){

        try {
            return ResponseEntity.ok().body(peopleService.guardarPeople(peopleDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/actualizarpersona")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> actualizarPersona(@RequestBody PeopleDto peopleDto){

        try {
            return ResponseEntity.ok().body(peopleService.modificarPeople(peopleDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/eliminarpersona")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> eliminarPersona(@RequestParam("id") Long peopleId){

        try {
        	peopleService.eliminarPeople(peopleId);
            return ResponseEntity.ok(peopleId);
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
