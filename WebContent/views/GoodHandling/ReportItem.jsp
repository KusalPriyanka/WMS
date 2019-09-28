<%@page import="com.wms.util.CommonConstants"%>
<%@page import="com.wms.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Report Preview</title>
	<link rel="stylesheet" href="../../css/sb-admin-2.min.css">
	<link rel="stylesheet" href="../../css/report.css">
	<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>
<body>

        <%  
        	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
        	ArrayList<Item> itemList = goodHandlingService.getItemList();

        %>

	<div class="A4" style="border:1px solid black; padding:20px; height:39.7cm; ">
	
		<center><h3 class="font-weight-bold"><%= CommonConstants.COMPANY_NAME.toString() %></h3></center>
		<center><span><%= CommonConstants.COMPANY_ADDRESS.toString() %></span></center>
              
        <br/><br/>
        <center><h5 class="font-weight-bold"><%= CommonConstants.ITEM_REPORT_CAPTION.toString() %></h5></center>
        <span class="float-right">Date : <span id="Date"> </span> </span> 
        <br/>
		<hr>
		
		<table class="table table-bordered mt-5" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Item Code</th>
                      <th>Item Name</th>
                      <th>Item Description</th>
                      <th>Item Remark</th>
                      <th>Payment Method</th>
                      <th>Price</th>                   
                      <th>UOM</th>
                    </tr>
                  </thead>
                <tbody>
                
                <%
                	for(Item item : itemList){
                %>
                
                    <tr>
                    	<td class="item"><%= item.getItemId() %></td>
                        <td><%= item.getItemName() %></td>
                        <td><%= item.getItemDes() %></td>
                        <td><%= item.getRemark() %></td>
                        <td><%= item.getPaymentMethod() %></td>
                        <td><%= item.getPrice() %></td>
                        <td><%= item.getUom() %></td>
                    </tr>
                    
                 <%
                	}
                 %>   
                    
                </tbody>
            </table>
            
        <div class="d-flex justify-content-between ml-4 mr-4 mt-5">
			<span>..............................................</span>
			<span>..............................................</span>
		</div>

		<div class="d-flex justify-content-between ml-5 mr-5">
			<span>Prepaired By</span>
			<span>Authorized By</span>
		</div>
		
	</div>


      <script>
      
      var fullDate = new Date();
      var twoDigitMonth = ((fullDate.getMonth().length+1) === 1)? (fullDate.getMonth()+1) :(fullDate.getMonth()+1);
      
      var currentDate = fullDate.getDate() + "/" + twoDigitMonth + "/" + fullDate.getFullYear();
      	
      $('#Date').text(currentDate);
      
      window.print();
      
      </script>
      
</body>
</html>