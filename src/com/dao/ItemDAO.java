package com.dao;

import java.util.List;

import com.model.ItemDTO;

public abstract class ItemDAO {
	public abstract void addItem(ItemDTO item);
	public abstract void updateItem(ItemDTO item);
	public abstract void deleteItem(ItemDTO item);
	public abstract ItemDTO getItem(int itemno);
	public abstract List<ItemDTO> getAllItems();
	public abstract List<ItemDTO> getItemByShop(int shopid);
}
