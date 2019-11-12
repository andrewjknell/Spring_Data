package com.andrewknell.relationships.repositories;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewknell.relationships.models.Person;


@Repository
public interface Repo extends CrudRepository<Person, Long> {
	List<Person> findAll();
	
}