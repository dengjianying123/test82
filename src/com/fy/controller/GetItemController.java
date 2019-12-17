package com.fy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fy.model.Item;
import com.fy.service.ItemServiceImpl;

/**
 * 通过id查询到商品
 */
@WebServlet("/getItemById")
public class GetItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("id")==""?"0":request.getParameter("id"));
		
		ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
		Item item = itemServiceImpl.getItemById(id);
		request.setAttribute("im", item);
		request.getRequestDispatcher("/editItem.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
