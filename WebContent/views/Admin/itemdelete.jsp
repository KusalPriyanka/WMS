<%@page import="com.wms.model.DeleteReq"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>

	<jsp:include page="header.jsp"></jsp:include>

		<%
			IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
			ArrayList<DeleteReq> delReq = goodHandlingService.showReqDeleteGRN();
		%>

        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Items Delete Request</h1>
            </div>          
              
        <div class="row justify-content-center m-4">
        <div class="col">
            
          <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Items Delete Request</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>GRN No</th>
                      <th>Customer Name</th>
                      <th>Reason</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>GRN No</th>
                      <th>Customer Name</th>
                      <th>Reason</th>
                      <th></th>
                      </tr>
                  </tfoot>
                <tbody>
                <% for(DeleteReq DR : delReq){ %>
                    <tr>                    	
                    	<td class="grn"><%= DR.getNo() %></td>
                    	<td><%= DR.getCusName() %></td>
                    	<td><%= DR.getReason() %></td>
                        <td><center>
                        <button type="button" class="btndelete btn btn-danger btn-circle"><i class="fas fa-check"></i></button>
                        <button type="button" class="btnignore btn btn-warning btn-circle"><i class="fas fa-trash"></i></button>
                        </center></td>                       
                    </tr>
                <% } %>                    
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
      $(".btndelete").click(function() {
     	 
          var $row = $(this).closest("tr");    // Find the row
          var $grn = $row.find(".grn").text(); // Find the text in row      
          
          $('#grnno').text($grn);
          $('#grn').val($grn);
          
     	 $('#delete').modal('toggle');
      });
      </script>

	<jsp:include page="footer.jsp"></jsp:include>