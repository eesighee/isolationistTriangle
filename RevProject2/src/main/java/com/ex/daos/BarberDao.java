package com.ex.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.Barber;

@Repository
public interface BarberDao extends JpaRepository<Barber, Integer> {

}
