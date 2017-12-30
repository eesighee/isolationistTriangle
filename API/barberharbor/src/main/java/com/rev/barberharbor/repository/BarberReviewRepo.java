package com.rev.barberharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.BarberReview;

@Repository
public interface BarberReviewRepo extends JpaRepository<BarberReview, Long>{

	List<BarberReview> findAllByBarber_Id(long id);

}
