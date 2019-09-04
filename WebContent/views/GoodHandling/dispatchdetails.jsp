
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
                <form action="${pageContext.request.contextPath}/InsertGDN?step=2" method="POST">
                <input type="hidden" value="<%= goodHandlingService.getCustomerName(GDN.getCusId())  %>" id="cusName"/>
                <input type="hidden" value="<%= GDN.getGDNNo()  %>" id="gdnno" name="gdnno"/>
                    <div class="form-group">
                        <label for="grnno">Select GRN No :</label>
                        <select class="form-control" id="grnno" name="grnno">
                        <option disabled selected> -- Select GRN No -- </option>
                        <% for(GRN G : grnList){ %>
                        
                          <option value="<%= G.getGRNNo() %>"><%= G.getGRNNo() %></option>

						<% } %>

                        </select>
                    </div>
                    <div class="form-group">
                        <label for="item">Select Item :</label>
                        <select class="form-control form-control-sm" id="item" name="itemno">
                        <option disabled selected> -- Select GRN No -- </option>
                        </select>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="qty">Enter QTY :</label>
                            <input type="text" class="form-control form-control-sm" id="qty" placeholder="Quantity" name="qty">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="sqfeet">Enter Square Feet :</label>
                            <input type="text" class="form-control form-control-sm" id="sqfeet" placeholder="Release Square Feet" name="sf">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="cbm">Enter CBM :</label>
                            <input type="text" class="form-control form-control-sm" id="cbm" placeholder="Release CBM" name="cbm">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="remark">Enter Remark :</label>
                            <input type="text" class="form-control form-control-sm" id="remark" placeholder="Enter Remark" name="remark">
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
                  <li class="list-group-item">Quantity : <span class="card-title" id="qtypre"></span></li> 
                  <li class="list-group-item">Square Feet : <span class="card-title" id="sfpre"></span></li>
                  <li class="list-group-item">CBM : <span class="card-title" id="cbmpre"></span></li>
                  <li class="list-group-item">WLoc : <span class="card-title" id="wlocpre"></span></li>
                  <li class="list-group-item">Remark : <span class="card-title" id="remarkpre"></span></li>
                </ul>
              </div>
            </div>  
          </div>
          
        </div>
       <% } %>
      <!-- End of Main Content -->
      
      <script>    
      
      var GRNNo = "";
      
      $("#grnno").on("change", function(event) { 
    	  
    	  GRNNo = $('#grnno').val(); 
    	  var CusName = $('#cusName').val();    	 
    	  
    	    $.ajax({
    	        url      : 'http://localhost:8080/Warehouse_Managment_System/InsertGDNValidation?action=2',
    	        method   : 'GET', 
    	        data     : {GRNNo: GRNNo},
    	        success  : function(response){ 	
    	        	
    	        	var res = JSON.parse(response);
    	        	$("#item option").remove();
    	        	$("#item").append(new Option("--Select Item--", -1));
    	        	
    	        	$(function() {
    	        		$.each(res, function(i, itemL) {
								
    	        			$("#item").append(new Option(itemL.itemDes, itemL.itemId));

    	        		});
    	        		
    	        		$('#cusnamepre').text(CusName);
    	        		$('#grnnumpre').text(GRNNo);
    	        	});
    	        	
    	      } 
    	    });
    	    
        	$('#qtypre').text('');
        	$('#sfpre').text('');
        	$('#cbmpre').text('');
        	$('#wlocpre').text('');
        	$('#remarkpre').text('');
    	    
      });
      
       $("#item").on("change", function(event) { 
    	  
    	  var item = $('#item').val();  

     	    $.ajax({
    	        url      : 'http://localhost:8080/Warehouse_Managment_System/InsertGDNValidation?action=3',
    	        method   : 'GET', 
    	        data     : {GRNNo: GRNNo, item:item},
    	        success  : function(response){ 	
    	        	
    	        	var res = JSON.parse(response);
    	        	
    	        	$('#qtypre').text(res.qty);
    	        	$('#sfpre').text(res.seqFeet);
    	        	$('#cbmpre').text(res.CBM);
    	        	$('#wlocpre').text(res.wLocId);
    	        	$('#remarkpre').text(res.remark);
    	        	
    	      }
    	    });
      }); 
      
      </script>

      <jsp:include page="footer.jsp"></jsp:include>