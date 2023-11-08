package com.tg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

	Optional<People> findByName(String name);
	
	List<People> findByNameIs(String name);
	
	List<People> findByAge(Long age);
	
	List<People> findByAgeRank(String ageRank);
}
