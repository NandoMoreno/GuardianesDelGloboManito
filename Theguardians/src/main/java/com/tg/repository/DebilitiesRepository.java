package com.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.Debilities;

@Repository
public interface DebilitiesRepository extends JpaRepository<Debilities, Long>{

}
