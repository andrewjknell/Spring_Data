package com.andrewknell.dan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andrewknell.dan.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
