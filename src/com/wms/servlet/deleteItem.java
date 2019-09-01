package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;

@WebServlet("/deleteItem")
public class deleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteItem() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String step = request.getParameter("step");
		
		if(step.equals("req")) {
			
			IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
			goodHandlingService.requestDeleteItem(request.getParameter("id"), request.getParameter("reason"));
			
			response.sendRedirect("views/GoodHandling/overviewitem.jsp");
		}
		
	}

}
