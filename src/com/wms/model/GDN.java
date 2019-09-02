package com.wms.model;

public class GDN {

	private String GDNNo;
	private String vehicleNo;
	private String containerNo;
	private String sTime;
	private String eTime;
	private String cusId;
	private String date;
	private int noOfItems;
	
	public GDN() { }

	public GDN(String gDNNo, String vehicleNo, String containerNo, String sTime, String eTime, String cusId,
			String date) {
		GDNNo = gDNNo;
		this.vehicleNo = vehicleNo;
		this.containerNo = containerNo;
		this.sTime = sTime;
		this.eTime = eTime;
		this.cusId = cusId;
		this.date = date;
	}

	public String getGDNNo() {
		return GDNNo;
	}

	public void setGDNNo(String gDNNo) {
		GDNNo = gDNNo;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	@Override
	public String toString() {
		return "GDN [GDNNo=" + GDNNo + ", vehicleNo=" + vehicleNo + ", containerNo=" + containerNo + ", sTime=" + sTime
				+ ", eTime=" + eTime + ", cusId=" + cusId + ", date=" + date + "]";
	}
	
}
