<!DOCTYPE html>
<%@page import="com.wms.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
       
       <jsp:include page="header.jsp"></jsp:include>
       
        <%  
        	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
        	ArrayList<Item> itemList = goodHandlingService.getItemList();

        %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Item Overview</h1>
            </div>
            
            <div class="row justify-content-center">
            <a href="itemrequest.jsp">
            <button type="button" class="btn btn-outline-primary btn-lg">
			    <b>Request New Item</b>
			</button>
			</a>
            </div>            
              
        <div class="row justify-content-center m-4">
        <div class="col">
            
          <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Item List</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Item Code</th>
                      <th>Item Name</th>
                      <th>Item Description</th>
                      <th>Item Remark</th>
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
                      <th>Item Remark</th>
                      <th>Payment Method</th>
                      <th>Price</th>                   
                      <th>UOM</th>
                      <th></th>
                      </tr>
                  </tfoot>
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
                        <td><center>
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
       
 
      </div>
      <!-- End of Main Content -->

      <!-- Update Modal -->
        <div class="modal fade bd-example-modal-lg" id="update" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="updateItem"></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                <div class="row-md-12 justify-content-center m-2">
                  <form action="${pageContext.request.contextPath}/updateItem?step=update" method="POST">
                  <input type="hidden" name="itemId" id="itemIdForServlet"/>

                      <div class="form-group">
                        <div class="form-row">
                            <label for="itemName">Enter Item Name :</label>
                            <input type="text" class="form-control form-control-sm" id="itemName" placeholder="Item Name" name="itemName">       
                        </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                            <label for="itemDes">Enter Description :</label>
                            <input type="text" class="form-control form-control-sm" id="itemDes" placeholder="Item Description" name="des">
                          </div>
                      </div>
                      <div class="form-group">
                            <div class="form-row">
                              <label for="itemRemark">Enter Remark :</label>
                              <input type="text" class="form-control form-control-sm" id="itemRemark" placeholder="Item Remark" name="remark">
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
                  <form action="${pageContext.request.contextPath}/deleteItem?step=req" method="POST">
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col-md-12">
                                <label for="itemForDelete">Item No :</label>
                                <input type="text" class="form-control form-control-sm" id="itemForDelete" name="id" readonly>
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
     
     $(".btnupdate").click(function() {
         var $row = $(this).closest("tr");    // Find the row
         var $item = $row.find(".item").text(); // Find the text in row         
 		
 	    $.ajax({
 	        url      : 'http://localhost:8080/Warehouse_Managment_System/updateItem?step=get',
 	        method   : 'POST', 
 	        data     : {item: $item},
 	        success  : function(response){
 	        	
 	        	var item = $.parseJSON(response);
 	        	
 	        	$('#updateItem').text(item.itemId + " : " + item.itemName);
 	        	$('#itemName').val(item.itemName);
 	        	$('#itemDes').val(item.itemDes);
 	        	$('#itemRemark').val(item.remark); 
 	        	$('#itemIdForServlet').val(item.itemId);
 	        	
 	        	$('#update').modal('toggle'); 
 				
 	      }
 	    });        
     }); 
    
     $(".btndelete").click(function() {
    	 
         var $row = $(this).closest("tr");    // Find the row
         var $item = $row.find(".item").text(); // Find the text in row   
         
         $('#itemForDelete').val($item);
         
    	 $('#delete').modal('toggle');
     });
     
    </script>

