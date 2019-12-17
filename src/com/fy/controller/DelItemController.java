package com.fy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fy.service.ItemServiceImpl;

/**
 * 删除商品
 */
@WebServlet("/delItem")
public class DelItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("id")==""?"0":request.getParameter("id"));//不是null判定
		ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
		int delCount = 0;
		if(id>0){
			delCount = itemServiceImpl.delItemById(id);
		}
		//System.out.println(delCount>0?"删除成功":"删除"+id+"失败");
		response.sendRedirect(request.getContextPath()+"/findItemAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
