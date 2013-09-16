package com.spring.integration.lab1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;

public class SpringMain {

	public static void main(String[] args) {
		ApplicationContext context =
			    new ClassPathXmlApplicationContext(new String[] {SpringMain.class.getResource("context.xml").toString()});

		MessageChannel input = context.getBean("input", MessageChannel.class);
		PollableChannel output = context.getBean("output", PollableChannel.class);
		
		// send our message to the input channel
		input.send(MessageBuilder.withPayload("Hello World").build());
		
		// get our message from the output channel
		Message<?> outputMessage = output.receive();
		
		System.out.println("Received: " + outputMessage);
	}

}
