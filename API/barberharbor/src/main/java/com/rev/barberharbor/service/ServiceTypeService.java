package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.ServiceType;
import com.rev.barberharbor.repository.ServiceTypeRepo;

@Service
@Transactional
public class ServiceTypeService {
	
	@Autowired
	ServiceTypeRepo strepo;
	
	public List<ServiceType> getAll() {
		return strepo.findAll();
	}
	
	public ServiceType getById(Long id) {
		return strepo.getOne(id);
	}

}
