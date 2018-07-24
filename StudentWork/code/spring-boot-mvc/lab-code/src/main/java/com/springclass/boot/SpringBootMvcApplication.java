package com.springclass.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication imports the following annotations:
 * 		@Configuration
 * 		@ComponentScan
 * 		@EnableAutoConfiguration
 * 			> Additionally AutoConfiguration adds:
 * 				@EnableWebMvc
 *
 */

@SpringBootApplication
public class SpringBootMvcApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootMvcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}
}
