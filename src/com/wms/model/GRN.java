package com.wms.model;

public class GRN {

	private String GRNNo;
	private String vehicleNo;
	private String containerNo;
	private String trailerNo;
	private String date;
	private String sTime;
	private String eTime;
	private String cusId;
	private int noOfItems;
	
	public GRN() {}

	public GRN(String gRNNo, String vehicleNo, String containerNo, String trailerNo, String date, String sTime,
			String eTime, String cusId , int noOfItems) {
		super();
		GRNNo = gRNNo;
		this.vehicleNo = vehicleNo;
		this.containerNo = containerNo;
		this.trailerNo = trailerNo;
		this.date = date;
		this.sTime = sTime;
		this.eTime = eTime;
		this.cusId = cusId;
		this.noOfItems = noOfItems;
	}

	public String getGRNNo() {
		return GRNNo;
	}

	public void setGRNNo(String gRNNo) {
		GRNNo = gRNNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	public String getTrailerNo() {
		return trailerNo;
	}

	public void setTrailerNo(String trailerNo) {
		this.trailerNo = trailerNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	@Override
	public String toString() {
		return "GRN [GRNNo=" + GRNNo + ", vehicleNo=" + vehicleNo + ", containerNo=" + containerNo + ", trailerNo="
				+ trailerNo + ", date=" + date + ", sTime=" + sTime + ", eTime=" + eTime + ", cusId=" + cusId + "]";
	}
	
	
}
