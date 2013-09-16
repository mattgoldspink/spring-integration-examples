package com.amazinbooks.repository;

import java.util.Collection;

import com.amazinbooks.domain.Book;
import com.amazinbooks.domain.StockItem;

public interface InventoryRepository {

	public Collection<StockItem> getAllStock();
	
	public StockItem getStockItemFor(Book book);
	
}
