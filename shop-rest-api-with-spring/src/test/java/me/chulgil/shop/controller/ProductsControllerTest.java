package me.chulgil.shop.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.chulgil.shop.domain.Products;
import me.chulgil.shop.repository.ProductsRepository;


@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductsControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	ProductsRepository productsRepository;
	
	@Test
	public void createProduct() throws Exception {
		
		Products prod = Products.builder()
				.seq("P001")
				.id("PROD001")
				.categoryId("CATE001")
				.name("Spring Product")
				.description("Product description")
				.price(1000)
				.createdAt(LocalDateTime.of(2020, 10, 24, 13, 24, 00))
				.createdBy("chulgil")
				.build();
		
		Mockito.when(productsRepository.save(prod)).thenReturn(prod);
		
		
		mockMvc.perform(post("/api/products/")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaTypes.HAL_JSON)
				.content(objectMapper.writeValueAsString(prod))
			)
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(jsonPath("id").exists())
			.andExpect(header().exists(HttpHeaders.LOCATION))
			.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE));
	}

}
