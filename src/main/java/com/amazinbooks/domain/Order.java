package com.amazinbooks.domain;

import java.util.Collection;
import java.util.Date;

public class Order {

	private Collection<OrderItem> itemsBeingPurchased;
	
	private Customer customer;
	
	private Date dateOfPurchase;

	public Order(Collection<OrderItem> itemsBeingPurchased, Customer customer,
			Date dateOfPurchase) {
		this.itemsBeingPurchased = itemsBeingPurchased;
		this.customer = customer;
		this.dateOfPurchase = dateOfPurchase;
	}

	public Collection<OrderItem> getItemsBeingPurchased() {
		return itemsBeingPurchased;
	}

	public void setItemsBeingPurchased(Collection<OrderItem> itemsBeingPurchased) {
		this.itemsBeingPurchased = itemsBeingPurchased;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	
	@Override
	public String toString() {
		return this.getItemsBeingPurchased().size() + " items for " + customer.getFirstname() + " " + customer.getLastname() + " (" + this.getDateOfPurchase() + ")";
	}
	
	
}
