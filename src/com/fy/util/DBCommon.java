package com.fy.util;

import java.sql.*;

public class DBCommon {
	
	private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	private static  final String MYSQLNAME="jdbc:mysql://localhost:3306/jdbcdb";
	private static  final String USERNAME="root";
	private static  final String PASSWORD="root";
	private static Connection connection=null;
	private static PreparedStatement preparedStatement=null;
	private static ResultSet resultSet=null;
	
	//获得连接
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			connection=DriverManager.getConnection(MYSQLNAME,USERNAME,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//prepareStatement
	public static PreparedStatement getPreparedStatement(String sql,Connection connection) {
		try {
			preparedStatement=connection.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preparedStatement;
		
	}
	
	//获得结果集
	public static ResultSet getResult(PreparedStatement preparedStatement) {
		try {
			resultSet=preparedStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	//修改,删除,添加
	public static int executeUpdateBySql(PreparedStatement preparedStatement) {
		int count = 0;
		try {
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;	
	}
	
	//关闭
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
