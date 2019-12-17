package com.fy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fy.model.Item;
import com.fy.util.DBCommon;

public class ItemDaoImpl implements ItemDao{
	@Override
	public List<Item> findItemAll() {
		List<Item> items = new ArrayList<Item>();
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;	
		try{
			connection = DBCommon.getConnection();
			String sql = "select * from item";
			preparedStatement=DBCommon.getPreparedStatement(sql, connection);
			resultSet = DBCommon.getResult(preparedStatement);
			while(resultSet.next()){
				Item item = new Item();
				item.setId(resultSet.getInt("id"));
				item.setName(resultSet.getString("name"));
				item.setDestr(resultSet.getString("destr"));
				item.setNum(resultSet.getInt("num"));
				items.add(item);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCommon.closeResultSet(resultSet);
			DBCommon.closePreparedStatement(preparedStatement);
			DBCommon.closeConnection(connection);
		}
		return items;
	}

	public int addItem(Item item) {
		int addCount = 0;
		
		Connection connection = DBCommon.getConnection();
		PreparedStatement preparedStatement = DBCommon.getPreparedStatement(
				"insert into item(name,destr,num) values(?,?,?)",connection);
		try {
			preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getDestr());
			preparedStatement.setInt(3, item.getNum());
			addCount=DBCommon.executeUpdateBySql(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCommon.closePreparedStatement(preparedStatement);
			DBCommon.closeConnection(connection);
		}
		return addCount;
	}

	public int delItemById(int id) {
		int delCount = 0;
		Connection connection = DBCommon.getConnection();
		PreparedStatement preparedStatement = DBCommon.getPreparedStatement("delete from item where id=?", connection);
		try {
			preparedStatement.setInt(1,id);
			delCount=DBCommon.executeUpdateBySql(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCommon.closePreparedStatement(preparedStatement);
			DBCommon.closeConnection(connection);
		}
		return delCount;
	}

	public Item getItemById(int id) {
		Item item = new Item();
		
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;	
		try{
			connection = DBCommon.getConnection();
			String sql = "select * from item where id=?";
			preparedStatement=DBCommon.getPreparedStatement(sql, connection);
			preparedStatement.setInt(1, id);
			resultSet = DBCommon.getResult(preparedStatement);
			while(resultSet.next()){
				item.setId(resultSet.getInt("id"));
				item.setName(resultSet.getString("name"));
				item.setDestr(resultSet.getString("destr"));
				item.setNum(resultSet.getInt("num"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCommon.closeResultSet(resultSet);
			DBCommon.closePreparedStatement(preparedStatement);
			DBCommon.closeConnection(connection);
		}
		return item;
	}

	public int updateImte(Item item) {
		int updateCount = 0;
		
		Connection connection = DBCommon.getConnection();
		PreparedStatement preparedStatement = DBCommon.getPreparedStatement(
				"update item set name=?,destr=?,num=? where id=?", connection);
		try {
			preparedStatement.setString(1, item.getName());
			preparedStatement.setString(2, item.getDestr());
			preparedStatement.setInt(3, item.getNum());
			preparedStatement.setInt(4,item.getId());
			updateCount=DBCommon.executeUpdateBySql(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCommon.closePreparedStatement(preparedStatement);
			DBCommon.closeConnection(connection);
		}
		return updateCount;
	}

}
