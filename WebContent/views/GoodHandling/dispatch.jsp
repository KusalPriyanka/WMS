 		
 		<jsp:include page="header.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <div class="row m-2">
              <h1 class="h3 font-weight-bold text-primary">Create New Good Dispatch Notice</h1>
          </div>
            
          <div class="row m-2 justify-content-center m-4">
              <div class="col-md-10">
                <form action="#" method="POST">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Select Customer :</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                          <option>Mr. Kusal Priyanka</option>
                          <option>Miss Ruwani Sanjula</option>
                          <option>Mr. Gimith M.R.</option>
                        </select>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="GRNNumber">GDN No :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="GDN No">
                          </div>
                          <div class="col">
                              <label for="Date">Select Date :</label>
                              <input type="date" class="form-control form-control-sm" id="Date">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="vehicleNo">Enter Vehicle Number :</label>
                            <input type="text" class="form-control form-control-sm" id="vehicleNo" placeholder="Vehicle Number">
                          </div>
                          <div class="col">
                              <label for="containerNo">Enter Container Number :</label>
                              <input type="text" class="form-control form-control-sm" id="containerNo" placeholder="Container Number">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col">
                              <label for="STime">Enter Start Time :</label>
                              <input type="time" class="form-control form-control-sm" id="STime" placeholder="Start Time">
                            </div>
                            <div class="col">
                                <label for="ETime">Enter End Time :</label>
                                <input type="time" class="form-control form-control-sm" id="ETime" placeholder="End Time">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                              <label for="NoOfProducts">Enter No Of Products :</label>
                              <input type="number" class="form-control form-control-sm" id="NoOfProducts" placeholder="No Of Products">
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
 <jsp:include page="footer.jsp"></jsp:include>