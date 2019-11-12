package com.andrewknell.relate;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrewknell.relate.models.License;
import com.andrewknell.relate.models.Person;
import com.andrewknell.relate.services.PLService;

@Controller
public class PersonControl {
	private final PLService serv;
	
	public PersonControl(PLService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/")
	public String addPerson(@ModelAttribute("person")Person person) {
		return "index.jsp";
	}
	
	@PostMapping("/newPerson")
	public String newPerson(@Valid @ModelAttribute("person")Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			serv.create(person);
			return "index.jsp";
		}
	}
	
	@RequestMapping("/license")
	public String addLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> peeps = serv.getAll();
		model.addAttribute("users", peeps);
		return "license.jsp";
	}
	
	@PostMapping("/newLicense")
	public String newLicense(@Valid @ModelAttribute("license")License license, BindingResult result) {
		if(result.hasErrors()) {
			return "license.jsp";
		} else {
			serv.create(license);
			return "license.jsp";
		}
	}
}
