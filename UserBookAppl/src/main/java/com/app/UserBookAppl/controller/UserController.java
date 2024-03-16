package com.app.UserBookAppl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.UserBookAppl.model.user.User;
import com.app.UserBookAppl.service.UserService;

@RestController
@RequestMapping("/user/api")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<String>("Home", HttpStatus.OK);
	}

	@GetMapping("/admin")
	public ResponseEntity<String> admin() {
		return new ResponseEntity<String>("Admin", HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<String> user() {
		return new ResponseEntity<String>("User", HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<User> addNewUser(@RequestBody User user) {
		User nwUser = userService.addUser(user);
		return new ResponseEntity<User>(nwUser, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUserDtls() {
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
}
