package com.andrewknell.dan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.andrewknell.dan.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
