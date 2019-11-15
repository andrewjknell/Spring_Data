package com.andrewknell.authentication;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andrewknell.authentication.models.Obj;
import com.andrewknell.authentication.models.User;
import com.andrewknell.authentication.services.ObjService;
import com.andrewknell.authentication.services.UserService;
import com.andrewknell.authentication.validator.UserValidator;

@Controller
public class Users {
	private final UserService userService;
	private final UserValidator userValidator;
	private final ObjService objserv;
	public Users(
			UserService userService,
			ObjService objserv,
			UserValidator userValidator
			) {
		this.userService = userService;
		this.objserv = objserv;
		this.userValidator = userValidator;
	}
	
	@GetMapping("/")
	public String home(@ModelAttribute("user") User user,@ModelAttribute("user2") User user2, @RequestParam(value="success", required=false)String s, Model model) {
		model.addAttribute("success", s);
		return "loginregistration.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes rA) {
		 userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginregistration.jsp";
		} else {
			rA.addAttribute("success", "congrats you're registered! please log in");
			User u = userService.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/";
		}
		
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, BindingResult result, @RequestParam("email_l") String email, @RequestParam("password_l") String password, HttpSession session, Model model) {
		if(userService.authenticateUser(email, password) == true) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Invalid login");
			return "loginregistration.jsp";
		}
		
	}
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} else {
			List<Obj> ideas = objserv.getAll();
			model.addAttribute("ideas", ideas);
			User u = userService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", u);
			
			return "home.jsp";
		}
	}

	@GetMapping("/addIdea")
	public String addIdea(@ModelAttribute("obj")Obj idea, Model model,HttpSession session ) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", u);
		return "newIdea.jsp";
	}
	
	@PostMapping("/newIdea")
	public String newProduct(@Valid @ModelAttribute("obj")Obj idea, BindingResult result) {
		if(result.hasErrors()) {
			return "newIdea.jsp";
		} else {
			objserv.create(idea);
			return "redirect:/addIdea";
		}
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		Obj idea = objserv.findOne(id);
		idea.getLikers().add(u);
		objserv.update(idea);
		
		return "redirect:/home";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		Obj idea = objserv.findOne(id);
		for(int i = 0; i < idea.getLikers().size(); i++) {
			if(u.getId() == idea.getLikers().get(i).getId()) {
				idea.getLikers().remove(i);
				break;
			}
		}
		objserv.update(idea);
		return "redirect:/home";
	}
	
	@GetMapping("/viewidea/{id}")
	public String viewIdea(@PathVariable("id") Long id, HttpSession session, Model model) {
		Obj idea = objserv.findOne(id);
		model.addAttribute("idea", idea);
		User u = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", u);
		return "ideas.jsp";
	}
	
	@GetMapping("viewidea/edit/{id}")
	public String viewEdit(@PathVariable("id") Long id, @ModelAttribute("obj")Obj idea, Model model) {
		Obj idea1 = objserv.findOne(id);
		model.addAttribute("obj", idea1);
		return "edit.jsp";
		
	}
	
	@PostMapping("/updateidea/{id}")
	public String update(@Valid @ModelAttribute("obj")Obj idea, BindingResult result, @PathVariable("id")Long id){
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			Obj update = objserv.findOne(id);
			String add = idea.getIdea();
			update.setIdea(add);
			objserv.update(update);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}