package com.amazinbooks.repository;

import java.util.Collection;

import com.amazinbooks.domain.Book;

public interface BookCatalogueRepository {

	public Collection<Book> getBooks();
	
}
