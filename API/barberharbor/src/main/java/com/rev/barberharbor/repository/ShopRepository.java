package com.rev.barberharbor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rev.barberharbor.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{
	
//	@Query("select * from shops s where SQRT(POW(s.lat - :userlat, 2) + POW(s.long - :userlng, 2)) < :maxdistance")
//    public List<Shop> findByDistance(@Param("userlat") double userLatitidu, @Param("userlng") double userLongitude, @Param("maxdistance") double maxDistance);

}
