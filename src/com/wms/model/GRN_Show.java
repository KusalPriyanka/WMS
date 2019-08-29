package com.wms.model;

public class GRN_Show {
	
	private GRN GRN;
	private GRN_Qty GRN_Qty;
	private String cusName;
	private String GRNNo;
	private String ItemName;
	private int sqFeet;
	private String wLoc;
	private float qty;
	private String Date;
	
	public GRN_Show() {	}

	public GRN_Show(com.wms.model.GRN gRN, com.wms.model.GRN_Qty gRN_Qty) {
		super();
		GRN = gRN;
		GRN_Qty = gRN_Qty;
	}

	public GRN getGRN() {
		return GRN;
	}

	public void setGRN(GRN gRN) {
		GRN = gRN;
	}

	public GRN_Qty getGRN_Qty() {
		return GRN_Qty;
	}

	public void setGRN_Qty(GRN_Qty gRN_Qty) {
		GRN_Qty = gRN_Qty;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getGRNNo() {
		return GRNNo;
	}

	public void setGRNNo(String gRNNo) {
		GRNNo = gRNNo;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getSqFeet() {
		return sqFeet;
	}

	public void setSqFeet(int sqFeet) {
		this.sqFeet = sqFeet;
	}

	public String getwLoc() {
		return wLoc;
	}

	public void setwLoc(String wLoc) {
		this.wLoc = wLoc;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	
}
