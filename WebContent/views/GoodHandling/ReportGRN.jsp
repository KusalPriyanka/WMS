<%@page import="com.wms.model.GRN_Qty"%>
<%@page import="java.util.ArrayList"%>
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
	<title>GRN Report Preview</title>
	<link rel="stylesheet" href="../../css/sb-admin-2.min.css">
	<link rel="stylesheet" href="../../css/report.css">
	
</head>
<body>

 		<%
 				
 			HttpSession Session = request.getSession();
 		
 			if(session.getAttribute("GRNNo") == null){
 				response.sendRedirect("overviewgrn.jsp");
 			}
 			else{
				String GRNNo = session.getAttribute("GRNNo").toString();
				
				IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
				GRN GRN = goodHandlingService.getGRNById(GRNNo);
				
				String Stime = GRN.getsTime();
				
				DateFormat sdf = new SimpleDateFormat("hh:mm");
				Date date = sdf.parse(GRN.getsTime());
				
				//System.out.println(sdf.format(date));
				
				ArrayList<GRN_Qty> list = goodHandlingService.getGRNQTYView(GRNNo);
					
 		%>
<div class="A4" style="border:1px solid black; padding:20px; height:39.7cm; ">
        
        <center><h3 class="font-weight-bold"><%= CommonConstants.COMPANY_NAME.toString() %></h3></center>
		<center><span><%= CommonConstants.COMPANY_ADDRESS.toString() %></span></center>
        
        <span><%= CommonConstants.WAREHOUSE_NO.toString() %></span>
              
        <br/><br/>
        <center><h5 class="font-weight-bold"><%= CommonConstants.GRN_REPORT_CAPTION.toString() %></h5></center>
        <br/>
        
		<div class="clearfix">
		  <span class="float-left">Customer : <%= goodHandlingService.getCustomerName(GRN.getCusId()) %> </span>
		  <span class="float-right">GRN No : <%= GRN.getGRNNo() %></span>
		</div>

        <div class="clearfix">
		  <span class="float-left">Vehicle No : <%= GRN.getVehicleNo() %></span>
		  <span class="float-right">Date : <%= GRN.getDate() %></span> 
		</div>
		
		<span class="float-left">Container No : <%= GRN.getContainerNo() %></span> <br/>
		
		<span class="float-left">Trailer No : <%= GRN.getTrailerNo() %></span> <br/>
		
		<div class="clearfix mt-4 mb-0">
		  <span class="float-left">Start Time : <%= GRN.getsTime() %></span>
		  <span class="float-right">End Time : <%= GRN.geteTime() %></span> 
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
			for(GRN_Qty L : list) {
		%>  
			<th scope="row"><%= i %></th>
			<th><%= goodHandlingService.getItemName(L.getItemId()) %></th>
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