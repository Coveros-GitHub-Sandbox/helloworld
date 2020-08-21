package com.fullstack.devops.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullstack.devops.exception.RecordNotFoundException;
import com.fullstack.devops.model.User;
import com.fullstack.devops.repository.UserRepository;

//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository repository;

	@GetMapping("/users")
	public String getAllUsers(Model model) {
		System.out.println("Get all Users...");

		List<User> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		System.out.println(list);
		model.addAttribute("users", list);
		return "list-users";
	}
	
	@GetMapping(path = { "/user/add" })
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "add-user";
	}

	@PostMapping(path = "/user/create")
	public String createUser( User user) {
		user = repository.save(user);
		return "redirect:/api/users";
	}
	
	@GetMapping(path = { "/user/update/{id}" })
	public String editEmployeeById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
		Optional<User> user = repository.findById(id);
		model.addAttribute("user", user);
		return "update-user";
	}
	
	@PostMapping(path = "/user/update")
	public String updateUser( User user) {
		user = repository.save(user);
		return "redirect:/api/users";
	}

	@GetMapping(path = "/user/delete/{id}")
	public String deleteUserById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
		repository.deleteById(id);
		return "redirect:/api/users";
	}
	@GetMapping(path = "/user/deleteall")
	public String deleteAllUsers() throws RecordNotFoundException {
		repository.deleteAll();
		return "redirect:/api/users";
	}
}
