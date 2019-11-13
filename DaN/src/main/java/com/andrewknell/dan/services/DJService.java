package com.andrewknell.dan.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewknell.dan.models.Dojo;
import com.andrewknell.dan.models.Ninja;
import com.andrewknell.dan.repositories.DojoRepo;
import com.andrewknell.dan.repositories.NinjaRepo;

@Service
public class DJService {
	private final DojoRepo dR;
	private final NinjaRepo nR;
	
	public DJService(DojoRepo dR, NinjaRepo nR) {
		this.dR = dR;
		this.nR = nR;
	}
	
	public List<Dojo> getAll() {
        return dR.findAll();
    }
	
    public Dojo update(Dojo s) {
        return dR.save(s);
	}

	public void delete(Long x) {
		dR.deleteById(x);
		return;
	}
	
    public Dojo create(Dojo s) {
    	
        return dR.save(s);
    }

    public Dojo findOne(Long id) {
        Optional<Dojo> opt = dR.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
    
	public List<Ninja> getAllN() {
        return nR.findAll();
    }
	
    public Ninja update(Ninja s) {
        return nR.save(s);
	}

	public void deleteN(Long x) {
		nR.deleteById(x);
		return;
	}
	
    public Ninja create(Ninja s) {
    	
        return nR.save(s);
    }

    public Ninja findOneN(Long id) {
        Optional<Ninja> opt = nR.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }
}
