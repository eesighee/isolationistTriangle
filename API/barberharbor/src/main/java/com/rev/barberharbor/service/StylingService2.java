package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.StylingService;
import com.rev.barberharbor.repository.StylingServiceRepo;

@Service
@Transactional
public class StylingService2 {
	
	@Autowired
	private StylingServiceRepo dao;

	public List<StylingService> findStylingServicesByBarber_id(long id) {
		return dao.findAllByBarber_id(id);
	}
	
}
