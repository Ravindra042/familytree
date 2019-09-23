package com.rd.familytree.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.rd.familytree.controller.MemberController;

@Configuration
public class RestResourceConfig extends ResourceConfig {

	public RestResourceConfig() {
		register(CorsFilter.class);
		register(MemberController.class);
	}

}
