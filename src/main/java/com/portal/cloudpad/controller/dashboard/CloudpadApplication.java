package com.portal.cloudpad.controller.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan("com.portal.cloudpad")
@EntityScan("com.portal.cloudpad.dto")
@EnableJpaRepositories("com.portal.cloudpad.dao")
public class CloudpadApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudpadApplication.class, args);
	}
}
