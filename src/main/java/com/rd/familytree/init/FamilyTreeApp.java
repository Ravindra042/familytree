package com.rd.familytree.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.rd.familytree.config.ApplicationContextConfig;

@SpringBootApplication
@Import(ApplicationContextConfig.class)
public class FamilyTreeApp {
	public static void main(String[] args) {
		SpringApplication.run(FamilyTreeApp.class, args);
	}
}
