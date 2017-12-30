package com.rev.barberharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.Shop;

@Repository
public interface BarberRepo extends JpaRepository<Barber, Long>{
	
	public List<Barber> findBarbersByShop(Shop shop);
	public List<Barber> findBarbersByShop_Id(Long id);


}
