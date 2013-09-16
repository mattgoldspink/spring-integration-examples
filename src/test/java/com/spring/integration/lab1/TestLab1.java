package com.spring.integration.lab1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestLab1 {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void inputChannelExists() {
		MessageChannel input = context.getBean("input", MessageChannel.class);
		assertNotNull(input);
	}
	
	@Test
	public void outputChannelExists() {
		PollableChannel output = context.getBean("output", PollableChannel.class);
		assertNotNull(output);
	}
	
	
	@Test
	public void getsExpectedResponseFromOutput() {
		MessageChannel input = context.getBean("input", MessageChannel.class);
		PollableChannel output = context.getBean("output", PollableChannel.class);
		
		// send our message to the input channel
		input.send(MessageBuilder.withPayload("Hello World").build());
		
		// get our message from the output channel
		Message<?> outputMessage = output.receive();
		
		assertThat(outputMessage.getPayload().toString(), is(equalTo("Message: Hello World")));
	}

}
