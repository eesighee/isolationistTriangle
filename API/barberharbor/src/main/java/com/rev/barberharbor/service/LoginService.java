package com.rev.barberharbor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.User;
import com.rev.barberharbor.repository.UserRepo;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private UserRepo users;

	public boolean usernameAvailable(String username) {
		if(users.findByUsernameIgnoreCase(username) == null) return true;
		return false;
	}
	
	public User login(String username, String password) {
		return users.findByUsernameIgnoreCaseAndPassword(username, password);
	}
	
	public User register(User u) {
		return users.save(u);
	}
	
}
