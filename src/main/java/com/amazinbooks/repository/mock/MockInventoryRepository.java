package com.amazinbooks.repository.mock;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import com.amazinbooks.domain.Book;
import com.amazinbooks.domain.StockItem;
import com.amazinbooks.repository.BookCatalogueRepository;
import com.amazinbooks.repository.InventoryRepository;

public class MockInventoryRepository implements InventoryRepository {

	Map<Book, StockItem> stock = new HashMap<>();
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MockInventoryRepository.class);
	
	@Autowired
	public MockInventoryRepository(BookCatalogueRepository bookCatalogueRepository) {
		for (Book book : bookCatalogueRepository.getBooks()) {
			StockItem stockItem = new StockItem(book, Math.round(Math.random() * 150), Math.round(((Math.random() * 40) * 10) + 99));
			stock.put(book, stockItem);
			LOGGER.debug("Created: " + stockItem.toString());
		}
	}
	
	@Override
	public Collection<StockItem> getAllStock() {
		return Collections.unmodifiableCollection(this.stock.values());
	}

	@Override
	public StockItem getStockItemFor(Book book) {
		return this.stock.get(book);
	}

	public static void main(String[] args) {
		new MockInventoryRepository(new MockBookCatalogueRepository());
	}

}
