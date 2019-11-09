package com.andrewknell.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andrewknell.lookify.models.Song;
import com.andrewknell.lookify.repositories.SongRepo;

@Service
public class SongService {
	private final SongRepo repo;
	
	public SongService(SongRepo repo) {
		this.repo = repo;
	} 

	public List<Song> getAll() {
        return repo.findAll();
    }
	
    public Song update(Song s) {
        return repo.save(s);

	}

	public void delete(Long x) {
		repo.deleteById(x);
		return;
	}
	
    public Song create(Song s) {
        return repo.save(s);
    }

    public Song findOne(Long id) {
        Optional<Song> opt = repo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

}
