package com.microservice.project.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.project.hystrix.delegate.MovieServiceDelegate;

@RestController
public class MovieServiceController {
	
	@Autowired
	private MovieServiceDelegate movieServiceDelegate;

	@RequestMapping(value = "/getAllActors", method = RequestMethod.GET)
	public String getAllAtors() {
		System.out.println("Going to call movie service to get data!");
		return movieServiceDelegate.callActorsServiceAndGetData();
	}
	
}
