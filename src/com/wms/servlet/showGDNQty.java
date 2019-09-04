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
import com.wms.model.GDN;
import com.wms.model.GDN_Qty;
import com.wms.model.GRN;
import com.wms.model.GRN_Qty;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;

@WebServlet("/showGDNQty")
public class showGDNQty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public showGDNQty() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String step = request.getParameter("step");
		Gson gson = new Gson();
		String GDNNo = request.getParameter("gdn");
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		
		if(step.equals("1")) {			
			
			ArrayList<GDN_Qty> gdn_Qty = goodHandlingService.getGDNQTYView(GDNNo);
			
			for(GDN_Qty GQ : gdn_Qty) {
				GQ.setItemdes(goodHandlingService.getItemName(GQ.getItemId()));
			}

			PrintWriter out = response.getWriter();
			out.print(gson.toJson(gdn_Qty));
			out.flush();
			out.close();	
		}
		
		else if(step.equals("2")) {
			
			GDN gdn = goodHandlingService.getGDNById(GDNNo);
			
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(gdn));
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
