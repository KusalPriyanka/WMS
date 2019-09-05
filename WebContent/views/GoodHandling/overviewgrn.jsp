<!DOCTYPE html>
<%@page import="com.wms.model.GRN_Qty"%>
<%@page import="com.wms.model.GRN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
       
       <jsp:include page="header.jsp"></jsp:include>
       
        <%  
        	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
        	ArrayList<GRN> GRNList = goodHandlingService.getGRNs();

        %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">GRN Overview</h1>
            </div>
            
            <div class="row justify-content-center">
            <a href="goodreceive_s1.jsp">
            <button type="button" class="btn btn-outline-primary btn-lg">
			    <b>Add New GRN</b>
			</button>
			</a>
            </div>            
              
        <div class="row justify-content-center m-4">
        <div class="col">
            
          <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">GRN List</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>GRN No</th>
                      <th>Customer Name</th>
                      <th>Vehicle No</th>
                      <th>Container No</th>
                      <th>Trailer No</th>                   
                      <th>Date</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>GRN No</th>
                      <th>Customer Name</th>
                      <th>Vehicle No</th>
                      <th>Container No</th>
                      <th>Trailer No</th>                   
                      <th>Date</th>
                      <th></th>
                      </tr>
                  </tfoot>
                <tbody>
                
                <%
                	for(GRN GS : GRNList){
                %>
                
                    <tr>
                        <td class="grn"><%= GS.getGRNNo() %></td>
                        <td class="cus"><%= goodHandlingService.getCustomerName(GS.getCusId()) %></td>
                        <td><%= GS.getVehicleNo() %></td>
                        <td><%= GS.getContainerNo() %></td>
                        <td><%= GS.getTrailerNo() %></td>
                        <td><%= GS.getDate() %></td>
                        <td><center>
                        <button type="button" class="btnshow btn btn-warning btn-circle"><i class="fas fa-eye"></i></button>
                        <button type="button" class="btnupdate btn btn-success btn-circle"><i class="fas fa-edit"></i></button>
                        <button type="button" class="btndelete btn btn-danger btn-circle"><i class="fas fa-trash"></i></button>
                        </center></td>
                    </tr>
                    
                 <%
                	}
                 %>   
                    
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

      <!-- Update Modal -->
        <div class="modal fade bd-example-modal-lg" id="update" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="updateGRNNo"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                <div class="row-md-12 justify-content-center m-2">
                  <form action="${pageContext.request.contextPath}/UpdateGRN" method="POST">
                  <input type="hidden" name="GRN" id="grnForServlet"/>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col-md-12">
                                <label for="vehicleNo">Enter Vehicle Number :</label>
                                <input type="text" class="form-control form-control-sm" id="updatevehicleNo" placeholder="Vehicle Number" name="vehicleNo">
                              </div>
                            </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col">
                                  <label for="containerNo">Enter Container Number :</label>
                                  <input type="text" class="form-control form-control-sm" id="updatecontainerNo" placeholder="Container Number" name="containerNo"> 
                              </div>
                          </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col">
                                <label for="trailerNo">Enter Trailer Number :</label>
                                <input type="text" class="form-control form-control-sm" id="updatetrailerNo" placeholder="Enter Trailer Number" name="trailerNo">
                              </div>
                      </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row float-right">
                 		<button type="button" class="btn btn-secondary float-right mr-2" data-dismiss="modal">Close</button>
                		<button type="submit" class="btn btn-success float-right">Save Changes</button>  
                      </div>
                      </div>                         
                
                  </form>
                </div>
                </div>

            </div>
            </div>
        </div>
        
        <!-- Show Modal -->
        <div class="modal fade bd-example-modal-lg" id="show" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="showId"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                <div class="row m-0">
                <div id="grntable"></div>
				<table class="table table-hover" id="grn_qty">
				  <thead>
				    <tr class="bg-primary text-white">
				      <th scope="col">Item Name</th>
				      <th scope="col">QTY</th>
				      <th scope="col">SeqFeet</th>
				      <th scope="col">CBM</th>
				      <th scope="col">WLoc</th>
				      <th scope="col">DamageQty</th>
				      <th scope="col">Remark</th>
				    </tr>
				  </thead>
				</table>			
                </div>

                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
            </div>
        </div>
        
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
                <div class="row-md-12 justify-content-center m-2">
                  <form action="${pageContext.request.contextPath}/deleteGRN?step=req" method="POST">
                  <input type="hidden" name="cus" id="cusName"/>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col-md-12">
                                <label for="GRNNo">GRN No :</label>
                                <input type="text" class="form-control form-control-sm" id="GRNNoForDelete" name="GRNNo" readonly>
                              </div>
                            </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col">
                                  <label for="reason">Enter Reason :</label>
                                  <input type="text" class="form-control form-control-sm" id="reason" placeholder="Enter Reason " name="reason"> 
                              </div>
                          </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row float-right">
                 		<button type="button" class="btn btn-secondary float-right mr-2" data-dismiss="modal">Close</button>
                		<button type="submit" class="btn btn-danger float-right">Request GRN Delete</button>  
                      </div>
                      </div>                                        
                  </form>
                </div>			        
			      </div>
			    </div>
			  </div>
			</div>
        
          <!-- Bootstrap core JavaScript-->
  <script src="../../vendor/jquery/jquery.min.js"></script>
  <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../../js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="../../vendor/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="../../vendor/datatables/dataTables.bootstrap4.min.js"></script>
  
    <!-- Page level custom scripts -->
    <script src="../../js/demo/datatables-demo.js"></script>
    
  
    
    <script>
    
     $(".btnshow").click(function() {
        var $row = $(this).closest("tr");    // Find the row
        var $grn = $row.find(".grn").text(); // Find the text in row
		
	    $.ajax({
	        url      : 'http://localhost:8080/Warehouse_Managment_System/showGRNQty?step=1',
	        method   : 'GET', 
	        data     : {grn: $grn},
	        success  : function(response){
	        	
	        	var grnqty = $.parseJSON(response);
	        	$("#grn_qty td").remove();
	        	
	        	$(function() {
	        		$.each(grnqty, function(i, grnQ) {
				        var $tr = $('<tr>').append(
					            $('<td>').text(grnQ.itemDes),
					            $('<td>').text(grnQ.qty),
					            $('<td>').text(grnQ.seqFeet),
					            $('<td>').text(grnQ.CBM),
					            $('<td>').text(grnQ.wLocId),
					            $('<td>').text(grnQ.damageQty),
					            $('<td>').text(grnQ.remark)
					        ); 
					        $('#grn_qty').append($tr);
					        $('#showId').text(grnQ.GRNNo);
	        		});
	        	});
	        	
	        	$('#show').modal('toggle'); 
				
	      }
	    });
    }); 
     
     $(".btnupdate").click(function() {
         var $row = $(this).closest("tr");    // Find the row
         var $grn = $row.find(".grn").text(); // Find the text in row
 		
 	    $.ajax({
 	        url      : 'http://localhost:8080/Warehouse_Managment_System/showGRNQty?step=2',
 	        method   : 'GET', 
 	        data     : {grn: $grn},
 	        success  : function(response){
 	        	
 	        	var grn = $.parseJSON(response);
 	        	
 	        	$('#updateGRNNo').text(grn.GRNNo);
 	        	$('#updatevehicleNo').val(grn.vehicleNo);
 	        	$('#updatecontainerNo').val(grn.containerNo);
 	        	$('#updatetrailerNo').val(grn.trailerNo); 
 	        	$('#grnForServlet').val(grn.GRNNo);
 	        	
 	        	$('#update').modal('toggle'); 
 				
 	      }
 	    });
     }); 
    
     $(".btndelete").click(function() {
    	 
         var $row = $(this).closest("tr");    // Find the row
         var $grn = $row.find(".grn").text(); // Find the text in row
         var $cus = $row.find(".cus").text();
         
         $('#GRNNoForDelete').val($grn);
         $('#cusName').val($cus);
         
    	 $('#delete').modal('toggle');
     });
     
    </script>

