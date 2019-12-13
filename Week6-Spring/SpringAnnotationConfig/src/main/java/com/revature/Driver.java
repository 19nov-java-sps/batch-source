package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		System.out.println(ac.getBean("cave"));
		System.out.println(ac.getBean("bear"));

	}

}
