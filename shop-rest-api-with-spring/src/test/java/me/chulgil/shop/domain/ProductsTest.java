package me.chulgil.shop.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import me.chulgil.shop.product.Product;

@ExtendWith(MockitoExtension.class)
public class ProductsTest {

	
	
	@Test
	public void builder() {

		Product prod = Product.builder()
				.name("Product")
				.description("Desc")
				.build();
		assertThat(prod).isNotNull();

	}

	@Test
	public void javaBean() {
		
		// Given
		String name = "Product";
		String desc = "Desc";
		
		// When
		Product member = new Product();
		member.setName(name);
		member.setDescription(desc);
		
		// Then
		assertThat(member.getName()).isEqualTo(name);
		assertThat(member.getDescription()).isEqualTo(desc);
		
	}

}