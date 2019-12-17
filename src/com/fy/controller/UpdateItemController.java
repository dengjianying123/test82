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
 * 真正修改商品数据
 */
@WebServlet("/updateItem")
public class UpdateItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.valueOf(request.getParameter("id")==""?"0":request.getParameter("id"));
		String name=request.getParameter("name");
		String destr=request.getParameter("destr");
		int num=Integer.valueOf(request.getParameter("num")==""?"0":request.getParameter("num"));
		ItemServiceImpl itemServiceImpl =new  ItemServiceImpl();
		int updateCount=0;
		if(id>0){
			updateCount=itemServiceImpl.updateItem(new Item(id, name, destr, num));
		}
		
		System.out.println(updateCount>0?"修改成功":"修改"+id+"失败");
		response.sendRedirect(request.getContextPath()+"/findItemAll");
	}

}
