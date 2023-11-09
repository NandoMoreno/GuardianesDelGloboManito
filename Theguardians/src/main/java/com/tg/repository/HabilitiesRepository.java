package com.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.Habilities;


@Repository
public interface HabilitiesRepository extends JpaRepository<Habilities, Long>{

	List<Habilities> findByName(String name);
	

}
