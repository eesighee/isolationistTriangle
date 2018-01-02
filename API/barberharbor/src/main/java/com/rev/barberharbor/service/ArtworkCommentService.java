package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.ArtworkComment;
import com.rev.barberharbor.repository.ArtworkCommentRepo;

@Service
@Transactional
public class ArtworkCommentService {
	
	@Autowired
	ArtworkCommentRepo acRepo;
	
	public List<ArtworkComment> findByUserId(Long id){
		return acRepo.findByUser_Id(id);
	}

}
