package com.rev.barberharbor.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.User;
import com.rev.barberharbor.repository.UserRepo;

@Service
@Transactional
public class UserService {
	
	private UserRepo userRepo;

	public User findById(long id) {
		return userRepo.getOne(id);
	}

}
