package com.ex.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.HarborReview;

@Repository
public interface HarborReviewDao extends JpaRepository<HarborReview, Integer>{

}
