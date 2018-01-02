package com.rev.barberharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.Shop;
import com.rev.barberharbor.service.BarberService;
import com.rev.barberharbor.service.ShopService;

@RestController
@RequestMapping(value="/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopServ;
	@Autowired
	private BarberService barbServ;
	
	/*
	 *  url: xxxx/login
	 *  method: POST
	 *  parameters: [username: string, password: string]
	 *  returns:  User if sucessfully logged in, null otherwise
	 */
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST)
	public List<Barber> getEmployees(@RequestBody String[] data) {
		return shopServ.findBarbersByShopId(Long.parseLong(data[0]));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Shop getById(@PathVariable long id) {
		return shopServ.getById(id);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}/employees", method=RequestMethod.GET)
	public List<Barber> getEmployees(@PathVariable long id) {
		return shopServ.findBarbersByShopId(id);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/validphone/{phone}", method=RequestMethod.GET)
	public boolean validatePhone(@PathVariable String phone) {
		return shopServ.validateShopByPhone(phone);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/validaddress/{address}", method=RequestMethod.GET)
	public boolean validateAddresss(@PathVariable String address) {
		return shopServ.validateShopByAddress(address);
	}
	
	@CrossOrigin
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void register(@RequestBody Shop shop) {
		shopServ.register(shop);
	}
	
//	@CrossOrigin
//	@RequestMapping(method=RequestMethod.POST)
//	public Barber findBarbersByUserId(@RequestBody String[] data) {
//		return shopServ.findBarberByUserId(Long.parseLong(data[0]));
//	}
	
	@CrossOrigin
	@GetMapping(value="all")
	public List<Shop> getAllShops() {
		return shopServ.getShops();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public List<Barber> getBarbers() {
		return barbServ.getAllBarbers();
	}
	
//	@CrossOrigin
//	@GetMapping(value="/nearest/{lat}/{lng}")
//	public List<Shop> getNearest(@PathVariable double lat, @PathVariable double lng){
//		return shopServ.findClosestShops(lat, lng);
//	}

}
