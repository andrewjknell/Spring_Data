package com.andrewknell.relationships.repositories;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewknell.relationships.models.License;

@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	List<License> findAll();
}
	
