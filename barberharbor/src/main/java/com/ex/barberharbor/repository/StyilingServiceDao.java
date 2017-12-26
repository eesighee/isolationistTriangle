package com.ex.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.barberharbor.model.StylingService;

@Repository
public interface StyilingServiceDao extends JpaRepository<StylingService, Integer>{

}
