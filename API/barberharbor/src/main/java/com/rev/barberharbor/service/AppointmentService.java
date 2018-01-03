package com.rev.barberharbor.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Appointment;
import com.rev.barberharbor.repository.AppointmentRepo;

@Service
@Transactional
public class AppointmentService {
	
	@Autowired
	private AppointmentRepo dao;

	public List<Appointment> findAllByStylingService_Id(Long id) {
		return dao.findAllByStylingService_Id(id);
	}

	public List<Appointment> findAllByBarber_Id(long id) {
		return dao.findByCustomer_Id(id);
	}
	
	
	
}