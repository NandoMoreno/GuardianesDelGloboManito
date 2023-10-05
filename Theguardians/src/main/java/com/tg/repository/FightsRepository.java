package com.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.Fights;

@Repository
public interface FightsRepository extends JpaRepository<Fights, Long>{

}
