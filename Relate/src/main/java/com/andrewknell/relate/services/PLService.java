package com.andrewknell.relate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewknell.relate.models.License;
import com.andrewknell.relate.models.Person;
import com.andrewknell.relate.repositories.LicenseRepo;
import com.andrewknell.relate.repositories.PersonRepo;

@Service
public class PLService {
	private final PersonRepo perRepo;
	private final LicenseRepo licRepo;
	private static String newNumber = "000000";
	
	public PLService(PersonRepo perRepo, LicenseRepo licRepo) {
		this.perRepo = perRepo;
		this.licRepo = licRepo;
	}

	public List<Person> getAll() {
        return perRepo.findAll();
    }
	
    public Person update(Person s) {
        return perRepo.save(s);
	}

	public void delete(Long x) {
		perRepo.deleteById(x);
		return;
	}
	
    public Person create(Person s) {
    	
        return perRepo.save(s);
    }

    public Person findOne(Long id) {
        Optional<Person> opt = perRepo.findById(id);
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
    	s.setNumber(newNumber);
    	newNumber= String.format("%06d", Integer.parseInt(newNumber)+1);
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
