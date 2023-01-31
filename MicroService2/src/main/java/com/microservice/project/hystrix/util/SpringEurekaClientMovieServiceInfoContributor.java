package com.microservice.project.hystrix.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class SpringEurekaClientMovieServiceInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the Movie service, which is discovery server aware, and this service will Call Movie Microservice, fro actors and films details, which is again dicovery server aware!!! "));
	}

}
