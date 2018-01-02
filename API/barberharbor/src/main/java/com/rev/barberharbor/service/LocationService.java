package com.rev.barberharbor.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.Shop;
import com.rev.barberharbor.model.StylingService;
import com.rev.barberharbor.repository.ShopRepository;

@Service
@Transactional
public class LocationService {
	
	@Autowired
	private ShopRepository shops;
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private BarberService barberService;
	
	private double getDistance(double x, double y, Shop shop) {
		System.out.println("x: " + x + ", y: " + y + ", hypo: " + Math.hypot(x - shop.getLatitude(), y - shop.getLongitude()));
		return Math.hypot(x - shop.getLatitude(), y - shop.getLongitude()); 
	}
	
//	public List<Shop> findClosestShops(double x, double y, double r) {
//		List<Shop> shopList = shops.findByDistance(x, y, r);
//		shopList.sort(new SortByDistance(x, y));
//		return shopList;
//	}
	/*
	 * returns the closest shops. Ordered by the closest shop.Shop at index 0 is the closest shop to user.
	 */
	public List<Shop> getClosestShops(double x, double y, double r) {
		List<Shop> shopList = new ArrayList<Shop>();
		
		for(Shop s: shops.findAll()) {
			if (getDistance(x, y, s) < r) {
				shopList.add(s);
			}
		}
		shopList.sort(new SortByDistance(x, y));
		return shopList;
	}
	
	public List<Shop> getAllShops(){
		return shops.findAll();
	}
	
	private class SortByDistance implements Comparator<Shop>{
		
		private double x;
		private double y;
		
		public SortByDistance(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compare(Shop o1, Shop o2) {
			return (int) (getDistance(x, y, o1) - getDistance(x, y, o2));
		}
		
	}

//	public List<Shop> locateShopsByLocationFilteredByServices(double x, double y, double r, int serviceId) {
//		List<Shop> shopList = new ArrayList<Shop>();
//		
//		for(Shop s: shops.findAll()) {
//			if (shopService.shopOffersService(serviceId)) {
//				
//			}
//			if (getDistance(x, y, s) < r) {
//				for (Barber b: barberService.findAllByShop_Id(s.getId())) {
//					
//				}
//				Set<StylingService> stlyeServiceSet = new HashSet<StylingService>();
//				
//				
//				shopList.add(s);
//			}
//		}
//		shopList.sort(new SortByDistance(x, y));
//		return shopList;
//	}
	
}

