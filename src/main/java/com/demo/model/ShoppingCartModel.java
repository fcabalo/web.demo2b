package com.demo.model;

import java.util.List;

public class ShoppingCartModel {
	private List<ItemModel> items;
	private int totalItems;
	private int grandTotal;
	
	public ShoppingCartModel() {
		
	}

	public ShoppingCartModel(List<ItemModel> items, int totalItems, int granTotal) {
		this.items = items;
		this.totalItems = totalItems;
		this.grandTotal = granTotal;
	}
	
	public void addItem(ItemModel item) {
		boolean isAdded = false;
		ItemModel updatedItem = null;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equals(item.getId())) {
				updatedItem = items.get(i);
				updatedItem.setQuantity(updatedItem.getQuantity() + 1);
				updatedItem.setTotal(updatedItem.getQuantity() * updatedItem.getPrice());
				items.set(i, updatedItem);
				isAdded = true;
				break;
			}
		}
		if(!isAdded) {
			items.add(item);
		}
		totalItems += 1;
		grandTotal += item.getPrice();		
	}

	public void removeItem(String itemId) {
		ItemModel removedItem = null;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equals(itemId)) {
				removedItem = items.get(i);
				items.remove(i);
				break;
			}
		}
		if(removedItem != null) {
			totalItems -= removedItem.getQuantity();
			grandTotal -= removedItem.getQuantity() * removedItem.getPrice();
		}
	}

	public List<ItemModel> getItems() {
		return items;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public int getGrandTotal() {
		return grandTotal;
	}
}

