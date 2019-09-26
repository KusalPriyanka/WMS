
<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.service.IGoodHandlingService"%>

 <jsp:include page="header.jsp"></jsp:include>
 
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Request New Item</h1>
            </div>
            
            <%
            	IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
            %>
              
            <div class="row m-2 justify-content-center m-4">
                <div class="col-md-10">
                  <form action="${pageContext.request.contextPath}/InsertItem?step=req" method="POST">
                      <div class="form-group">
                        <div class="form-row">
                              <label for="GRNNumber">Item Code :</label>
                              <input type="text" class="form-control form-control-sm" id="GRNNumber" value="<%= goodHandlingService.getItemCode() %>" name="itemCode" readonly>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="form-row">
                            <label for="GRNNumber">Enter Item Name :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="Item Name" name="itemName">       
                        </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                            <label for="trailerNo">Enter Description :</label>
                            <input type="text" class="form-control form-control-sm" id="trailerNo" placeholder="Item Description" name="itemDes">
                          </div>
                      </div>
                      <div class="form-group">
                            <div class="form-row">
                              <label for="trailerNo">Enter Remark :</label>
                              <input type="text" class="form-control form-control-sm" id="trailerNo" placeholder="Item Remark" name="itemRemark">
                            </div>
                       </div>
                      <button type="submit" class="btn btn-primary btn-icon-split mt-2">
                          <span class="icon text-white-50">
                              <i class="fas fa-arrow-right"></i>
                          </span>
                          <span class="text">Request New Item</span>
                      </button>
                  </form>
              </div>  
            </div>
            
          </div>
        <!-- /.container-fluid -->

  <jsp:include page="footer.jsp"></jsp:include>