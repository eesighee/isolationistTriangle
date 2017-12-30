package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.Shop;
import com.rev.barberharbor.repository.BarberRepo;

@Service
@Transactional
public class BarberService {
	
	@Autowired
	private BarberRepo barberDao;
	
	public List<Barber> getAllBarbers(){
		return barberDao.findAll();
	}

}
