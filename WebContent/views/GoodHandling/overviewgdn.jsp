<!DOCTYPE html>
<%@page import="com.wms.model.GDN_Qty"%>
<%@page import="com.wms.model.GDN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
       
       <jsp:include page="header.jsp"></jsp:include>
       
        <%  
        	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
        	ArrayList<GDN> GDNList = goodHandlingService.getGDNs();

        %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">GDN Overview</h1>
            </div>
            
            <div class="row justify-content-center">
            <a href="dispatch.jsp">
            <button type="button" class="btn btn-outline-primary btn-lg">
			    <b>Add New GDN</b>
			</button>
			</a>
            </div>            
              
        <div class="row justify-content-center m-4">
        <div class="col">
            
          <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">GDN List</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>GDN No</th>
                      <th>Customer Name</th>
                      <th>Vehicle No</th>
                      <th>Container No</th>               
                      <th>Date</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>GDN No</th>
                      <th>Customer Name</th>
                      <th>Vehicle No</th>
                      <th>Container No</th>             
                      <th>Date</th>
                      <th></th>
                      </tr>
                  </tfoot>
                <tbody>
                
                <%
                	for(GDN GS : GDNList){
                %>
                
                    <tr>
                        <td class="gdn"><%= GS.getGDNNo() %></td>
                        <td class="cus"><%= goodHandlingService.getCustomerName(GS.getCusId()) %></td>
                        <td><%= GS.getVehicleNo() %></td>
                        <td><%= GS.getContainerNo() %></td>
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
                <h5 class="modal-title" id="updateGDNNo"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                <div class="row-md-12 justify-content-center m-2">
                  <form action="${pageContext.request.contextPath}/UpdateGDN" method="POST">
                  
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
				<table class="table table-hover" id="gdn_qty">
				  <thead>
				    <tr class="bg-primary text-white">
				      <th scope="col">GRNNo</th>
				      <th scope="col">Item Name</th>
				      <th scope="col">QTY</th>				      
				      <th scope="col">SeqFeet</th>				      
				      <th scope="col">CBM</th>
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
			        <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
                <div class="row-md-12 justify-content-center m-2">
                  <form action="${pageContext.request.contextPath}/deleteGDN?step=req" method="POST">
                  <input type="hidden" name="cus" id="cusName"/>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col-md-12">
                                <label for="GRNNo">GDN No :</label>
                                <input type="text" class="form-control form-control-sm" id="GDNNoForDelete" name="GDNNo" readonly>
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
                		<button type="submit" class="btn btn-danger float-right">Request GDN Delete</button>  
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
        var $gdn = $row.find(".gdn").text(); // Find the text in row

 	    $.ajax({
	        url      : 'http://localhost:8080/Warehouse_Managment_System/showGDNQty?step=1',
	        method   : 'GET', 
	        data     : {gdn: $gdn},
	        success  : function(response){
	        	
	        	var gdnqty = $.parseJSON(response);
	        	$("#gdn_qty td").remove();
	        	
	        	$(function() {
	        		$.each(gdnqty, function(i, gdnQ) {
				        var $tr = $('<tr>').append(
					            $('<td>').text(gdnQ.GRNNo),
					            $('<td>').text(gdnQ.itemdes),
					            $('<td>').text(gdnQ.qty),
					            $('<td>').text(gdnQ.SeqFeet),
					            $('<td>').text(gdnQ.CBM),
					            $('<td>').text(gdnQ.remark)
					        ); 
					        $('#gdn_qty').append($tr);
					        $('#showId').text(gdnQ.GDNNo);
	        		});
	        	});
	        	
	        	$('#show').modal('toggle'); 
				
	      }
	    });
    }); 
     
     $(".btnupdate").click(function() {
         var $row = $(this).closest("tr");    // Find the row
         var $gdn = $row.find(".gdn").text(); // Find the text in row

  	    $.ajax({
 	        url      : 'http://localhost:8080/Warehouse_Managment_System/showGDNQty?step=2',
 	        method   : 'GET', 
 	        data     : {gdn: $gdn},
 	        success  : function(response){
 	        	
 	        	var gdn = $.parseJSON(response);
 	        	
 	        	$('#updateGDNNo').text(gdn.GDNNo);
 	        	$('#updatevehicleNo').val(gdn.vehicleNo);
 	        	$('#updatecontainerNo').val(gdn.containerNo);
 	        	$('#gdnForServlet').val(gdn.GDNNo);
 	        	
 	        	$('#update').modal('toggle'); 
 				
 	      }
 	    }); 
     }); 
    
     $(".btndelete").click(function() {
    	 
         var $row = $(this).closest("tr");    // Find the row
         var $gdn = $row.find(".gdn").text(); // Find the text in row
         var $cus = $row.find(".cus").text();
         
         $('#GDNNoForDelete').val($gdn);
         $('#cusName').val($cus);
         
    	 $('#delete').modal('toggle');
     });
     
    </script>

