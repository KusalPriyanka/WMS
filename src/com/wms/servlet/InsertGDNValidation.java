package com.wms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wms.model.GRN_Qty;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;


@WebServlet("/InsertGDNValidation")
public class InsertGDNValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertGDNValidation() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Gson gson = new Gson();
		String action = request.getParameter("action");
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		
		if(action.equals("1")) {
			
			String GDNNo = null;
			
			GDNNo = goodHandlingService.generateGDNNo(request.getParameter("cusId"));
					
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(GDNNo));
			out.flush();
			out.close();
			
		}
		
		else if(action.equals("2")) {
			ArrayList<GRN_Qty> grnQty = goodHandlingService.getGRNQTYView(request.getParameter("GRNNo"));
			
			for(GRN_Qty GQ : grnQty) {
				GQ.setItemDes(goodHandlingService.getItemName(GQ.getItemId()));
			}
			
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(grnQty));
			out.flush();
			out.close(); 
		}
		
		else if(action.equals("3")) {
			
			GRN_Qty grn_Qty = goodHandlingService.getGRNQtyByGRNNoAndItemId(request.getParameter("GRNNo"), request.getParameter("item"));
			
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(grn_Qty));
			out.flush();
			out.close(); 
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
