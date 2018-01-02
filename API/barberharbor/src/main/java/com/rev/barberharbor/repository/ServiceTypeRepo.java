package com.rev.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.ServiceType;

@Repository
public interface ServiceTypeRepo extends JpaRepository<ServiceType, Long>{

}
