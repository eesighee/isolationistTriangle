package com.ex.barberharbor.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.barberharbor.model.Appointment;
import com.ex.barberharbor.model.Barber;
import com.ex.barberharbor.model.HarborUser;
import com.ex.barberharbor.repository.AppointmentDao;
import com.ex.barberharbor.repository.BarberDao;
import com.ex.barberharbor.repository.HarborUserDao;

@Service
@Transactional
public class BHServiceImp implements BHService{
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private BarberDao barberDao;
	
	@Autowired
	private HarborUserDao harborUserDao;
	
	
	
	@Override
	public void addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment findAppointById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBarber(Barber barber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment findBarberById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHarborUser(HarborUser harborUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Appointment findHarborUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
