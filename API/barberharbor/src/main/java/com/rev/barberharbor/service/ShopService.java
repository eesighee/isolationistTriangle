package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.Shop;
import com.rev.barberharbor.model.User;
import com.rev.barberharbor.repository.BarberRepo;
import com.rev.barberharbor.repository.ShopRepository;
import com.rev.barberharbor.repository.UserRepo;

@Service
@Transactional
public class ShopService {
	
	@Autowired
	private ShopRepository shops;
	
	//private UserRepo userDao;
	@Autowired
	private UserRepo barberDao;
	
	public List<Shop> getShops() {
		return shops.findAll();
	}
	
	public List<Barber> findBarbersByShopId(Long id) {
		return barberDao.findBarbersByShop_Id(id);
	}
	
	public List<Barber> findBarbersByShop(Shop shop){
		return barberDao.findBarbersByShop(shop);
	}

	public Shop getById(long id) {
		return shops.findOne(id);
	}

	public boolean validateShopByPhone(String phone) {
		return (shops.findShopByPhone(phone) == null);
	}

	public boolean validateShopByAddress(String address) {
		return (shops.findShopByAddress(address) == null);
	}

	public void register(Shop shop) {
		shops.save(shop);
	}

//	public Barber findBarberByUserId(long parseLong) {
//		return barberDao.findByUserId(parseLong);
//	}

}
