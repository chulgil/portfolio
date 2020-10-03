/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.chulgil.shop.product;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.chulgil.shop.core.AbstractEntity;

/**
 * 상품 엔티티.
 * 
 * @author Chulgil Lee
 */
@Builder
@Data
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product extends AbstractEntity {

	@NotBlank
	@Column(length = 24, nullable = false)
	private String id;
	
	@NotBlank
	@Column(length = 24, name = "category_seq", nullable = false)
	private String categorySeq;

	@NotBlank
	@Column(length = 191, nullable = false)
	private String name;
	
	@NotBlank
	@Column(length = 255, nullable = false)
	private String description;

	private int price;

	@NotBlank
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@NotBlank
	@Column(length = 24, name = "created_by", nullable = false)
	private String createdBy;	

	@Column(length = 24, name = "updated_by", nullable = false)
	private String updatedBy;	

}