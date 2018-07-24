package com.springclass.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner Bootstrap as @Component
 * ApplicationRunner allows access to application arguments with 
 * an {@link ApplicationArguments} Object instead of the raw String array
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationBootstrapper implements ApplicationRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationBootstrapper.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOG.info("*** ApplicationBootstrapper ***");
		
		LOG.info("Your application started with option names: {}", args.getOptionNames());
		LOG.info("Your application started with Non Option args: {}", args.getNonOptionArgs());
		LOG.info("Your application started with Source args: {}", args.getSourceArgs());
	}
}