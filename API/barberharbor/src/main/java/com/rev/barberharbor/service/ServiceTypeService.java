package com.rev.barberharbor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.ServiceType;
import com.rev.barberharbor.repository.ServiceTypeRepo;


@Service
@Transactional
public class ServiceTypeService {
		
		@Autowired
		private ServiceTypeRepo stRepo;
		
		public ServiceType getById(Long id) {
			return stRepo.getOne(id);
		}
}
