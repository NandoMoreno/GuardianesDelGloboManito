package com.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long>{
	
	List<Sponsor> findByHeroId(Long heroId);
}
