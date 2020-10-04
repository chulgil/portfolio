package me.chulgil.shop.product;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author Chulgil.Lee
 */
@Controller
@ExposesResourceFor(Product.class)
@RequestMapping(value = "api/product/", produces = MediaTypes.HAL_JSON_VALUE)
public class ProductController {
	
	private final TypedEntityLinks<Product> links;

	public ProductController(ProductRepository repository, EntityLinks entityLinks) {
		this.links = entityLinks.forType(Product::getId);
	}

	
	/**
	 * Accepts a payment for an {@link Order}
	 *
	 * @param order the {@link Order} to process the payment for. Retrieved from the path variable and converted into an
	 *          {@link Order} instance by Spring Data's {@link DomainClassConverter}. Will be {@literal null} in case no
	 *          {@link Order} with the given id could be found.
	 * @param number the {@link CreditCardNumber} unmarshaled from the request payload.
	 * @return
	 */
	@PostMapping
	ResponseEntity<?> submitProduct(@RequestBody Product product) {

		if (product == null ) {
			return ResponseEntity.notFound().build();
		}
		
		Link link = links.linkToItemResource(product); 
		
		var model = new ProductModel(product);
		model.add(links.linkToItemResource(product).withSelfRel());
		
		
		var paymentUri = link.toUri();
		
		return ResponseEntity.created(paymentUri).body(model);

	}
	
	
//	@GetMapping(value = "/products/{id}")
//	public ResponseEntity<EntityModel<Products>> findOne(@PathVariable String id) {
//		
//		return repository.findById(id) //
//				.map(assembler::toModel) //
//				.map(ResponseEntity::ok) //
//				.orElse(ResponseEntity.notFound().build();
//	}
	
	/**
	 * 엔티티 모델을 구현한 상품 결과
	 *
	 * @author Chulgil.Lee
	 */
	@Data
	@EqualsAndHashCode(callSuper = true)
	static class ProductModel extends RepresentationModel<ProductModel> {
		
		@JsonUnwrapped
		private final Product product;
		
	}
	  
 }
