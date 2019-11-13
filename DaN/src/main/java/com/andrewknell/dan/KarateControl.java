package com.andrewknell.dan;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrewknell.dan.models.Dojo;
import com.andrewknell.dan.models.Ninja;
import com.andrewknell.dan.services.DJService;

@Controller
public class KarateControl {
	private final DJService serv;
	
	public KarateControl(DJService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/")
	public String addDojo(@ModelAttribute("dojo")Dojo d) {
		return "index.jsp";
	}
	
	@PostMapping("/newDojo")
	public String newDojo(@Valid @ModelAttribute("dojo")Dojo d, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			serv.create(d);
			return "index.jsp";
		}
		
	}
	
	@RequestMapping("/addNinja")
	public String addNinja(@ModelAttribute("ninja")Ninja n, Model model) {
		List<Dojo> dojos = serv.getAll();
		model.addAttribute("dojos", dojos);
		return "newninja.jsp";
	}
	
	@PostMapping("/newNinja")
	public String newNinja(@Valid @ModelAttribute("ninja")Ninja n, BindingResult result) {
		if(result.hasErrors()) {
			return "newninja.jsp";
		} else {
			serv.create(n);
			return "newninja.jsp";
		}
	}
	
	
	
	
}