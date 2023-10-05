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

import com.tg.dto.HabilitiesDto;
import com.tg.dto.HeroDto;
import com.tg.dto.PeopleDto;
import com.tg.service.HeroService;

@CrossOrigin("*")//Permite que todos los puertos tienen acceso
@RestController // Utilice APis rest
@RequestMapping("/api/hero") // Ruta donde va ser llamada mi Api
public class HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@GetMapping("/consultarhero")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarHero(){

        try {
            return ResponseEntity.ok().body(heroService.consultarTodosLosHeros());
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@GetMapping("/consultarheropornombre")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarHeroPorNombre(@RequestParam("name") PeopleDto peopleDto, Long id){

        try {
            return ResponseEntity.ok().body(heroService.consultarHeroPorNombre(peopleDto, id));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@GetMapping("/consultarheropordebilidad")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
    public ResponseEntity<?> consultarHeroPorDebilidad(@RequestParam("hability") HabilitiesDto habilitiesDto, Long id){

        try {
            return ResponseEntity.ok().body(heroService.consultarHeroPorHabilidad(habilitiesDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PostMapping("/guardarhero")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> guardarHero(@RequestBody HeroDto heroDto){

        try {
            return ResponseEntity.ok().body(heroService.guardarHero(heroDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@PutMapping("/actualizarhero")// Indicar el frontend que tipo de operacion hace
	//Encargada de responder al llamado del origen con la info u codigo estatus 200 Ok ...
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> actualizarHero(@RequestBody HeroDto heroDto){

        try {
            return ResponseEntity.ok().body(heroService.modificarHero(heroDto));
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
	
	@DeleteMapping("/eliminarhero")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> eliminarHero(@RequestParam("id") Long heroId){

        try {
        	heroService.eliminarHero(heroId);
            return ResponseEntity.ok(heroId);
        }catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
