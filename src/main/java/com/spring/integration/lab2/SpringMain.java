package com.spring.integration.lab2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amazinbooks.util.OrderGenerator;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {SpringMain.class.getResource("context.xml").toString()});

		OrderGenerator orderGenerator = context.getBean(OrderGenerator.class);
		orderGenerator.startGeneratingOrders();
		
	}

}
