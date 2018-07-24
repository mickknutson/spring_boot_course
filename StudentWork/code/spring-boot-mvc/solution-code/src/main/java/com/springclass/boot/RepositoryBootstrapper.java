package com.springclass.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springclass.boot.domain.User;
import com.springclass.boot.domain.UserRepository;

/**
 * CommandLineRunner Bootstrap as @Component
 *
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class RepositoryBootstrapper implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(RepositoryBootstrapper.class);

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		LOG.info("*** RepositoryBootstrapper ***");
		
		// save a couple of Users
		repository.save(new User("Mick", "Knutson"));
		repository.save(new User("Dan", "Corsberg"));
		repository.save(new User("Kim", "Morello"));
		repository.save(new User("Peter", "Schmitz"));
		repository.save(new User("Chuck", "Norris"));

		// fetch all User
		LOG.info("Users found with findAll():");
		LOG.info("-------------------------------");
		for (User user : repository.findAll()) {
			LOG.info(user.toString());
		}
		LOG.info("Total Users in repository: {}", repository.findAll());
		LOG.info("");

		// fetch an individual user by ID
		User user = repository.findOne(1L);
		LOG.info("User found with findOne(1L):");
		LOG.info("--------------------------------");
		LOG.info(user.toString());
		LOG.info("");

		// fetch Users by last name
		LOG.info("User found with findByLastName('knutson'):");
		LOG.info("--------------------------------------------");
		for (User knutson : repository.findByLastName("knutson")) {
			LOG.info(knutson.toString());
		}
		LOG.info("");
	}
}