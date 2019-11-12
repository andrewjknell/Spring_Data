package com.andrewknell.relate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewknell.relate.models.License;


@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	List<License> findAll();
}