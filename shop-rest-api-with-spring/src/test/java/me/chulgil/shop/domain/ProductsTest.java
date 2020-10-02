package me.chulgil.shop.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class ProductsTest {

	@Test
	public void builder() {

		 Products prod = Products.builder()
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
		Products member = new Products();
		member.setName(name);
		member.setDescription(desc);
		
		// Then
		assertThat(member.getName()).isEqualTo(name);
		assertThat(member.getDescription()).isEqualTo(desc);
		
	}

}