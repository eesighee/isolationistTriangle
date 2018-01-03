package com.rev.barberharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findByCustomer_Id(Long id);
//	List<Appointment> findByServices_Barber_Id(Long id);	
	List<Appointment> findAllByStylingService_Id(Long id);
	

}