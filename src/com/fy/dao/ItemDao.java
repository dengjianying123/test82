package com.fy.dao;

import java.util.List;

import com.fy.model.Item;

/**
 * 商品DAO接口类
 * @author djy
 * @date  2019年12月13日
 */
public interface ItemDao {
	
	/**
	 * 查询商品所有
	 * @return
	 */
	public List<Item> findItemAll();
	
	/**
	 * 添加商品
	 * @param item 传递对象
	 * @return
	 */
	public int addItem(Item item);
	
	/**
	 * 删除商品
	 * @param id
	 * @return
	 */
	public int delItemById(int id);
	
	/**
	 * id查询一个商品
	 * @param id
	 * @return
	 */
	public Item getItemById(int id);
	
	/**
	 * 修改商品
	 * @param item
	 * @return
	 */
	public int updateImte(Item item);

}
