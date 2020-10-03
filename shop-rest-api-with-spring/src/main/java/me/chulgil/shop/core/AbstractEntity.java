package me.chulgil.shop.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * 엔티티 영속을 위한 베이스 클래스 
 * {@link Long} seq 
 * @author Chulgil Lee
 */
@MappedSuperclass
@Getter
@ToString
@EqualsAndHashCode(of = "seq")
public class AbstractEntity {

	private @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore Long seq;
	private @Version Long version;

	protected AbstractEntity() {
		this.seq = null;
	}
}