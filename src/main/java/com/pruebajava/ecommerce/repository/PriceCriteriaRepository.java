package com.pruebajava.ecommerce.repository;

import java.util.List;

import com.pruebajava.ecommerce.model.Price;
import com.pruebajava.ecommerce.model.RequestPrice;

public interface PriceCriteriaRepository {

	List<Price> findProduct(RequestPrice request);

}
