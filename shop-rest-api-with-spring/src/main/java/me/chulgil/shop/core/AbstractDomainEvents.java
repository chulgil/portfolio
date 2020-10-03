package me.chulgil.shop.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.util.Assert;

import lombok.Getter;

public class AbstractDomainEvents extends AbstractEntity {

	/**
	 * 캡쳐된 모든 도메인 이벤트
	 */
	@Getter(onMethod = @__(@DomainEvents)) //
	private transient final List<Object> domainEvents = new ArrayList<>();

	/**
	 * 스프링 데이터 저장소에 호출시에 게시할 이벤트를 등록
	 * 
	 * @param event must not be {@literal null}.
	 * @return
	 */
	protected <T> T registerEvent(T event) {

		Assert.notNull(event, "Domain event must not be null!");

		this.domainEvents.add(event);
		return event;
	}

	/**
	 * 게시된 모든 도메인 이벤트를 삭제
	 * 일반적으로 스프링데이터의 인프라에서 호출됨
	 */
	@AfterDomainEventPublication
	public void clearDomainEvents() {
		this.domainEvents.clear();
	}
}