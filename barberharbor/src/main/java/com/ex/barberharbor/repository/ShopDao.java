package com.ex.barberharbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.barberharbor.model.Shop;

@Repository
public interface ShopDao extends JpaRepository<Shop, Integer> {

}
