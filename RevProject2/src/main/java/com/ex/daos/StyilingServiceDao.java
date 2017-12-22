package com.ex.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.StylingService;

@Repository
public interface StyilingServiceDao extends JpaRepository<StylingService, Integer>{

}
