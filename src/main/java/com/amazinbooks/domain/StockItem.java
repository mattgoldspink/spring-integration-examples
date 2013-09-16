package com.amazinbooks.domain;


public class StockItem {
	
	private Book book;
	
	private long quantityInStock;
	
	private long priceInPence;

	public long getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(long quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public long getPriceInPence() {
		return priceInPence;
	}

	public void setPriceInPence(int priceInPence) {
		this.priceInPence = priceInPence;
	}

	public Book getBook() {
		return book;
	}

	public StockItem(Book book, long quantityInStock, long priceInPence) {
		this.book = book;
		this.quantityInStock = quantityInStock;
		this.priceInPence = priceInPence;
	}
	
	@Override
	public String toString() {
		return this.book.toString() + "; In stock: " + this.quantityInStock + "; Price: £" + String.format("%.2f", this.priceInPence/10.00);
	}
	
}
