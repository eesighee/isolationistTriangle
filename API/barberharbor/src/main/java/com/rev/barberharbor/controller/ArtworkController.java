package com.rev.barberharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.Artwork;
import com.rev.barberharbor.model.ArtworkComment;
import com.rev.barberharbor.service.ArtworkCommentService;
import com.rev.barberharbor.service.ArtworkService;

@RestController
public class ArtworkController {
	
	@Autowired
	ArtworkService artService;
	
	@Autowired
	ArtworkCommentService acService;
	
	@CrossOrigin
	@GetMapping(value="/artwork/{id}")
	public List<Artwork> getByBarberId(@PathVariable Long id){
		return artService.getArtworkByBarberId(id);
	}
	
	@CrossOrigin
	@PostMapping(value="/artwork")
	public Artwork addArtwork(@RequestBody Artwork a) {
		return artService.addArtwork(a);
	}
	
	@CrossOrigin
	@GetMapping(value="/artcomment/{id}")
	public List<ArtworkComment> getCommentByUserId(@PathVariable Long id){
		return acService.findByUserId(id);
	}

}
