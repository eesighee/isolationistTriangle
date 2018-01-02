package com.rev.barberharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.ArtworkComment;

@Repository
public interface ArtworkCommentRepo extends JpaRepository<ArtworkComment, Long>{

	List<ArtworkComment> findByUser_Id(Long id);
}
