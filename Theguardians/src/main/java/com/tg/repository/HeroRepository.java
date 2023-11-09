package com.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tg.domain.Hero;
import com.tg.dto.HeroDto;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

	@Query(nativeQuery = true)
	List<HeroDto> consultarHeroes();
	
	@Query(nativeQuery = true)
	List<HeroDto> consultarHeroePorNombre(@Param("pNombre") String nombre);
	
	List<Hero> findByHability(Long hability);
}
