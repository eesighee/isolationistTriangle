package com.ex.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.barberharbor.model.Appointment;

 @Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer> {

}
