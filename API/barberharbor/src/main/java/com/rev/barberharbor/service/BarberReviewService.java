package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.BarberReview;
import com.rev.barberharbor.repository.BarberReviewRepo;

@Service
@Transactional
public class BarberReviewService {

	@Autowired
	private BarberReviewRepo brRepo;
	
	public List<BarberReview> findAllByBarber_Id(long id) {
		return brRepo.findAllByBarber_Id(id);
	}
}
