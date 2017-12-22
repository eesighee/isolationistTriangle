package com.ex.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.Appointment;
 @Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer> {

}
