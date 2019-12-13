package com.revature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.revature.beans.Bear;
import com.revature.beans.Cave;

//@Configuration
@ComponentScan
public class SpringConfig {

	/*
	// <bean name="bear" class="com.revature.beans.Bear" ></bean>
	@Bean
	public Bear bear() {
		return new Bear();
	}
	
	@Bean 
	public Cave cave() {
		return new Cave();
	}
	*/
	
}
