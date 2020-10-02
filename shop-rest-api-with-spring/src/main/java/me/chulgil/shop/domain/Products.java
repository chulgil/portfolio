package me.chulgil.shop.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "seq")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 24, nullable = false)
	private String seq;
	
	@NotBlank
	@Column(length = 24, nullable = false)
	private String id;
	
	@NotBlank
	@Column(length = 24, name = "category_id", nullable = false)
	private String categoryId;

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