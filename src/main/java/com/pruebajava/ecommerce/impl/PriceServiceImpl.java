package com.pruebajava.ecommerce.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebajava.ecommerce.exception.BadRequestException;
import com.pruebajava.ecommerce.exception.ProductNotFoundException;
import com.pruebajava.ecommerce.model.Price;
import com.pruebajava.ecommerce.model.RequestPrice;
import com.pruebajava.ecommerce.model.ResponsePrice;
import com.pruebajava.ecommerce.repository.PriceCriteriaRepository;
import com.pruebajava.ecommerce.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceCriteriaRepository priceCriteriaRepository;

	@Override
	public ResponsePrice getFinalPrice(RequestPrice reqPrice){
		try {
			List<Price> criteriaResponse = priceCriteriaRepository.findProduct(reqPrice);			

			if (criteriaResponse != null && !criteriaResponse.isEmpty()) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Price finalPrice = criteriaResponse.get(0);

				if (criteriaResponse.size() > 0) {
					for (Price p : criteriaResponse.subList(1, criteriaResponse.size())) {
						if (p.getPriority() > finalPrice.getPriority()) {
							finalPrice = p;
						}
					}
				}

				return new ResponsePrice(finalPrice.getProductId(), finalPrice.getBrandId(),
						finalPrice.getPriceListId(), sdf.format(finalPrice.getStartDate()), sdf.format(finalPrice.getEndDate()),
						finalPrice.getPrice(), finalPrice.getCurr());
			} else {
				throw new ProductNotFoundException(reqPrice);
			}

		} catch (BadRequestException ex) {
			throw new BadRequestException();
		}
	}

}
