package com.amazinbooks.repository.mock;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazinbooks.domain.Customer;
import com.amazinbooks.repository.CustomerRepository;
import com.github.javafaker.Faker;

public class MockCustomerRepository implements CustomerRepository,
		RandomSelection<Customer> {

	Map<String, Customer> customers = new HashMap<>();

	private final Faker faker = new Faker();
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockCustomerRepository.class);

	public MockCustomerRepository() {
		for (int i = 0; i < 10; i++) {
			String firstName = faker.firstName();
			String lastName = faker.lastName();
			Customer customer = new Customer(firstName, lastName,
					firstName.toLowerCase() + "." + lastName.toLowerCase()
							+ "@ms.com", faker.streetAddress(false) + ", "
							+ faker.cityPrefix() + ", " + faker.stateAbbr()
							+ ", " + faker.country());
			this.customers.put(customer.getEmail(), customer);
			LOGGER.debug("created: " + customer);
		}
	}

	@Override
	public Collection<Customer> getCustomers() {
		return Collections.unmodifiableCollection(this.customers.values());
	}

	@Override
	public Customer getCustomer(String email) {
		return this.customers.get(email);
	}

	public static void main(String[] args) {
		new MockCustomerRepository();
	}

	@Override
	public Customer getRandomInstance() {
		Object[] array = this.customers.keySet().toArray();
		int index = (int) Math.round(Math.random() * (array.length - 1));
		return this.customers.get(array[index]);
	}

}
