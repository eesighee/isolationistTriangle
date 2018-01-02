package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Artwork;
import com.rev.barberharbor.repository.ArtworkRepo;

@Service
@Transactional
public class ArtworkService {
	
	@Autowired
	ArtworkRepo artRepo;
	
	public List<Artwork> getArtworkByBarberId(Long id){
		return artRepo.findByBarber_Id(id);
	}

	public Artwork addArtwork(Artwork a) {
		return artRepo.save(a);
	}
}
