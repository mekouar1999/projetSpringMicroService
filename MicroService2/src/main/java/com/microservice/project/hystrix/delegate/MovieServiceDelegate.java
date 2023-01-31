package com.microservice.project.hystrix.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieServiceDelegate {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callActorsServiceAndGetData_Fallback")
	public String callActorsServiceAndGetData() {
		System.out.println("Getting all Actors details");
		String response = restTemplate
				.exchange("http://localhost:8098/getAllActors"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - All actors Details " + response + " -  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callActorsServiceAndGetData_Fallback() {
		System.out.println("Movie Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Movie Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
