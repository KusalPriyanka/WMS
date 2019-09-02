package com.wms.model;

public class GRN_Qty {
	
	private int id;
	private String GRNNo;
	private String itemId;
	private String itemDes;
	private float qty;
	private int seqFeet;
	private int CBM;
	private String wLocId;
	private float damageQty;
	private String status;
	private String remark;
	
	public GRN_Qty() {}

	public GRN_Qty(int id, String gRNNo, String itemId, float qty, int seqFeet, int cBM, String wLocId,
			float damageQty, String status, String remark) {
		super();
		this.id = id;
		GRNNo = gRNNo;
		this.itemId = itemId;
		this.qty = qty;
		this.seqFeet = seqFeet;
		CBM = cBM;
		this.wLocId = wLocId;
		this.damageQty = damageQty;
		this.status = status;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return seqFeet;
	}

	public void setSeqFeet(int seqFeet) {
		this.seqFeet = seqFeet;
	}

	public int getCBM() {
		return CBM;
	}

	public void setCBM(int cBM) {
		CBM = cBM;
	}

	public String getwLocId() {
		return wLocId;
	}

	public void setwLocId(String wLocId) {
		this.wLocId = wLocId;
	}

	public float getDamageQty() {
		return damageQty;
	}

	public void setDamageQty(float damageQty) {
		this.damageQty = damageQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getItemDes() {
		return itemDes;
	}

	public void setItemDes(String itemDes) {
		this.itemDes = itemDes;
	}

	@Override
	public String toString() {
		return "GRN_Qty [id=" + id + ", GRNNo=" + GRNNo + ", itemId=" + itemId + ", itemDes=" + itemDes + ", qty=" + qty
				+ ", seqFeet=" + seqFeet + ", CBM=" + CBM + ", wLocId=" + wLocId + ", damageQty=" + damageQty
				+ ", status=" + status + ", remark=" + remark + "]";
	}
	
	
}
