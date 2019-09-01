
<%@page import="com.wms.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<%@page import="com.wms.model.GRN"%>
<jsp:include page="header.jsp"></jsp:include>
 		
 		<%
 				
 			HttpSession Session = request.getSession();
 			
 			if(session.getAttribute("GRN") == null){
 				response.sendRedirect("goodreceive_s1.jsp");
 			}
 			
 			IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
			ArrayList<Item> itemList = goodHandlingService.getItemList();
	
 		%>
 		
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Create New Good Received Notice</h1>
            </div>
            <div class="row m-2">
                <h1 class="h6 font-weight-bold text-primary">Add Products Details</h1>
            </div>

            <div class="row m-2">
                <div class="col-md-8">
                    <form action="${pageContext.request.contextPath}/InsertGRN?step=2" method="POST">
						<input type="hidden" value="<%= session.getAttribute("GRNNo") %>" name="GRNNo"/>
                        <div class="form-group">
                                                      
                                <label for="item">Select Item :</label>
                                <select class="form-control form-control-sm" id="item" name="itemId">
                                
                                <% for(Item I : itemList){ %>
                                                               
                                    <option value="<%= I.getItemId() %>"><%= I.getItemName() %></option>
                                    
   								<% } %> 
                                </select>
                                
                      
                                                            
                        </div>

                        <div class="form-group">
                            <label for="batchno">Enter Batch No :</label>
                            <input type="text" class="form-control form-control-sm" id="batchno" placeholder="Batch No" name="batchNo">
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col">
                                    <label for="quantity">Enter Quantity :</label>
                                    <input type="text" class="form-control form-control-sm" id="quantity" placeholder="Quantity" name="qty">
                                </div>
                        	<div class="col">
                               <label for="status">Enter Status :</label>
                               <input type="text" class="form-control form-control-sm" id="status" placeholder="Status" name="status">
                        	</div>
                        </div>

                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col">
                                    <label for="squfeet">Enter Square Feet :</label>
                                    <input type="text" class="form-control form-control-sm" id="squfeet" placeholder="Square Feet" name="sf">
                                </div>
                                <div class="col">
                                    <label for="cbm">Enter CBM :</label>
                                    <input type="text" class="form-control form-control-sm" id="cbm" placeholder="CBM" name="cbm">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                                <div class="form-row">
                                    <div class="col">
                                        <label for="wLoc">Enter Warehouse Location :</label>
                                        <input type="text" class="form-control form-control-sm" id="wLoc" placeholder="Warehouse Location" name="wLoc">
                                    </div>
                                    <div class="col">
                                        <label for="dQuantity">Enter Damage Quantity :</label>
                                        <input type="text" class="form-control form-control-sm" id="dQuantity" placeholder="Damage Quantity" name="dQty">
                                    </div>
                                </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                        	<div class="col">
                        	   	<label for="remark">Enter Remark :</label>
                            	<input type="text" class="form-control form-control-sm" id="remark" placeholder="Remark" name="remark">
                        	</div>
							</div>
                        </div>

                        <button type="submit" class="btn btn-primary btn-icon-split mt-2 mb-3">
                                <span class="icon text-white-50">
                                    <i class="fas fa-arrow-right"></i>
                                </span>
                                <span class="text">Create GRN Report</span>
                        </button>

                    </form>
                </div>
                <div class="col-md-4">
                    <label for="wloc">Select Warehouse Location :</label> <br>
                    <div class="row">
                        <div class="col">
                          <table class="table table-sm table-borderless">
                            <thead>
                              <tr class="table-light">
                                <th scope="col">A section</th>
                                <th scope="col">B Section</th>
                              </tr>
                            </thead>
                            <tbody>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-success">1000</a></th>
                                <td><a href="#" class="badge badge-primary">Free Space</a> <a href="#" class="badge badge-danger">400</a></td>
                              </tr>
                            </tbody>
                          </table>
                    </div>
                </div>
            </div>
                    

        </div>
        <!-- /.container-fluid -->

 <jsp:include page="footer.jsp"></jsp:include>