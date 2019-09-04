package com.wms.model;

public class GDN_Qty {

	private int Id;
	private String GDNNo;
	private String GRNNo;
	private String itemId;
	private String itemdes;
	private float qty;
	private int SeqFeet;
	private int CBM;
	private String remark;
	
	public GDN_Qty() {}

	public GDN_Qty(String gDNNo, String gRNNo, String itemId, float qty, int seqFeet, int cBM, String remark) {
		super();
		GDNNo = gDNNo;
		GRNNo = gRNNo;
		this.itemId = itemId;
		this.qty = qty;
		SeqFeet = seqFeet;
		CBM = cBM;
		this.remark = remark;
	}

	public String getGDNNo() {
		return GDNNo;
	}

	public void setGDNNo(String gDNNo) {
		GDNNo = gDNNo;
	}

	public String getGRNNo() {
		return GRNNo;
	}

	public void setGRNNo(String gRNNo) {
		GRNNo = gRNNo;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public int getSeqFeet() {
		return SeqFeet;
	}

	public void setSeqFeet(int seqFeet) {
		SeqFeet = seqFeet;
	}

	public int getCBM() {
		return CBM;
	}

	public void setCBM(int cBM) {
		CBM = cBM;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getItemdes() {
		return itemdes;
	}

	public void setItemdes(String itemdes) {
		this.itemdes = itemdes;
	}

	@Override
	public String toString() {
		return "GDN_Qty [Id=" + Id + ", GDNNo=" + GDNNo + ", GRNNo=" + GRNNo + ", itemId=" + itemId + ", qty=" + qty
				+ ", SeqFeet=" + SeqFeet + ", CBM=" + CBM + ", remark=" + remark + "]";
	}
	
}
