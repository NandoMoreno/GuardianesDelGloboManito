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

import com.tg.dto.VillainDto;
import com.tg.service.VillainService;

@CrossOrigin("*")//Permite que todos los puertos tienen acceso
@RestController // Utilice APis rest
@RequestMapping("/api/villano") // Ruta donde va ser llamada mi Api
public class VillainController {
	
	private VillainService villanoService;
	
	@GetMapping("/consultarvillanos")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarVillain(){

        try {
            return ResponseEntity.ok().body(villanoService.consultarTodasLasVillains());
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@GetMapping("/consultarvillanosporhabilidad")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarVillanoPorHabilidad(@RequestParam("id") Long id){

        try {
            return ResponseEntity.ok().body(villanoService.encontrarVillanoPorHabilidad(id));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@GetMapping("/consultarvillanospordebilidad")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarVillanoPorDebilidad(@RequestParam("id") Long id){

        try {
            return ResponseEntity.ok().body(villanoService.encontrarVillanoPorDebilidad(id));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/guardarvillano")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarVillain(@RequestBody VillainDto villanoDto){

        try {
            return ResponseEntity.ok().body(villanoService.guardarVillain(villanoDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PutMapping("/actualizarvillano")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> actualizarVillain(@RequestBody VillainDto villanoDto){

        try {
            return ResponseEntity.ok().body(villanoService.modificarVillain(villanoDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/eliminarvillano")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> eliminarVillain(@RequestParam("id") Long villanoId){

        try {
        	villanoService.eliminarVillain(villanoId);
            return ResponseEntity.ok(villanoId);
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	

}
