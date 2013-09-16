package com.spring.integration.lab1;

public class MessageHandler {

	public String handleMessage(String message) {
		System.out.println("Received Message: " + message);
		return "Message: " + message;
	}
	
}
