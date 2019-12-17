package com.fy.service;

import java.util.List;

import com.fy.dao.ItemDaoImpl;
import com.fy.model.Item;

public class ItemServiceImpl implements ItemService{
	
	ItemDaoImpl idi = new ItemDaoImpl();

	@Override
	public List<Item> findItemAll() {
		return idi.findItemAll();
	}

	public int addItem(Item item) {
		return idi.addItem(item);
	}

	public int delItemById(int id) {
		return idi.delItemById(id);
	}

	public Item getItemById(int id) {
		return idi.getItemById(id);
	}

	public int updateItem(Item item) {
		return idi.updateImte(item);
	}

}
