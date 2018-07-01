package com.example.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan(basePackages="com.example.demo")
public class UserDataConfiguration {

	@Bean
	public HandleData handleData() {
		return new HandleData();
	}

	@Bean
	public MainController mainController() {
		return new MainController();
	}
}
