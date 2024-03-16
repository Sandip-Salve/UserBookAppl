package com.app.UserBookAppl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.UserBookAppl.model.user.User;
import com.app.UserBookAppl.user.repository.IUserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private IUserRepository userRepo;

	public User addUser(User user) {
		return userRepo.save(user);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
