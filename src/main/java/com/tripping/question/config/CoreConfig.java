package com.tripping.question.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.tripping.question.core.services", "com.tripping.question.core.repositories"})
public class CoreConfig {

}
