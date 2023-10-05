package com.tg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

	List<People> findByName(String name);
}
