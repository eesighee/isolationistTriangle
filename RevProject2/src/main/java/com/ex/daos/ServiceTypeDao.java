package com.ex.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.ServiceType;

@Repository
public interface ServiceTypeDao extends JpaRepository<ServiceType, Integer>{

}
