package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.repository.BarberRepo;

@Service
@Transactional
public class BarberService {

	@Autowired
	private BarberRepo barberRepo;
	
	public Barber getById(Long id) {
		return barberRepo.getOne(id);
	}
	
	public List<Barber> getAllBarbers() {
		return barberRepo.findAll();
	}
	
	public List<Barber> findAllByShop_Id(Long id) {
		return barberRepo.findAllByShop_Id(id);
	}

}
