package com.rev.barberharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.StylingService;

@Repository
public interface StylingServiceRepo extends JpaRepository<StylingService, Long>{

	List<StylingService> findAllByBarber_id(long id);

}
