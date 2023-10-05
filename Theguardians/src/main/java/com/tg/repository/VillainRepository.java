package com.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.Villain;

@Repository
public interface VillainRepository extends JpaRepository<Villain, Long>{

}
