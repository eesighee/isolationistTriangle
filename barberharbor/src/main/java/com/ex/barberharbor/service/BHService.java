package com.ex.barberharbor.service;

import com.ex.barberharbor.model.Appointment;
import com.ex.barberharbor.model.Barber;
import com.ex.barberharbor.model.HarborUser;

public interface BHService {
	//public void addAccount(Account account);
	//public Account findAccountByEmail(String email);
	public void addAppointment(Appointment appointment);
	public Appointment findAppointById(Integer id);	
	public void addBarber(Barber barber);
	public Appointment findBarberById(Integer id);	
	public void addHarborUser(HarborUser harborUser);
	public Appointment findHarborUserById(Integer id);
}
