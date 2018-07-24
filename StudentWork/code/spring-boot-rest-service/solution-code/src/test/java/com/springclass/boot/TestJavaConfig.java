package com.springclass.boot;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.springclass"})
@EntityScan(basePackages = {"com.springclass"})
public class TestJavaConfig {}
