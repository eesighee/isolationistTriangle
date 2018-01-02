package com.rev.barberharbor.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{
	
	Shop findShopByPhone(String phone);

	Shop findShopByAddress(String address);
		
//	@Query(value="select s.id from shop s order by SQRT(POW(s.lat - :userlat, 2) + POW(s.long - :userlng, 2)) desc")
//    public Stream<Long> findByDistance(@Param("userlat") double userLatitidu, @Param("userlng") double userLongitude);
//
//	public List<Shop> findByIdIn(Stream<Long> ids);
}
