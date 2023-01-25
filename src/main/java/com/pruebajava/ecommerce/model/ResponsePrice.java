package com.pruebajava.ecommerce.model;

import java.math.BigDecimal;

public class ResponsePrice {

	private Long productId;
	private Long brandId;
	private Long pricelistId;
	private String startDate;
	private String endDate;
	private BigDecimal price;	
	private String curr;
	
	
	public ResponsePrice() {

	}
	
	public ResponsePrice(Long productId, Long brandId, Long pricelistId, String startDate, String endDate,
			BigDecimal price, String curr) {
		this.productId = productId;
		this.brandId = brandId;
		this.pricelistId = pricelistId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.curr = curr;
		
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
	public Long getPricelistId() {
		return pricelistId;
	}
	public void setPricelistId(Long pricelistId) {
		this.pricelistId = pricelistId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
}
