package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;
import com.revature.beans.Cave;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Cave c = new Cave();
		Cave c1 = (Cave) ac.getBean("cave");
		System.out.println(c1);
//		Cave c2 = (Cave) ac.getBean("cave");
//		System.out.println(c2);
		Bear b = (Bear) ac.getBean("bearWithConstructor");
		System.out.println(b);
		Bear b2 = (Bear) ac.getBean("bearWithSetter");
		System.out.println(b2);
		Bear b3 = (Bear) ac.getBean("bearWithAutowiring");
		System.out.println(b3);
		Bear b4 = (Bear) ac.getBean("bearWithAnnotations");
		System.out.println(b4);
		

	}

}
