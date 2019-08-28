package com.wms.model;

public class GRN_Show {
	
	private GRN GRN;
	private GRN_Qty GRN_Qty;
	
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
	
	
}
