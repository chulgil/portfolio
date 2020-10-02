package me.chulgil.shop.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.net.URI;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.chulgil.shop.domain.Products;
import me.chulgil.shop.repository.ProductsRepository;

@RestController("/api")
@RequestMapping(value = "/api/products", produces = MediaTypes.HAL_JSON_VALUE)
public class ProductsController {
	
	private final ProductsRepository repository;
	
	public ProductsController(ProductsRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<?> newProducts(@RequestBody Products products) {
		
		var savedProducts = this.repository.save(products);
		
		URI createdUri = linkTo(ProductsController.class).slash(savedProducts.getId()).toUri();
		
		return ResponseEntity.created(createdUri).body(savedProducts);
		
	}
	  
 }
