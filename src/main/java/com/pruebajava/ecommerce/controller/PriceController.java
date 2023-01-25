package com.pruebajava.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pruebajava.ecommerce.model.RequestPrice;
import com.pruebajava.ecommerce.model.ResponsePrice;
import com.pruebajava.ecommerce.service.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

	@Autowired
	private PriceService priceService;

	@GetMapping("/{dateApplication}/{productId}/{brandId}")
	public ResponseEntity<ResponsePrice> finalPrice(@PathVariable("dateApplication") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateApp, 
			@PathVariable("productId") Long productId, 
			@PathVariable("brandId") Long brandId){
		RequestPrice requestPrice = new RequestPrice(dateApp,productId,brandId);
		return new ResponseEntity<ResponsePrice>(priceService.getFinalPrice(requestPrice), HttpStatus.OK);
	}
}
