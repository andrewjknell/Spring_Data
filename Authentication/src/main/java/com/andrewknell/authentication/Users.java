package com.andrewknell.authentication;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andrewknell.authentication.models.User;
import com.andrewknell.authentication.repositories.UserRepository;
import com.andrewknell.authentication.services.UserService;

@Controller
public class Users {
	private final UserService userService;
	private final UserRepository userRepository;
	public Users(
			UserService userService,
			UserRepository userRepository
			) {
		this.userService = userService;
		this.userRepository = userRepository;
	}
	
	@GetMapping("/")
	public String home(@ModelAttribute("user") User user,@ModelAttribute("user2") User user2, @RequestParam(value="success", required=false)String s, Model model) {
		model.addAttribute("success", s);
		return "loginregistration.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes rA) {
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
			User u = userService.findUserById((Long) session.getAttribute("userId"));
			return "home.jsp";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}