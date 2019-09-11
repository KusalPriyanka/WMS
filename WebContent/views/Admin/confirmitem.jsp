
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>
<%@page import="com.wms.model.Item"%>
 
		<jsp:include page="header.jsp"></jsp:include>
 
		 <%
		 	HttpSession Session = request.getSession();
		 	Item item = new Item();
		 	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		 
			if(session.getAttribute("Item") != null){
				item = (Item)session.getAttribute("Item");
				System.out.println(item);
			}	
		 %>
 
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Add New Item</h1>
            </div>
              
            <div class="row m-2 justify-content-center m-4">
                <div class="col-md-10">
                  <form action="#" method="POST">
                      <div class="form-group">
                        <div class="form-row">
                              <label for="GRNNumber">Item Code :</label>
                              <input type="text" class="form-control form-control-sm" id="GRNNumber" value="<%= item.getItemId() %>" readonly>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="form-row">
                            <label for="GRNNumber">Enter Item Name :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="Item Name">       
                        </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                            <label for="trailerNo">Enter Description :</label>
                            <input type="text" class="form-control form-control-sm" id="trailerNo" placeholder="Item Description">
                          </div>
                      </div>
                      <div class="form-group">
                            <div class="form-row">
                              <label for="trailerNo">Enter Remark :</label>
                              <input type="text" class="form-control form-control-sm" id="trailerNo" placeholder="Item Remark">
                            </div>
                      </div>
                      <div class="form-group">
                        <div class="form-row">
                            <div class="col pl-0">
                                <label for="exampleFormControlSelect1">Payment Type :</label>
                                <select class="form-control form-control-sm" id="exampleFormControlSelect1">
                                  <option>CBM</option>
                                  <option>Square Feet</option>
                                  <option>Custom Price</option>
                                </select>
                            </div>
                          <div class="col">
                              <div class="form-row">
                                  <label for="trailerNo">Enter Item Price :</label>
                                  <input type="text" class="form-control form-control-sm" id="trailerNo" placeholder="Item Price">
                                </div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col-md-6 pl-0">
                                  <label for="exampleFormControlSelect1">Select Unit Of Measurement :</label>
                                  <select class="form-control form-control-sm" id="exampleFormControlSelect1">
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
            
          </div>
        <!-- /.container-fluid -->

     <jsp:include page="footer.jsp"></jsp:include>  
      