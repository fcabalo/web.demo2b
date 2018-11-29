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
				updatedItem.setQuantity(updatedItem.getQuantity() + item.getQuantity());
				updatedItem.setTotal(updatedItem.getQuantity() * updatedItem.getPrice());
				items.set(i, updatedItem);
				isAdded = true;
				break;
			}
		}
		if(!isAdded) {
			items.add(item);
		}
		totalItems += item.getQuantity();
		grandTotal += item.getTotal();		
	}

	public void removeItem(String itemId, int quantity) {
		ItemModel removedItem = null;
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equals(itemId)) {
				removedItem = items.get(i);
				removedItem.setQuantity(removedItem.getQuantity() - quantity);
				removedItem.setTotal(removedItem.getQuantity() * removedItem.getPrice());
				if(removedItem.getQuantity() <= 0) {
					items.remove(i);
				} else {
					items.set(i, removedItem);
				}
				break;
			}
		}
		if(removedItem != null) {
		this.grandTotal = 0;
		this.totalItems = 0;
			for(int i = 0; i < items.size(); i++) {
				this.grandTotal += items.get(i).getTotal();
				this.totalItems += items.get(i).getQuantity();
			}
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

