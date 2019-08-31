package com.wms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;

@WebServlet("/InsertGRNValidation")
public class InsertGRNValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertGRNValidation() {
        super();      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("1")) {
			
			String GRNNo = null;
			
			IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
			GRNNo = goodHandlingService.generateGRNNo(request.getParameter("cusId"));
			
			Gson gson = new Gson();
			
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(GRNNo));
			out.flush();
			out.close();
		}
		
	}

}
