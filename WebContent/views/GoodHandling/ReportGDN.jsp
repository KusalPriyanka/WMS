<%@page import="com.wms.model.GDN_Qty"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.model.GDN"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Time"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<%@page import="com.wms.model.GRN"%>
<%@page import="com.wms.util.CommonConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>GDN Report Preview</title>
	<link rel="stylesheet" href="../../css/sb-admin-2.min.css">
	<link rel="stylesheet" href="../../css/report.css">
	
</head>
<body>

 		<%
 				
 			HttpSession Session = request.getSession();
 		
 			if(session.getAttribute("GDNNo") == null){
 				response.sendRedirect("overviewgdn.jsp");
 			}
 			else{
				String GDNNo = session.getAttribute("GDNNo").toString();
				
				IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
				GDN GDN = goodHandlingService.getGDNById(GDNNo);
				
				//String Stime = GDN.getsTime();
				
				//DateFormat sdf = new SimpleDateFormat("hh:mm");
				//Date date = sdf.parse(GDN.getsTime());
				
				//System.out.println(sdf.format(date));
				
				ArrayList<GDN_Qty> list = goodHandlingService.getGDNQTYView(GDNNo);
					
 		%>
<div class="A4" style="border:1px solid black; padding:20px; height:39.7cm; ">
        
        <center><h3 class="font-weight-bold"><%= CommonConstants.COMPANY_NAME.toString() %></h3></center>
		<center><span><%= CommonConstants.COMPANY_ADDRESS.toString() %></span></center>
        
        <span><%= CommonConstants.WAREHOUSE_NO.toString() %></span>
              
        <br/><br/>
        <center><h5 class="font-weight-bold"><%= CommonConstants.GDN_REPORT_CAPTION.toString() %></h5></center>
        <br/>
        
		<div class="clearfix">
		  <span class="float-left">Customer : <%= goodHandlingService.getCustomerName(GDN.getCusId()) %> </span>
		  <span class="float-right">GRN No : <%= GDN.getGDNNo() %></span>
		</div>

        <div class="clearfix">
		  <span class="float-left">Vehicle No : <%= GDN.getVehicleNo() %></span>
		  <span class="float-right">Date : <%= GDN.getDate() %></span> 
		</div>
		
		<span class="float-left">Container No : <%= GDN.getContainerNo() %></span> <br/>
				
		<div class="clearfix mt-4 mb-0">
		  <span class="float-left">Start Time : <%= GDN.getsTime() %></span>
		  <span class="float-right">End Time : <%= GDN.geteTime() %></span> 
		</div>
		<br/>
		<hr>
		
        <div class = "row mt-5">
        <table class="table table-bordered">
		<thead class="thead-dark">
		  <tr>
		  	<th scope="col">Item Id</th>
			<th scope="col">Item Name</th>
			<th scope="col">QTY</th>
			<th scope="col">Square Feet</th>
			<th scope="col">CBM</th>
			<th scope="col">Remark</th>
		  </tr>
		</thead>
		<tbody>
		  <tr>
		<% 
			int i = 1;
			for(GDN_Qty L : list) { 
		%>  
			<th scope="row"><%= i %></th>
			<td><%= goodHandlingService.getItemName(L.getItemId()) %></td>
			<td><%= L.getQty() %></td>
			<td><%= L.getSeqFeet() %></td>
			<td><%= L.getCBM() %></td>
			<td><%= L.getRemark() %></td>
			</tr>
		<% 
			i++;
			} 
		%>			  
		</tbody>
	  </table>
   </div>

	<br/><br/>
	<span class="sig mt-5">Commodity Condition-Good/Missing,Short/Broken,Torn,Leaking/Wet,Crushed/Empty Etc.....</span>
	<br/><br/>
	<hr>
	
		<div class="d-flex justify-content-between ml-4 mr-4 mt-5">
			<span>..............................................</span>
			<span>..............................................</span>
			<span>..............................................</span>
		</div>

		<div class="d-flex justify-content-between ml-5 mr-5">
			<span>Security Officer</span>
			<span>Prepaired By</span>
			<span>Authorized By</span>
		</div>

</div>
<% } %>

      <script>
        window.print();
      </script>


	
	
</body>
</html>