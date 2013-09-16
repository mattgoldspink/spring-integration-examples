package com.amazinbooks.repository;

import java.util.Collection;

import com.amazinbooks.domain.Customer;

public interface CustomerRepository {

	public Collection<Customer> getCustomers();
	
	public Customer getCustomer(String email);
	
}
