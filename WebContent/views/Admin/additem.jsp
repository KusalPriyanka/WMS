
<%@page import="com.wms.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>

	<jsp:include page="header.jsp"></jsp:include>

		<%
			IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
			ArrayList<Item> item = goodHandlingService.getReqItemList();
		%>

        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Add Items Request</h1>
            </div>   
            
            <div class="row justify-content-center">
            <a href="confirmitem.jsp">
            <button type="button" class="btn btn-outline-primary btn-lg">
			    <b>Add New Item</b>
			</button>
			</a>
            </div>       
              
        <div class="row justify-content-center m-4">
        <div class="col">
            
          <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Add Items Request</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Item Code</th>
                      <th>Item Name</th>
                      <th>Item Description</th>
                      <th>Remark</th>
                      <th>Payment Method</th>
                      <th>Price</th>
                      <th>UOM</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>Item Code</th>
                      <th>Item Name</th>
                      <th>Item Description</th>
                      <th>Remark</th>
                      <th>Payment Method</th>
                      <th>Price</th>
                      <th>UOM</th>
                      <th></th>
                      </tr>
                  </tfoot>
                <tbody>
                <% for(Item I : item){ %>
                    <tr>
                    	<td class="item"><%= I.getItemId() %></td>                    	
                    	<td><%= I.getItemName() %></td>
                    	<td><%= I.getItemDes() %></td>
                    	<td><%= I.getRemark() %></td>
                    	<td><%= I.getPaymentMethod() %></td>
                    	<td><%= I.getPrice() %></td>
                    	<td><%= I.getUom() %></td>
                        <td><center>
                        <button type="button" class="btnconfirm btn btn-success btn-circle"><i class="fas fa-check"></i></button>
                        <button type="button" class="btndelete btn btn-danger btn-circle"><i class="fas fa-trash"></i></button>
                        </center></td>                       
                    </tr>
                <% 
                System.out.println(I);
                } %>                    
                </tbody>
            </table>
            </div>
            </div>
        </div>
        </div>
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
      
        <!-- Delete Model -->
			<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Delete </h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
	            <div class="row justify-content-center">	           
	                <h5>You Are Going To Delete The &nbsp </h5> <span class="h5" id="grnno"> </span>
	                <h5>This Process Cannot Be Recovered! </h5>
	            </div>
 				<div class="row justify-content-center m-2">
	                <form action="${pageContext.request.contextPath}/deleteGRN?step=del" method="POST">
	                	<input type="hidden" id="grn" name="GRNNo"/>
	                	<button type="submit" class="btn btn-danger">Confirm GRN Delete</button>  
	                </form>
 				</div>               		        
			      </div>
			    </div>
			  </div>
			</div>      
      
      <script>
      
      $(".btnconfirm").click(function() {
      	 
          var $row = $(this).closest("tr");    // Find the row
          var $item = $row.find(".item").text(); // Find the text in row      
          
          
   	    $.ajax({
 	        url      : 'http://localhost:8080/Warehouse_Managment_System/InsertItem?step=rev',
 	        method   : 'POST', 
 	        data     : {item: $item},
 	        success  : function(response){
 	        	window.location.replace("confirmitem.jsp");
 	      }
 	    });
              	  
      });
      
      $(".btndelete").click(function() {
     	 
          var $row = $(this).closest("tr");    // Find the row
          var $item = $row.find(".item").text(); // Find the text in row      
          
/*           $('#grnno').text($grn);
          $('#grn').val($grn);  */
          
     	  $('#delete').modal('toggle');
      });
      </script>

	<jsp:include page="footer.jsp"></jsp:include>