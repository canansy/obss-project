package com.springSecurity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springSecurity.bean.User;
import com.springSecurity.services.UserService;

@RestController
@RequestMapping("/users")
public class Controller {
	
	public Controller(){
		System.out.println("Test");
	}

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getUsers(){
		return Arrays.asList(new User());
	}
	

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id){
		return userService.getUser(id);
	}
	
	@PostMapping
	public void saveUser(@RequestBody User user){
		userService.saveUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable long id, @RequestBody User user){
		//userService.updateUser(id, user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id){
		//delete user
		userService.deleteUser(id);
	}
	
	
}
