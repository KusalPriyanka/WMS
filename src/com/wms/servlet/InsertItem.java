package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.Item;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;


@WebServlet("/InsertItem")
public class InsertItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Item item = new Item();
		item.setItemId(Integer.parseInt(request.getParameter("itemCode")));
		item.setItemName(request.getParameter("itemName"));
		item.setItemDes(request.getParameter("itemDes"));
		item.setRemark(request.getParameter("itemRemark"));
		
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		goodHandlingService.addItem(item);
		
	}

}
