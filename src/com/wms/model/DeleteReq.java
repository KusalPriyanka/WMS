package com.wms.model;

public class DeleteReq {

	private int id;
	private String cusName;
	private String No;
	private String reason;
	
	public DeleteReq() { }

	public DeleteReq(int id, String cusName, String gRNNo, String reason) {
		this.id = id;
		this.cusName = cusName;
		No = gRNNo;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String No) {
		this.No = No;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
