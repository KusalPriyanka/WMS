package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wms.model.GRN;
import com.wms.model.GRN_Qty;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;

//Servlet For Insert GRN

@WebServlet("/InsertGRN")
public class InsertGRN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertGRN() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		IGoodHandlingService iGoodHandlingService = new GoodHandlingServiceImpl();;
		String step = request.getParameter("step");
		GRN GRN = new GRN();
		GRN_Qty grn_Qty = new GRN_Qty();
		
		response.setContentType("text/html");
		
		if(step.equals("1")) {
						
			GRN.setGRNNo(request.getParameter("GRNNo"));
			GRN.setDate(request.getParameter("Date"));
			GRN.setVehicleNo(request.getParameter("VehicleNum"));
			GRN.setContainerNo(request.getParameter("ContainerNo"));
			GRN.setTrailerNo(request.getParameter("TrailerNo"));
			GRN.setCusId(request.getParameter("cusId"));
			GRN.setsTime(request.getParameter("STime"));
			GRN.seteTime(request.getParameter("ETime"));
			GRN.setNoOfItems(Integer.parseInt(request.getParameter("NoOfProducts")));
						
			iGoodHandlingService.addGRN(GRN);
			
			httpSession.setAttribute("GRN", GRN);
			httpSession.setAttribute("GRNNo", request.getParameter("GRNNo"));
			response.sendRedirect("views/GoodHandling/goodreceive_s2.jsp");

		}
		
		else if(step.equals("2")) {			
			
			grn_Qty.setGRNNo(request.getParameter("GRNNo"));
			grn_Qty.setItemId(Integer.parseInt(request.getParameter("itemId")));
			grn_Qty.setQty(Float.parseFloat(request.getParameter("qty")));
			grn_Qty.setSeqFeet(Integer.parseInt(request.getParameter("sf")));
			grn_Qty.setCBM(Integer.parseInt(request.getParameter("cbm")));
			grn_Qty.setwLocId(request.getParameter("wLoc"));
			grn_Qty.setDamageQty(Integer.parseInt(request.getParameter("dQty")));
			grn_Qty.setStatus(request.getParameter("status"));
			grn_Qty.setRemark(request.getParameter("remark")); 						
			
			iGoodHandlingService.addGRNQty(grn_Qty);
			
			response.sendRedirect("views/GoodHandling/overviewgrn.jsp");
			
		}
		
	}

}
