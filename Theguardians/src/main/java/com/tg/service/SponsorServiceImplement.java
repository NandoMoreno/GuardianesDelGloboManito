package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Hero;
import com.tg.domain.People;
import com.tg.domain.Sponsor;
import com.tg.dto.SponsorDto;
import com.tg.repository.HeroRepository;
import com.tg.repository.PeopleRepository;
import com.tg.repository.SponsorRepository;
import com.tg.util.CONSTANTES;

@Service
public class SponsorServiceImplement implements SponsorService{
	
	@Autowired
	private SponsorRepository sponsorRepository;
	
	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Override
	public List<Sponsor> consultarTodasLasSponsors() throws Exception {
		
		// TODO Auto-generated method stub
		List<Sponsor> listaSponsor = sponsorRepository.findAll();
		if (listaSponsor.isEmpty()) {
			throw new Exception("No hay ningun elemento en la Puta lista");	
		}
		else {
			return listaSponsor;
		}
	}

	@Override
	public Sponsor consultarSponsorPorId(Long sponsorId) throws Exception {
		
		// TODO Auto-generated method stub
		Optional<Sponsor> sponsor = sponsorRepository.findById(sponsorId);
		if (sponsor.isEmpty()) {
			throw new Exception("No existe ese elemento");	
		}
		else {
			return sponsor.get();
		}	
	}

	@Override
	public Sponsor guardarSponsor(SponsorDto sponsorDto) throws Exception {
		// TODO Auto-generated method stub
		if (sponsorDto == null) {
			throw new Exception("El patrocinador no puede ser nulo");
		}
		
		if (sponsorDto.getHeroId() < 0) {
			throw new Exception("El id del heroe a patrocinar no puede ser nulo");
		}
		
		if (sponsorDto.getPeopleId() < 0) {
			throw new Exception("El id de la persona debe ser un numero");
		}
		
		if (sponsorDto.getMoneySource().equals(CONSTANTES.FONDOS.LEGAL) || sponsorDto.getMoneySource().equals(CONSTANTES.FONDOS.ILEGAL)) {
			throw new Exception("El origen de los fondos ha sido rechazado por la DIAN");
		}
	
		Optional<People> personaABuscar = peopleRepository.findById(sponsorDto.getPeopleId());
		
		if (!personaABuscar.isPresent()) {
			throw new Exception("La persona base del patrocinador no existe");
		}
		
		Sponsor patrocinador = new Sponsor();
		
		patrocinador.setHeroId(sponsorDto.getHeroId());
		patrocinador.setPeopleId(sponsorDto.getPeopleId());
		patrocinador.setMoneyAmount(sponsorDto.getMoneyAmount());
		patrocinador.setMoneySource(CONSTANTES.FONDOS.confiabialidadDeLosFondos(sponsorDto.getMoneySource()));
		
		return sponsorRepository.save(patrocinador);
	}

	@Override
	public Sponsor modificarSponsor(SponsorDto sponsorDto) throws Exception {
		// TODO Auto-generated method stub
		if (sponsorDto == null) {
			throw new Exception("El patrocinador no puede ser nulo");
		}
		
		if (sponsorDto.getId() < 0) {
			throw new Exception("El id del patrocinador no puede ser nulo");
		}
		
		if (sponsorDto.getHeroId() < 0) {
			throw new Exception("El id del heroe a patrocinar no puede ser nulo");
		}
		
		if (sponsorDto.getPeopleId() < 0) {
			throw new Exception("El id de la persona debe ser un numero");
		}
		
		if (sponsorDto.getMoneySource().equals(CONSTANTES.FONDOS.LEGAL) || sponsorDto.getMoneySource().equals(CONSTANTES.FONDOS.ILEGAL)) {
			throw new Exception("El origen de los fondos ha sido rechazado por la DIAN");
		}
	
		Optional<People> personaABuscar = peopleRepository.findById(sponsorDto.getPeopleId());
		
		if (!personaABuscar.isPresent()) {
			throw new Exception("La persona base del patrocinador no existe");
		}
		
		Optional<Sponsor> patrocinadorABuscar = sponsorRepository.findById(sponsorDto.getId());
		
		if (!patrocinadorABuscar.isPresent()) {
			throw new Exception("El patrocinador no existe");
		}
		
		Sponsor patrocinador = new Sponsor();
		
		patrocinador.setId(sponsorDto.getId());
		patrocinador.setHeroId(sponsorDto.getHeroId());
		patrocinador.setPeopleId(sponsorDto.getPeopleId());
		patrocinador.setMoneyAmount(sponsorDto.getMoneyAmount());
		patrocinador.setMoneySource(CONSTANTES.FONDOS.confiabialidadDeLosFondos(sponsorDto.getMoneySource()));
		
		return sponsorRepository.save(patrocinador);
	}

	@Override
	public void eliminarSponsor(Long sponsorId) throws Exception {
		// TODO Auto-generated method stub
		if (sponsorId < 0) {
			throw new Exception("El ide no puede ser nulo o menor a cero");
		}
		
		Optional<Sponsor> sponsorAEliminar = sponsorRepository.findById(sponsorId);
		
		if (!sponsorAEliminar.isPresent()) {
			throw new Exception("El patrocinador que quiere eliminar no existe");
		}else {
			sponsorRepository.delete(sponsorAEliminar.get());
			
		}
	}

	@Override
	public List<Sponsor> consultarTodasLasSponsorsPorIDHeroe(Long idHeroe) throws Exception {
		// TODO Auto-generated method stub
		if (idHeroe < 0) {
			throw new Exception("Ingrese un hereo ID valido");
		}
		
		Optional<Hero> heroeABuscar = heroRepository.findById(idHeroe);
		
		if (!heroeABuscar.isPresent()) {
			throw new Exception("El heroe a buscar no existe");
		}
		
		List<Sponsor> patrocinadores = sponsorRepository.findByHeroId(idHeroe);
		
		if (!patrocinadores.isEmpty()) {
			throw new Exception("Ese heroe no tiene patrocinadores");
		}else {
			return patrocinadores;
		}
	}

}
