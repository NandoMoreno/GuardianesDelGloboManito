package com.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tg.domain.Villain;
import com.tg.dto.HeroDto;

@Repository
public interface VillainRepository extends JpaRepository<Villain, Long>{

	@Query(nativeQuery = true)
	List<HeroDto> consultarVillanos();
	
	@Query(nativeQuery = true)
	List<HeroDto> consultarVillanoPorNombre(@Param("pNombre") String nombre);
	
	List<Villain> findByDebility(Long debility);
	
	List<Villain> findByHability(Long hability);
}
