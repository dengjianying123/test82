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
 * 添加商品控制层
 */
@WebServlet("/addItem")
public class AddItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;");
		String name=request.getParameter("name");
		String destr=request.getParameter("destr");
		int num=Integer.parseInt(request.getParameter("num")==null?"":request.getParameter("num"));
		
		//三层
		ItemServiceImpl itemServiceImpl  = new ItemServiceImpl();
		int addCount=itemServiceImpl.addItem(new Item(name,destr,num));
		
		System.out.println(addCount>0?"添加成功":"添加失败");
		response.sendRedirect(request.getContextPath()+"/findItemAll");
	}

}
