package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wms.model.GDN;
import com.wms.model.GDN_Qty;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;

@WebServlet("/InsertGDN")
public class InsertGDN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InsertGDN() {
        super();
        
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		String step = request.getParameter("step");
		GDN gdn = new GDN();
		GDN_Qty gdnQty = new GDN_Qty();
		IGoodHandlingService iGoodHandlingService = new GoodHandlingServiceImpl();
		
		if(step.equals("1")) {
			
			gdn.setGDNNo(request.getParameter("GDNNo"));
			gdn.setVehicleNo(request.getParameter("vNo"));
			gdn.setContainerNo(request.getParameter("cNo"));
			gdn.setsTime(request.getParameter("sTime"));
			gdn.seteTime(request.getParameter("eTime"));
			gdn.setCusId(request.getParameter("cusId"));
			gdn.setDate(request.getParameter("date"));
			gdn.setNoOfItems(Integer.parseInt(request.getParameter("NoOfProducts")));
			
			iGoodHandlingService.addGDN(gdn);
		
			httpSession.setAttribute("GDN", gdn);
			httpSession.setAttribute("GDNNo", request.getParameter("GDNNo"));
			response.sendRedirect("views/GoodHandling/dispatchdetails.jsp");
		}
		
		else if(step.equals("2")) {
			
			gdnQty.setGRNNo(request.getParameter("grnno"));
			gdnQty.setGDNNo(request.getParameter("gdnno"));
			gdnQty.setItemId(request.getParameter("itemno"));
			gdnQty.setQty(Float.parseFloat(request.getParameter("qty")));
			gdnQty.setSeqFeet(Integer.parseInt(request.getParameter("sf")));
			gdnQty.setCBM(Integer.parseInt(request.getParameter("cbm")));
			gdnQty.setRemark(request.getParameter("remark"));
			
			iGoodHandlingService.addGDNQty(gdnQty);
			
			response.sendRedirect("views/GoodHandling/overviewgdn.jsp");
		}
		
	}

}
