package com.hamdibouallegue.datarestdemo.config;


import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.hamdibouallegue.datarestdemo.models.IansCity;
import com.hamdibouallegue.datarestdemo.models.IansCountry;
import com.hamdibouallegue.datarestdemo.models.IansCustomer;
import com.hamdibouallegue.datarestdemo.models.IansService;
import com.hamdibouallegue.datarestdemo.models.IansState;
import com.hamdibouallegue.datarestdemo.models.IansSubscription;

@Component
public class RestConfig implements RepositoryRestConfigurer {
       
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		  config.exposeIdsFor(IansCountry.class);

	        config.exposeIdsFor(IansState.class);
	        config.exposeIdsFor(IansCity.class);
	        config.exposeIdsFor(IansCustomer.class);
	        config.exposeIdsFor(IansService.class);
	        config.exposeIdsFor(IansSubscription.class);
	        
	        cors.addMapping("/api/**").allowedOrigins("*");
    }

 
}