 		
<%@page import="com.wms.model.Customer"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<jsp:include page="header.jsp"></jsp:include>
 		
 		<%

			IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
        	ArrayList<Customer> cusList =  goodHandlingService.customerList();		  
		  
		%>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <div class="row m-2">
              <h1 class="h3 font-weight-bold text-primary">Create New Good Dispatch Notice</h1>
          </div>
            
          <div class="row m-2 justify-content-center m-4">
              <div class="col-md-10">
                <form action="${pageContext.request.contextPath}/InsertGDN?step=1" method="POST">
                    <div class="form-group">
                        <label for="customerId">Select Customer :</label>
                        <select class="form-control" id="customerId" name="cusId" required>
                        <option disabled selected> -- Select Customer -- </option>
                        <%
                        	for(Customer list : cusList){
                        %>
                        
                          <option value="<%= list.getCustomerId() %>"><%= list.getCusName() %></option>
						  
                        <%
                        	}
                        %>

                        </select>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="GDNNumber">GDN No :</label>
                            <input type="text" class="form-control form-control-sm" id="GDNNumber" placeholder="GDN No" readonly name="GDNNo">
                          </div>
                          <div class="col">
                              <label for="Date">Select Date :</label>
                              <input type="date" class="form-control form-control-sm" id="Date" name="date">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="vehicleNo">Enter Vehicle Number :</label>
                            <input type="text" class="form-control form-control-sm" id="vehicleNo" placeholder="Vehicle Number" name="vNo">
                          </div>
                          <div class="col">
                              <label for="containerNo">Enter Container Number :</label>
                              <input type="text" class="form-control form-control-sm" id="containerNo" placeholder="Container Number" name="cNo">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col">
                              <label for="STime">Enter Start Time :</label>
                              <input type="time" class="form-control form-control-sm" id="STime" placeholder="Start Time" name="sTime">
                            </div>
                            <div class="col">
                                <label for="ETime">Enter End Time :</label>
                                <input type="time" class="form-control form-control-sm" id="ETime" placeholder="End Time" name="eTime">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                              <label for="NoOfProducts">Enter No Of Products :</label>
                              <input type="number" class="form-control form-control-sm" id="NoOfProducts" placeholder="No Of Products" name="NoOfProducts">
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-icon-split mt-2">
                        <span class="icon text-white-50">
                            <i class="fas fa-arrow-right"></i>
                        </span>
                        <span class="text">Add Product Details</span>
                    </button>
                </form>
            </div>  
          </div>
          
        </div>

      <!-- End of Main Content -->
      
      <script>
      	
      document.getElementById('Date').valueAsDate = new Date();
      
      $("#customerId").on("change", function(event) { 
    	  
    	  var cusId = $('#customerId').val(); 

    	    $.ajax({
    	        url      : 'http://localhost:8080/Warehouse_Managment_System/InsertGDNValidation?action=1',
    	        method   : 'GET', 
    	        data     : {cusId: cusId},
    	        success  : function(response){ 	
    	        	
    	        	var res = JSON.parse('['+response+']');
    	        	
    	    	    $(function () {
    	  	    	  $('#GDNNumber').val(res);
    	  	    	});
    	      }
    	    }); 
    	    
    	    

      });
      
      </script>
  
      
 <jsp:include page="footer.jsp"></jsp:include>