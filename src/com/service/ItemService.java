package com.service;

import java.util.List;

import com.model.ItemDTO;

public interface ItemService{
	public List<ItemDTO> getItemsByShop(int shopid);
	public  ItemDTO getItem(int itemno);
	public  List<ItemDTO> getAll();
	public void deleteItem(int itemno);
	public void addItem(int itemno, String itemname, Float itemprice, String unit , int shopid, byte[] image,String base64);
	
}

