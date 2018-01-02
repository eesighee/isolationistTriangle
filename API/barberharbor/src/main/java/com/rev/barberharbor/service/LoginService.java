package com.rev.barberharbor.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.User;
import com.rev.barberharbor.repository.BarberRepo;
import com.rev.barberharbor.repository.UserRepo;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private UserRepo users;
	
	@Autowired
	private BarberRepo barbers;

	public boolean usernameAvailable(String username) {
		return !users.existsByUsernameIgnoreCase(username);
	}
	
	public User login(String username, String password) {
		User u = users.findByUsernameIgnoreCaseAndPassword(username, DigestUtils.sha256Hex(password));
		if(u.getRole().getId() == 2) {
			u = barbers.getOne(u.getId());
		}
		return u;
	}
	
	public boolean emailAvailable(String email) {
		return !users.existsByEmailIgnoreCase(email);
	}
	
	public User register(User u) {
		u.setPassword(DigestUtils.sha256Hex(u.getPassword()));
		return users.save(u);
	}
	
	public Barber registerBarber(Barber b) {
		b.setPassword(DigestUtils.sha256Hex(b.getPassword()));
		return barbers.save(b);
	}
	
}
