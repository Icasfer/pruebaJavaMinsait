package com.pruebajava.ecommerce.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pruebajava.ecommerce.model.ResponsePrice;
import com.pruebajava.ecommerce.service.PriceService;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PriceService service;

	@Test
	public void pricesGetReturnMessageFromService() throws Exception {
		ResponsePrice resPrice = new ResponsePrice(35455L, 1L, 1L, "2020-06-14 00.00.00", "2020-12-31 23.59.59",
				new BigDecimal("35.50"), "EUR");
		Mockito.when(service.getFinalPrice(Mockito.any())).thenReturn(resPrice);
		this.mockMvc.perform(get("/prices/2020-06-14 10:00:00/35455/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString(
						"{\"productId\":35455,\"brandId\":1,\"pricelistId\":1,\"startDate\":\"2020-06-14 00.00.00\","
						+ "\"endDate\":\"2020-12-31 23.59.59\",\"price\":35.50,\"curr\":\"EUR\"}")));
	}
}
