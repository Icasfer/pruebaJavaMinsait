package com.pruebajava.ecommerce.model;

import java.util.Date;

public class RequestPrice {
	
	private Date dateApplication;
	private Long productId;
	private Long brandId;
	
	public RequestPrice() {
		
	}
	
	public RequestPrice(Date dateApplication, Long productId, Long brandId) {
		this.dateApplication = dateApplication;
		this.productId = productId;
		this.brandId = brandId;
	}
	
	public Date getDateApplication() {
		return dateApplication;
	}
	public void setDateApplication(Date date) {
		this.dateApplication = date;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
		
}
