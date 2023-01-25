package com.pruebajava.ecommerce.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.pruebajava.ecommerce.impl.PriceServiceImpl;
import com.pruebajava.ecommerce.model.Price;
import com.pruebajava.ecommerce.model.RequestPrice;
import com.pruebajava.ecommerce.model.ResponsePrice;
import com.pruebajava.ecommerce.repository.PriceCriteriaRepositoryImpl;

public class PriceServiceTest {
	
	@InjectMocks
	private PriceServiceImpl priceService;
	
	@Mock
	private PriceCriteriaRepositoryImpl priceCriteriaRepository;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void test001() throws Exception {
		Date dateApplication = new GregorianCalendar(2020, Calendar.JUNE, 14, 10, 0, 0).getTime();
		Long productId = 35455L;
		Long brandId = 1L;	
		
		Long id = 1L;
		Date startDate = new GregorianCalendar(2020, Calendar.JUNE, 14, 00, 0, 0).getTime();
		Date endDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59, 59).getTime();
		String startDateStr = "2020-06-14 00:00:00";
		String endDateStr = "2020-12-31 23:59:59";
		Long priceListId = 1L;		
		BigDecimal price = new BigDecimal("35.50");
		String curr = "EUR";
		int priority = 0;
		
		RequestPrice requestPrice = new RequestPrice(dateApplication, productId, brandId);
		ResponsePrice expectedResponsePrice = new ResponsePrice(productId, brandId, priceListId, startDateStr, endDateStr, price, curr);
		
		List<Price> responseRepository = new ArrayList<>();
		Price priceResponse = new Price(id, brandId, startDate, endDate, priceListId, productId, priority, price, curr);
		responseRepository.add(priceResponse);
		
