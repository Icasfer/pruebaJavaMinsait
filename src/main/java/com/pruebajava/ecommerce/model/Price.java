package com.pruebajava.ecommerce.model;

import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "PRICES")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
    private Long id;
	
	@Column(name = "brand_id")
	private Long brandId;

    @Column(name = "start_date")
    private Date startDate;
    
    @Column(name = "end_date")
    private Date endDate;
    
    @Column(name = "price_list")
    private Long priceListId;
    
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "priority")
    private int priority;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "curr")
    private String curr;
    
	public Price() {
		
	}

	public Price(Long id, Long brandId, Date startDate, Date endDate, Long priceListId, Long productId, int priority,
			BigDecimal price, String curr) {
		this.id = id;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceListId = priceListId;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(Long priceList) {
		this.priceListId = priceList;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
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
