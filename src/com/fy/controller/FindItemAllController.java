package com.fy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fy.model.Item;
import com.fy.service.ItemServiceImpl;

/**
 * 查看商品列表
 */
@WebServlet("/findItemAll")
public class FindItemAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//控制层->业务层->dao持久层
		List<Item> items = new ArrayList<Item>();//清空
		
		ItemServiceImpl isi = new ItemServiceImpl();
		
		items=isi.findItemAll();
		
		request.setAttribute("items",items);
		request.getRequestDispatcher("/itemList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
