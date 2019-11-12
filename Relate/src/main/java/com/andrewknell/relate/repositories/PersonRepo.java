package com.andrewknell.relate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewknell.relate.models.Person;


@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
	List<Person> findAll();
	
}
