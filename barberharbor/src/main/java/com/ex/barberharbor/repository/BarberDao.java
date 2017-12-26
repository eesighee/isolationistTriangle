package com.ex.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.barberharbor.model.Barber;

@Repository
public interface BarberDao extends JpaRepository<Barber, Integer> {

}
