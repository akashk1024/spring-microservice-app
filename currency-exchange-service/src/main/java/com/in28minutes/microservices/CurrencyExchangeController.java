package com.in28minutes.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.beans.ExchangeValue;
import com.in28minutes.microservices.repository.ExchangeServiceRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	ExchangeValue exchangeValue;
	
	@Autowired
	ExchangeServiceRepository repository;
	
	@Autowired
	Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
}
