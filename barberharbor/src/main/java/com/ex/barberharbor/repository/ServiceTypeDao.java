package com.ex.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.barberharbor.model.ServiceType;

@Repository
public interface ServiceTypeDao extends JpaRepository<ServiceType, Integer>{

}
