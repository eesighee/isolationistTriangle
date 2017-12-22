package com.ex.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.beans.Shop;

@Repository
public interface ShopDao extends JpaRepository<Shop, Integer> {

}
