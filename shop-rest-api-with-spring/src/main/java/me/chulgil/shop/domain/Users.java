package me.chulgil.shop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@EqualsAndHashCode(of = "id")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 24, nullable = false)
	private String id;

	@NotBlank
	@Column(length = 191, nullable = false)
	private String name;

	@NotBlank
	@Column(length = 191, nullable = false)
	private String email;
	
	@NotBlank
	@Column(length = 60, nullable = false)
	private String password;

	@Column(length = 6, nullable = false)
	private String locale;

	private int coin;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@CreationTimestamp
	private Date regDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	@UpdateTimestamp
	private Date updDate;

}
