package com.rev.barberharbor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.User;
import com.rev.barberharbor.service.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService lserv;
	
	@RequestMapping(method=RequestMethod.POST)
	public User login(@RequestBody String[] data) {
		return lserv.login(data[0], data[1]);
	}
	
	@RequestMapping(value="/username", method=RequestMethod.POST)
	public boolean usernameAvailable(@RequestBody String username) {
		return lserv.usernameAvailable(username);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public User register(@RequestBody User u) {
		return lserv.register(u);
	}

}
