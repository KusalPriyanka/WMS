package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.DeleteReq;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;

@WebServlet("/deleteGRN")
public class deleteGRN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteGRN() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String step = request.getParameter("step");
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		
		if(step.equals("req")) {
			
			goodHandlingService.requestDeleteGRN(new DeleteReq(0,request.getParameter("cus"), request.getParameter("GRNNo"), request.getParameter("reason")));
			
			response.sendRedirect("views/GoodHandling/overviewgrn.jsp");
		}
		
		else if(step.equals("del")) {
			
			goodHandlingService.deleteGRN(request.getParameter("GRNNo"));
			
			response.sendRedirect("views/Admin/grndelete.jsp");
		}
		
	}

}
