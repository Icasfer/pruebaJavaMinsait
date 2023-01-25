package com.pruebajava.ecommerce.service;

import com.pruebajava.ecommerce.model.RequestPrice;
import com.pruebajava.ecommerce.model.ResponsePrice;

public interface PriceService {
	
	public abstract ResponsePrice getFinalPrice(RequestPrice price);
	
}
