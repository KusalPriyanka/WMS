package com.wms.service;

import java.util.ArrayList;

import com.wms.model.GRN;
import com.wms.model.GRN_Qty;
import com.wms.model.Item;

public interface IGoodHandlingService {

	//GRN
	public void addGRN(GRN grn);
	
	public void addGRNQty(GRN_Qty grn_Qty);
	
	public GRN getGRNById(String GRNNo);
	
	public ArrayList<GRN> getGRNs();
	
	//Item
	public int getItemCode();
	
	public void addItem(Item item);
}
