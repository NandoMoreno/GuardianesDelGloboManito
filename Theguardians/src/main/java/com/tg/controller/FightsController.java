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

import com.tg.dto.FightsDto;
import com.tg.service.FightsService;

@CrossOrigin("*")//Permite que todos los puertos tienen acceso
@RestController // Utilice APis rest
@RequestMapping("/api/fights") // Ruta donde va ser llamada mi Api
public class FightsController {
	
	@Autowired
	private FightsService fightsService;
	
	@GetMapping("/consultarfights")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarFights(){

        try {
            return ResponseEntity.ok().body(fightsService.consultarTodasLasFights());
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/guardarfight")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarFights(@RequestBody FightsDto fightsDto){

        try {
            return ResponseEntity.ok().body(fightsService.guardarFights(fightsDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PutMapping("/actualizarfights")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> actualizarFights(@RequestBody FightsDto fightsDto){

        try {
            return ResponseEntity.ok().body(fightsService.modificarFights(fightsDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/eliminarfights")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> eliminarFights(@RequestParam("id") Long fightsId){

        try {
        	fightsService.eliminarFights(fightsId);
            return ResponseEntity.ok(fightsId);
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
