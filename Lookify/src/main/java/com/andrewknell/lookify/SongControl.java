package com.andrewknell.lookify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.andrewknell.lookify.models.Song;
import com.andrewknell.lookify.services.SongService;

@Controller
public class SongControl {
	private final SongService serv;
	
	public SongControl(SongService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@RequestMapping("/songs")
	public String songs(Model model) {
		List<Song> songs = serv.getAll();
		model.addAttribute("songs", songs);
		return "songs.jsp";
	}
	
	@RequestMapping("/byartist")
	public String search(@RequestParam(name="search", required=false)String find, Model model) {
		List<Song> songs = serv.getAll();
		List<Song> art = new ArrayList<Song>();
		for(int i=0;i<songs.size();i++) {
			if(songs.get(i).getArtist().contains(find)) {
				art.add(songs.get(i));
			}
		}
		model.addAttribute("songsby", art);
		return "byartist.jsp";
	}
	
	@RequestMapping("/addnew")
	public String addnew(@ModelAttribute("song")Song song) {
		return "new.jsp";
	}
	
	@PostMapping("/newSong")
	public String newSong(@Valid @ModelAttribute("song")Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			serv.create(song);
			return "redirect:/songs";
		}
	}
	
    @RequestMapping("/show/{id}")
    public String show(@PathVariable("id")long id, Model model) {
    	List<Song> songs = serv.getAll();
    	if(songs.size()>= 0) {
    		Song s = serv.findOne(id);
    		model.addAttribute("song", s);
    		return "show.jsp";
    	} else {
    		return "redirect:/songs";
    	}
    	
    }
	
	@RequestMapping("/topten")
	public String topTen(Model model) {
		List<Song> songs = serv.getAll();
		List<Song> sort = new ArrayList<Song>();
		Collections.sort(songs, Collections.reverseOrder());
		for(int i=0;i<10;i++) {
			sort.add(songs.get(i));
		}
		model.addAttribute("sorted", sort);
		return "topten.jsp";
	}
	
    @RequestMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        serv.delete(id);
        return "redirect:/songs";
    }
}
