package com.wms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wms.model.Item;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;


@WebServlet("/updateItem")
public class updateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public updateItem() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		String step = request.getParameter("step");
		
		if(step.equals("get")) {
			
			Gson gson = new Gson();
			Item item = goodHandlingService.getItemById(request.getParameter("item"));
			
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(item));
			out.flush();
			out.close();
			
		}
		
		else if(step.equals("update")) {
			
			Item item = new Item();
			item.setItemName(request.getParameter("itemName"));
			item.setItemDes(request.getParameter("des"));
			item.setRemark(request.getParameter("remark"));
			item.setItemId(request.getParameter("itemId"));
			
			goodHandlingService.updateItem(item);
						
			response.sendRedirect("views/GoodHandling/overviewitem.jsp");
		}
		
	}

}
