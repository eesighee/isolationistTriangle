package com.rev.barberharbor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.User;
import com.rev.barberharbor.repository.BarberRepo;

@Service
@Transactional
public class BarberService {

	@Autowired
	private BarberRepo barberRepo;
	
	public Barber getById(long id) {
		return barberRepo.getOne(id);
	}
}
