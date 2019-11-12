package com.andrewknell.relationships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrewknell.relationships.models.Person;
import com.andrewknell.relationships.services.PLService;

@Controller
public class PLControl {
	private final PLService serv;
	 
	public PLControl(PLService serv) {
		this.serv = serv;
	}
	
	@RequestMapping("/")
	public String addPerson(@ModelAttribute("person")Person person) {
		return "index.jsp";
	}
}
