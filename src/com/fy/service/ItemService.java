package com.fy.service;

import java.util.List;

import com.fy.model.Item;

public interface ItemService {
	
	public List<Item> findItemAll();
	
	public int addItem(Item item);
	
	public int delItemById(int id);
	
	public Item getItemById(int id);
	
	public int updateItem(Item item);

}
