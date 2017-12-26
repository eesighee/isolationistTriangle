package com.ex.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.barberharbor.model.HarborReview;

@Repository
public interface HarborReviewDao extends JpaRepository<HarborReview, Integer>{

}
