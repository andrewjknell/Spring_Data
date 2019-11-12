package com.andrewknell.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewknell.relationships.models.License;
import com.andrewknell.relationships.models.Person;
import com.andrewknell.relationships.repositories.LicenseRepo;
import com.andrewknell.relationships.repositories.Repo;

@Service
public class PLService {
	private final Repo repo;
	private final LicenseRepo licRepo;
	
	public PLService(Repo repo, LicenseRepo licRepo) {
		this.repo = repo;
		this.licRepo = licRepo;
	}
	
	public List<Person> getAll() {
        return repo.findAll();
    }
	
    public Person update(Person s) {
        return repo.save(s);
	}

	public void delete(Long x) {
		repo.deleteById(x);
		return;
	}
	
    public Person create(Person s) {
    	
        return repo.save(s);
    }

    public Person findOne(Long id) {
        Optional<Person> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
    
    public List<License> getAllL() {
        return licRepo.findAll();
    }
	
    public License update(License s) {
        return licRepo.save(s);

	}

	public void deleteL(Long x) {
		licRepo.deleteById(x);
		return;
	}
	
    public License create(License s) {
        return licRepo.save(s);
    }

    public License findOneL(Long id) {
        Optional<License> opt = licRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

}