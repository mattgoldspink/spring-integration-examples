package com.amazinbooks.domain;

public class OrderItem {

	private StockItem itemBeingPurchased;
	
	private long quantityRequired;

	public long getQuantityRequired() {
		return quantityRequired;
	}

	public void setQuantityRequired(int quantityRequired) {
		this.quantityRequired = quantityRequired;
	}

	public StockItem getItemBeingPurchased() {
		return itemBeingPurchased;
	}

	public OrderItem(StockItem itemBeingPurchased, long quantityRequired) {
		this.itemBeingPurchased = itemBeingPurchased;
		this.quantityRequired = quantityRequired;
	}
	
}
