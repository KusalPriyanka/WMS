package com.wms.service;

import java.util.ArrayList;

import com.wms.model.GRN;
import com.wms.model.GRN_Qty;
import com.wms.model.GRN_Show;
import com.wms.model.Item;

public interface IGoodHandlingService {

	//GRN
	public void addGRN(GRN grn);
	
	public void addGRNQty(GRN_Qty grn_Qty);
	
	public GRN getGRNById(String GRNNo);
	
	public ArrayList<GRN_Show> getGRNs();
	
	public ArrayList<GRN_Show> getGRNTable();
	
	//Item
	public int getItemCode();
	
	public void addItem(Item item);
}
