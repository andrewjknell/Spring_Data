package com.andrewknell.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewknell.authentication.models.Obj;

@Repository
public interface ObjRepo extends CrudRepository<Obj, Long>{
	List<Obj> findAll();
}
