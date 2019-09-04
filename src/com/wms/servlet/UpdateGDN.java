package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.GDN;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;

@WebServlet("/UpdateGDN")
public class UpdateGDN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateGDN() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GDN gdn = new GDN();
		gdn.setContainerNo(request.getParameter("containerNo"));
		gdn.setVehicleNo(request.getParameter("vehicleNo"));
		gdn.setGDNNo(request.getParameter("GDN"));
		
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		goodHandlingService.updateGDN(gdn);
		
		response.sendRedirect("views/GoodHandling/overviewgdn.jsp");
		
	}

}
