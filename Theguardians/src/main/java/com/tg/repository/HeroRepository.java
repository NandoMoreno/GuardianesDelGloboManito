package com.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

	
}
