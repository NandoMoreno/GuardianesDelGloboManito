package com.tg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.domain.Sponsor;
import com.tg.dto.SponsorDto;
import com.tg.repository.SponsorRepository;

@Service
public class SponsorServiceImplement implements SponsorService{
	
	@Autowired
	private SponsorRepository sponsorRepository;

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
		return null;
	}

	@Override
	public Sponsor modificarSponsor(SponsorDto sponsorDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarSponsor(Long sponsorId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
