
 <jsp:include page="header.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <div class="row m-2">
              <h1 class="h3 font-weight-bold text-primary">Create New Good Dispatch Notice</h1>
          </div>
            
          <div class="row m-2 justify-content-center m-4">
              <div class="col-md-8">
                <form action="#" method="POST">
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">Select GRN No :</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                          <option>GRN-GMT-01</option>
                          <option>GRN-GMT-02</option>
                          <option>GRN-GMT-03</option>
                        </select>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="GRNNumber">GDN No :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="GDN No">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="GRNNumber">Enter QTY :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="Quantity">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="GRNNumber">Enter Square Feet :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="Release Square Feet">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="GRNNumber">Enter CBM :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="Release CBM">
                          </div>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="form-row">
                          <div class="col">
                            <label for="GRNNumber">Enter Remark :</label>
                            <input type="text" class="form-control form-control-sm" id="GRNNumber" placeholder="Enter Remark">
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
            <div class="col-md-4">
              <div class="card mt-5">
                <div class="card-body">
                  <h5 class="card-title">Customer Name</h5>
                  <h6 class="card-subtitle mb-2 text-muted">GRN No</h6>
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">Quantity</li>
                  <li class="list-group-item">Unit Of Measurement</li>
                  <li class="list-group-item">Square Feet</li>
                  <li class="list-group-item">CBM</li>
                  <li class="list-group-item">Remark</li>
                </ul>
              </div>
            </div>  
          </div>
          
        </div>
       
      <!-- End of Main Content -->

      <jsp:include page="footer.jsp"></jsp:include>