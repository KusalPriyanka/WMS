
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<%@page import="com.wms.model.Item"%>
 
		<jsp:include page="header.jsp"></jsp:include>
 
		 <%
		 	HttpSession Session = request.getSession();
		 	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		 
		 	if(session.getAttribute("Item") == null){
		 		response.sendRedirect("reqitem.jsp");
		 	}
		 	
		 	else{
				Item item = (Item)session.getAttribute("Item");
			
		 %>
 
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Add New Item</h1>
            </div>
              
            <div class="row m-2 justify-content-center m-4">
                <div class="col-md-10">
                  <form action="${pageContext.request.contextPath}/InsertItem?step=cnf" method="POST">
                      <div class="form-group">
                        <div class="form-row">
                              <label for="GRNNumber">Item Code :</label>
                              <input type="text" class="form-control form-control-sm" id="GRNNumber" value="<%= item.getItemId() %>" readonly name="ItemNo">
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="form-row">
                            <label for="GRNNumber">Enter Item Name :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" value="<%= item.getItemName() %>" name="itemName">       
                        </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                            <label for="trailerNo">Enter Description :</label>
                            <input type="text" class="form-control form-control-sm" id="trailerNo" value="<%= item.getItemDes() %>" name="itemDes">
                          </div>
                      </div>
                      <div class="form-group">
                            <div class="form-row">
                              <label for="trailerNo">Enter Remark :</label>
                              <input type="text" class="form-control form-control-sm" id="trailerNo" value="<%= item.getRemark() %>" name="remark">
                            </div>
                      </div>
                      <div class="form-group">
                        <div class="form-row">
                            <div class="col pl-0">
                                <label for="exampleFormControlSelect1">Payment Type :</label>
                                <select class="form-control form-control-sm" id="exampleFormControlSelect1" name="paymentType">
                                <option disabled selected> -- Select Payment Type -- </option>
                                  <option value="1">CBM</option>
                                  <option value="2">Square Feet</option>
                                  <option value="3">Custom Price</option>
                                </select>
                            </div>
                          <div class="col">
                              <div class="form-row">
                                  <label for="trailerNo">Enter Item Price :</label>
                                  <input type="text" class="form-control form-control-sm" id="trailerNo" placeholder="Item Price" name="price">
                                </div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col-md-6 pl-0">
                                  <label for="exampleFormControlSelect1">Select Unit Of Measurement :</label>
                                  <select class="form-control form-control-sm" id="exampleFormControlSelect1" name="uom">
                                    <option>Bags</option>
                                    <option>Box</option>
                                    <option>Plates</option>
                                  </select>
                              </div>
                          </div>
                      </div>  
                      <button type="submit" class="btn btn-primary btn-icon-split mt-2">
                          <span class="icon text-white-50">
                              <i class="fas fa-arrow-right"></i>
                          </span>
                          <span class="text">Add New Item</span>
                      </button>
                  </form>
              </div>  
            </div>
           <% } %>
          </div>
        <!-- /.container-fluid -->

     <jsp:include page="footer.jsp"></jsp:include>  
      