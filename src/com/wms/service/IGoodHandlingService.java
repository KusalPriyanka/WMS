package com.wms.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.wms.model.Customer;
import com.wms.model.GRN;
import com.wms.model.GRN_Qty;
import com.wms.model.Item;

public interface IGoodHandlingService {

	//GRN
	public void addGRN(GRN grn);
	
	public void addGRNQty(GRN_Qty grn_Qty);
	
	public GRN getGRNById(String GRNNo);
	
	public ArrayList<GRN> getGRNs();
	
	public String getCustomerName(String cusID);
	
	public ArrayList<GRN_Qty> getGRNQTYView(String GRNNo);
	
	public ArrayList<Customer> customerList();
	
	public String generateGRNNo(String cusId);
	
	//Item
	public int getItemCode();
	
	public void addItem(Item item);
	
	public String getItemName(int itemId);
}
