package com.andrewknell.lookify.repositories;

import java.util.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andrewknell.lookify.models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
	List<Song> findAll();
	
}
