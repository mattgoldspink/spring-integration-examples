package com.amazinbooks.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

import com.amazinbooks.domain.Book;
import com.amazinbooks.domain.Customer;
import com.amazinbooks.domain.Order;
import com.amazinbooks.domain.OrderItem;
import com.amazinbooks.domain.StockItem;
import com.amazinbooks.repository.InventoryRepository;
import com.amazinbooks.repository.mock.MockBookCatalogueRepository;
import com.amazinbooks.repository.mock.MockCustomerRepository;

public class OrderGenerator {

	@Resource(name="directChannel")
	MessageChannel input;
	
	@Autowired
	MockBookCatalogueRepository catalogueRepository;
	
	@Autowired
	MockCustomerRepository customerRepository;
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderGenerator.class); 
	
	public void startGeneratingOrders() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				MessageChannel channel = OrderGenerator.this.input;
				while (true) {
					Order newOrder = OrderGenerator.this.generateNewOrder();
					Message<Order> message = MessageBuilder.withPayload(newOrder).build();
					channel.send(message);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
			
		}).start();
	}
	
	public Order generateNewOrder() {
		Customer customer = this.customerRepository.getRandomInstance();
		List<OrderItem> orderItems = new ArrayList<>();
		long total = Math.round(Math.random() * 5) + 1;
		for (int i = 0; i < total; i++) {
			orderItems.add(this.generateNewOrderItem());
		}
		Order order = new Order(orderItems, customer, new Date());
		LOGGER.debug(order.toString());
		return order;
	}
	
	private OrderItem generateNewOrderItem() {
		Book randomInstance = catalogueRepository.getRandomInstance();
		StockItem stockItem = inventoryRepository.getStockItemFor(randomInstance);
		return new OrderItem(stockItem, Math.round(Math.random() * 10));
	}
}
