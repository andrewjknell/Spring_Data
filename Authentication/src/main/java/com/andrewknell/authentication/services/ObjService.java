package com.andrewknell.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewknell.authentication.models.Obj;
import com.andrewknell.authentication.repositories.ObjRepo;


@Service
public class ObjService {
	private final ObjRepo objRepo;

	public ObjService(ObjRepo objRepo) {
		this.objRepo = objRepo;
	}
	
	public List<Obj> getAll() {
        return objRepo.findAll();
    }
	
    public Obj update(Obj s) {
        return objRepo.save(s);
	}

	public void delete(Long x) {
		objRepo.deleteById(x);
		return;
	}
	
    public Obj create(Obj s) {
        return objRepo.save(s);
    }

    public Obj findOne(Long id) {
        Optional<Obj> opt = objRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
}