		try {
			Mockito.when(priceCriteriaRepository.findProduct(Mockito.any())).thenReturn(responseRepository);
			
			ResponsePrice response = priceService.getFinalPrice(requestPrice);				
			
			Assertions.assertEquals(expectedResponsePrice.getBrandId(), response.getBrandId());
			Assertions.assertEquals(expectedResponsePrice.getPricelistId(), response.getPricelistId());
			Assertions.assertEquals(expectedResponsePrice.getProductId(), response.getProductId());
			Assertions.assertEquals(expectedResponsePrice.getCurr(), response.getCurr());
			Assertions.assertEquals(expectedResponsePrice.getEndDate(), response.getEndDate());
			Assertions.assertEquals(expectedResponsePrice.getStartDate(), response.getStartDate());
			Assertions.assertEquals(expectedResponsePrice.getPrice(), response.getPrice());
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
		
	@Test
	public void test002() throws Exception {
		Date dateApplication = new GregorianCalendar(2020, Calendar.JUNE, 14, 16, 0, 0).getTime();
		Long productId = 35455L;
		Long brandId = 1L;	
		
		Long id = 1L;
		Date startDate = new GregorianCalendar(2020, Calendar.JUNE, 14, 00, 0, 0).getTime();
		Date endDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59, 59).getTime();		
		Long priceListId = 1L;		
		BigDecimal price = new BigDecimal("35.50");
		String curr = "EUR";
		int priority = 0;
		
		Long id2 = 2L;
		Date startDate2 = new GregorianCalendar(2020, Calendar.JUNE, 14, 15, 0, 0).getTime();
		Date endDate2 = new GregorianCalendar(2020, Calendar.JUNE, 14, 18, 30, 0).getTime();
		String startDateStr2 = "2020-06-14 15:00:00";
		String endDateStr2 = "2020-06-14 18:30:00";
		Long priceListId2 = 2L;		
		BigDecimal price2 = new BigDecimal("25.45");
		int priority2 = 1;
		
		RequestPrice requestPrice = new RequestPrice(dateApplication, productId, brandId);
		ResponsePrice expectedResponsePrice = new ResponsePrice(productId, brandId, priceListId2, startDateStr2, endDateStr2, price2, curr);
		
		List<Price> responseRepository = new ArrayList<>();
		Price priceResponse = new Price(id, brandId, startDate, endDate, priceListId, productId, priority, price, curr);
		responseRepository.add(priceResponse);
		
		Price priceResponse2 = new Price(id2, brandId, startDate2, endDate2, priceListId2, productId, priority2, price2, curr);
		responseRepository.add(priceResponse2);
				
		try {
			Mockito.when(priceCriteriaRepository.findProduct(Mockito.any())).thenReturn(responseRepository);
			
			ResponsePrice response = priceService.getFinalPrice(requestPrice);				
			
			Assertions.assertEquals(expectedResponsePrice.getBrandId(), response.getBrandId());
			Assertions.assertEquals(expectedResponsePrice.getPricelistId(), response.getPricelistId());
			Assertions.assertEquals(expectedResponsePrice.getProductId(), response.getProductId());
			Assertions.assertEquals(expectedResponsePrice.getCurr(), response.getCurr());
			Assertions.assertEquals(expectedResponsePrice.getEndDate(), response.getEndDate());
			Assertions.assertEquals(expectedResponsePrice.getStartDate(), response.getStartDate());
			Assertions.assertEquals(expectedResponsePrice.getPrice(), response.getPrice());
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void test003() throws Exception {		
		Date dateApplication = new GregorianCalendar(2020, Calendar.JUNE, 14, 21, 0, 0).getTime();
		Long productId = 35455L;
		Long brandId = 1L;
		
		Long id = 1L;
		Date startDate = new GregorianCalendar(2020, Calendar.JUNE, 14, 00, 0, 0).getTime();
		Date endDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59, 59).getTime();
		String startDateStr = "2020-06-14 00:00:00";
		String endDateStr = "2020-12-31 23:59:59";
		Long priceListId = 1L;		
		BigDecimal price = new BigDecimal("35.50");
		String curr = "EUR";
		int priority = 0;
		
		RequestPrice requestPrice = new RequestPrice(dateApplication, productId, brandId);
		ResponsePrice expectedResponsePrice = new ResponsePrice(productId, brandId, priceListId, startDateStr, endDateStr, price, curr);
		
		List<Price> responseRepository = new ArrayList<>();
		Price priceResponse = new Price(id, brandId, startDate, endDate, priceListId, productId, priority, price, curr);
		responseRepository.add(priceResponse);
		
		try {
			Mockito.when(priceCriteriaRepository.findProduct(Mockito.any())).thenReturn(responseRepository);
			
			ResponsePrice response = priceService.getFinalPrice(requestPrice);				
			
			Assertions.assertEquals(expectedResponsePrice.getBrandId(), response.getBrandId());
			Assertions.assertEquals(expectedResponsePrice.getPricelistId(), response.getPricelistId());
			Assertions.assertEquals(expectedResponsePrice.getProductId(), response.getProductId());
			Assertions.assertEquals(expectedResponsePrice.getCurr(), response.getCurr());
			Assertions.assertEquals(expectedResponsePrice.getEndDate(), response.getEndDate());
			Assertions.assertEquals(expectedResponsePrice.getStartDate(), response.getStartDate());
			Assertions.assertEquals(expectedResponsePrice.getPrice(), response.getPrice());
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void test004() throws Exception {
		Date dateApplication = new GregorianCalendar(2020, Calendar.JUNE, 15, 10, 0, 0).getTime();
		Long productId = 35455L;
		Long brandId = 1L;	
		
		Long id = 1L;
		Date startDate = new GregorianCalendar(2020, Calendar.JUNE, 14, 00, 0, 0).getTime();
		Date endDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59, 59).getTime();
		Long priceListId = 1L;		
		BigDecimal price = new BigDecimal("35.50");
		String curr = "EUR";
		int priority = 0;
		
		Long id2 = 3L;
		Date startDate2 = new GregorianCalendar(2020, Calendar.JUNE, 15, 00, 0, 0).getTime();
		Date endDate2 = new GregorianCalendar(2020, Calendar.JUNE, 15, 11, 0, 0).getTime();
		String startDateStr2 = "2020-06-15 00:00:00";
		String endDateStr2 = "2020-06-15 11:00:00";
		Long priceListId2 = 3L;		
		BigDecimal price2 = new BigDecimal("30.50");
		int priority2 = 1;
		
		RequestPrice requestPrice = new RequestPrice(dateApplication, productId, brandId);
		ResponsePrice expectedResponsePrice = new ResponsePrice(productId, brandId, priceListId2, startDateStr2, endDateStr2, price2, curr);
		
		List<Price> responseRepository = new ArrayList<>();
		Price priceResponse = new Price(id, brandId, startDate, endDate, priceListId, productId, priority, price, curr);
		responseRepository.add(priceResponse);
		
		Price priceResponse2 = new Price(id2, brandId, startDate2, endDate2, priceListId2, productId, priority2, price2, curr);
		responseRepository.add(priceResponse2);
		
		try {
			Mockito.when(priceCriteriaRepository.findProduct(Mockito.any())).thenReturn(responseRepository);
			
			ResponsePrice response = priceService.getFinalPrice(requestPrice);				
			
			Assertions.assertEquals(expectedResponsePrice.getBrandId(), response.getBrandId());
			Assertions.assertEquals(expectedResponsePrice.getPricelistId(), response.getPricelistId());
			Assertions.assertEquals(expectedResponsePrice.getProductId(), response.getProductId());
			Assertions.assertEquals(expectedResponsePrice.getCurr(), response.getCurr());
			Assertions.assertEquals(expectedResponsePrice.getEndDate(), response.getEndDate());
			Assertions.assertEquals(expectedResponsePrice.getStartDate(), response.getStartDate());
			Assertions.assertEquals(expectedResponsePrice.getPrice(), response.getPrice());
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	@Test
	public void test005() throws Exception {
		Date dateApplication = new GregorianCalendar(2020, Calendar.JUNE, 16, 21, 0, 0).getTime();
		Long productId = 35455L;
		Long brandId = 1L;	
		
		Long id = 1L;
		Date startDate = new GregorianCalendar(2020, Calendar.JUNE, 14, 00, 0, 0).getTime();
		Date endDate = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59, 59).getTime();
		Long priceListId = 1L;		
		BigDecimal price = new BigDecimal("35.50");
		String curr = "EUR";
		int priority = 0;
		
		Long id2 = 4L;
		Date startDate2 = new GregorianCalendar(2020, Calendar.JUNE, 15, 16, 0, 0).getTime();
		Date endDate2 = new GregorianCalendar(2020, Calendar.DECEMBER, 31, 23, 59, 59).getTime();
		String startDateStr2 = "2020-06-15 16:00:00";
		String endDateStr2 = "2020-12-31 23:59:59";
		Long priceListId2 = 4L;		
		BigDecimal price2 = new BigDecimal("38.95");
		int priority2 = 1;
		
		RequestPrice requestPrice = new RequestPrice(dateApplication, productId, brandId);
		ResponsePrice expectedResponsePrice = new ResponsePrice(productId, brandId, priceListId2, startDateStr2, endDateStr2, price2, curr);
		
		List<Price> responseRepository = new ArrayList<>();
		Price priceResponse = new Price(id, brandId, startDate, endDate, priceListId, productId, priority, price, curr);
		responseRepository.add(priceResponse);
		
		Price priceResponse2 = new Price(id2, brandId, startDate2, endDate2, priceListId2, productId, priority2, price2, curr);
		responseRepository.add(priceResponse2);
		
		try {
			Mockito.when(priceCriteriaRepository.findProduct(Mockito.any())).thenReturn(responseRepository);
			
			ResponsePrice response = priceService.getFinalPrice(requestPrice);				
			
			Assertions.assertEquals(expectedResponsePrice.getBrandId(), response.getBrandId());
			Assertions.assertEquals(expectedResponsePrice.getPricelistId(), response.getPricelistId());
			Assertions.assertEquals(expectedResponsePrice.getProductId(), response.getProductId());
			Assertions.assertEquals(expectedResponsePrice.getCurr(), response.getCurr());
			Assertions.assertEquals(expectedResponsePrice.getEndDate(), response.getEndDate());
			Assertions.assertEquals(expectedResponsePrice.getStartDate(), response.getStartDate());
			Assertions.assertEquals(expectedResponsePrice.getPrice(), response.getPrice());
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
