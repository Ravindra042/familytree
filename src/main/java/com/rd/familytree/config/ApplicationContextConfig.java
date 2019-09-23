package com.rd.familytree.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.rd.familytree")
@EntityScan("com.rd.familytree.domain")
@EnableJpaRepositories("com.rd.familytree.dao")
public class ApplicationContextConfig {

}
