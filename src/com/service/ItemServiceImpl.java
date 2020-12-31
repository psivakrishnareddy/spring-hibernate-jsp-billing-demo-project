package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ItemDAO;
import com.model.ItemDTO;


@Service("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDAO itemdao;
	
	
	@Override
	public List<ItemDTO> getItemsByShop(int shopid) {
		List<ItemDTO> itemslist = itemdao.getItemByShop(shopid);
		
		return itemslist;
	}

	@Override
	public ItemDTO getItem(int itemno) {
		ItemDTO item = itemdao.getItem(itemno);
		return item;
	}

	@Override
	public List<ItemDTO> getAll() {
		// TODO Auto-generated method stub
		return itemdao.getAllItems();
	}
	@Override
	public void deleteItem(int itemno) {
		// TODO Auto-generated method stub
		ItemDTO item = itemdao.getItem(itemno);
		itemdao.deleteItem(item);
		
	}
	
@Override
public void addItem(int itemno, String itemname, Float itemprice, String unit, int shopid, byte[] image,String base64) {
	// TODO Auto-generated method stub
	ItemDTO item = new ItemDTO();
	item.setItemname(itemname);
	item.setItemno(itemno);
	item.setPrice(itemprice);
	item.setShopno(shopid);
	item.setUnit(unit);
	item.setData(image);
	item.setBase64Image(base64);
	itemdao.addItem(item);
	
}
	
}
