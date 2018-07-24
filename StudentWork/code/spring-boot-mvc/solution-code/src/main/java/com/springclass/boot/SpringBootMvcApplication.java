package com.springclass.boot;

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

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}
}
