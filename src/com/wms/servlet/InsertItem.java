package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wms.model.Item;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;


@WebServlet("/InsertItem")
public class InsertItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String step = request.getParameter("step");
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		HttpSession httpSession = request.getSession();
		
		if(step.equals("req")) {
			
			Item item = new Item();
			item.setItemId(request.getParameter("itemCode"));
			item.setItemName(request.getParameter("itemName"));
			item.setItemDes(request.getParameter("itemDes"));
			item.setRemark(request.getParameter("itemRemark"));
						
			goodHandlingService.addItem(item);
			
			response.sendRedirect("views/GoodHandling/overviewitem.jsp");
			
		}
		
		else if(step.equals("rev")) {
			
			String itemId = request.getParameter("item");
			
			Item item = goodHandlingService.getItemById(itemId);
	
			httpSession.setAttribute("Item", item);		
			
		}
		
	}

}
