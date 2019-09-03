
<%@page import="com.wms.model.GDN"%>
<%@page import="com.wms.model.GRN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<jsp:include page="header.jsp"></jsp:include>
 
  		<%
 				
 			HttpSession Session = request.getSession();
 			
 			if(session.getAttribute("GDN") == null){
 				response.sendRedirect("dispatch.jsp");
 			}
 			else{
 				GDN GDN = (GDN) session.getAttribute("GDN"); 				
 				
 			IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
 			ArrayList<GRN> grnList = goodHandlingService.getGRNByCusID(GDN.getCusId());

 		%>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <div class="row m-2">
              <h1 class="h3 font-weight-bold text-primary">Create New Good Dispatch Notice</h1>
          </div>
            
          <div class="row m-2 justify-content-center m-4">
              <div class="col-md-8">
                <form action="#" method="POST">
                <input type="hidden" value="<%= goodHandlingService.getCustomerName(GDN.getCusId())  %>" id="cusName"/>
                    <div class="form-group">
                        <label for="grnno">Select GRN No :</label>
                        <select class="form-control" id="grnno">
                        <option disabled selected> -- Select GRN No -- </option>
                        <% for(GRN G : grnList){ %>
                        
                          <option value="<%= G.getGRNNo() %>"><%= G.getGRNNo() %></option>

						<% } %>

                        </select>
                    </div>
                    <div class="form-group">
                        <label for="item">Select Item :</label>
                        <select class="form-control form-control-sm" id="item">
                        <option disabled selected> -- Select GRN No -- </option>
                        </select>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="qty">Enter QTY :</label>
                            <input type="text" class="form-control form-control-sm" id="qty" placeholder="Quantity">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="sqfeet">Enter Square Feet :</label>
                            <input type="text" class="form-control form-control-sm" id="sqfeet" placeholder="Release Square Feet">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="cbm">Enter CBM :</label>
                            <input type="text" class="form-control form-control-sm" id="cbm" placeholder="Release CBM">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="remark">Enter Remark :</label>
                            <input type="text" class="form-control form-control-sm" id="remark" placeholder="Enter Remark">
                          </div>
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-icon-split mt-2">
                        <span class="icon text-white-50">
                            <i class="fas fa-arrow-right"></i>
                        </span>
                        <span class="text">Create GDN Report</span>
                    </button>
                </form>
            </div>
            <div class="col-md-4">
              <div class="card mt-5">
                <div class="card-body">
                  <h5 class="card-title">Customer Name : <span class="card-title" id="cusnamepre"> <%= goodHandlingService.getCustomerName(GDN.getCusId()) %> </span> </h5>
                  <h6 class="card-subtitle mb-2 text-muted">GRN No : <span class="card-subtitle" id="grnnumpre"> </span></h6>
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">Quantity</li>
                  <li class="list-group-item">Unit Of Measurement</li>
                  <li class="list-group-item">Square Feet</li>
                  <li class="list-group-item">CBM</li>
                  <li class="list-group-item">Remark</li>
                </ul>
              </div>
            </div>  
          </div>
          
        </div>
       <% } %>
      <!-- End of Main Content -->
      
      <script>      
      
      $("#grnno").on("change", function(event) { 
    	  
    	  var GRNNo = $('#grnno').val(); 
    	  var CusName = $('#cusName').val();    	 
    	  
    	    $.ajax({
    	        url      : 'http://localhost:8080/Warehouse_Managment_System/InsertGDNValidation?action=2',
    	        method   : 'GET', 
    	        data     : {GRNNo: GRNNo},
    	        success  : function(response){ 	
    	        	
    	        	var res = JSON.parse(response);
    	        	$("#item option").remove();
    	        	
    	        	$(function() {
    	        		$.each(res, function(i, itemL) {
								
    	        			$("#item").append(new Option(itemL.itemDes, itemL.itemId));

    	        		});
    	        		
    	        		$('#cusnamepre').text(CusName);
    	        		$('#grnnumpre').text(GRNNo);
    	        	});
    	        	
    	      }
    	    });
    	    
    	    

      });
      
      </script>

      <jsp:include page="footer.jsp"></jsp:include>