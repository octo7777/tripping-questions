package com.tripping.question.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tripping.question.core.services.Marker;

@Configuration
@ComponentScan(basePackageClasses = Marker.class)
public class CoreConfig {

}
