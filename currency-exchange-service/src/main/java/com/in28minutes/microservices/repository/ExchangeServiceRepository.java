package com.in28minutes.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.in28minutes.microservices.beans.ExchangeValue;

@Component
public interface ExchangeServiceRepository extends JpaRepository<ExchangeValue, Integer> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
