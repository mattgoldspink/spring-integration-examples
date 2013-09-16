package com.amazinbooks.repository.mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazinbooks.domain.Book;
import com.amazinbooks.domain.StockItem;
import com.amazinbooks.repository.BookCatalogueRepository;
import com.github.javafaker.Faker;

public class MockBookCatalogueRepository implements BookCatalogueRepository, RandomSelection<Book> {

	private final Collection<Book> allBooks = new ArrayList<>();
	
	private final Faker faker = new Faker(); 
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockBookCatalogueRepository.class);
	
	public MockBookCatalogueRepository() {
		for (int i = 0; i < 10; i++) {
			Book newBook = new Book(faker.zipCode(), faker.sentence(3).replace(".", ""), faker.name());
			allBooks.add(newBook);
			LOGGER.debug("created: " + newBook);
		}
	}
	
	@Override
	public Collection<Book> getBooks() {
		return Collections.unmodifiableCollection(allBooks);
	}

	public static void main(String[] args) {
		new MockBookCatalogueRepository();
	}

	@Override
	public Book getRandomInstance() {
		Object[] array = this.allBooks.toArray();
		int index = (int) Math.round(Math.random() * (array.length - 1));
		return (Book) array[index];
	}
	
}
