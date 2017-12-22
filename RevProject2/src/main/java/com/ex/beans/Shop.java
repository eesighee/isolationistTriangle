package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="SHOPS")
public class Shop {
	
	@Id
	@Column(name="shop_id")
	@SequenceGenerator(allocationSize=1,name="shopIdSeq",sequenceName="SHOP_ID_SEQ")
	@GeneratedValue(generator="shopIdSeq",strategy=GenerationType.SEQUENCE)
	private Integer shopId;
	
	@Column(name="shop_name", nullable=false)
	private String shopName;
	
	@Column(name="x_coordinate", nullable=false)
	private Double xCoordinate;
	
	@Column(name="y_coordinate", nullable=false)
	private Double yCoordinate;
	
	@Column(name="shop_sales")
	private Double shopSales;
	
	@Column(name="shop_phone_number")
	private String shopPhoneNumber;

	public Shop() {}
	
	public Shop(String shopName, Double xCoordinate, Double yCoordinate) {
		super();
		this.shopName = shopName;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public Shop(String shopName, Double xCoordinate, Double yCoordinate, String shopPhoneNumber) {
		super();
		this.shopName = shopName;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.shopPhoneNumber = shopPhoneNumber;
	}
	
	public Shop(String shopName, Double xCoordinate, Double yCoordinate, Double shopSales,
			String shopPhoneNumber) {
		super();
		this.shopName = shopName;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.shopSales = shopSales;
		this.shopPhoneNumber = shopPhoneNumber;
	}
	
	public Shop(Integer shopId, String shopName, Double xCoordinate, Double yCoordinate, Double shopSales,
			String shopPhoneNumber) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.shopSales = shopSales;
		this.shopPhoneNumber = shopPhoneNumber;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(Double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public Double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(Double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Double getShopSales() {
		return shopSales;
	}

	public void setShopSales(Double shopSales) {
		this.shopSales = shopSales;
	}

	public String getShopPhoneNumber() {
		return shopPhoneNumber;
	}

	public void setShopPhoneNumber(String shopPhoneNumber) {
		this.shopPhoneNumber = shopPhoneNumber;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", xCoordinate=" + xCoordinate + ", yCoordinate="
				+ yCoordinate + ", shopSales=" + shopSales + ", shopPhoneNumber=" + shopPhoneNumber + "]";
	}
	
}
