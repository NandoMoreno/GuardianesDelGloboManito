package com.tg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tg.domain.Sponsor;
import com.tg.dto.SponsorDto;

@Service
public interface SponsorService {
	
	public List<Sponsor> consultarTodasLasSponsors() throws Exception;
	public Sponsor consultarSponsorPorId(Long sponsorId) throws Exception;
	public Sponsor guardarSponsor(SponsorDto sponsorDto) throws Exception; //Recibir un objeto Dto para guardar como objeto de dominio
	public Sponsor modificarSponsor(SponsorDto sponsorDto) throws Exception;
	public void eliminarSponsor(Long sponsorId) throws Exception;

}
