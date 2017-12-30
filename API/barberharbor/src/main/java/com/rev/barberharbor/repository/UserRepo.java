package com.rev.barberharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.Shop;
import com.rev.barberharbor.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	public User findByUsernameIgnoreCase(String username);
	
	public User findByUsernameIgnoreCaseAndPassword(String username, String password);

	public List<Barber> findBarbersByShop(Shop shop);
	public List<Barber> findBarbersByShop_Id(Long id);
	
}
