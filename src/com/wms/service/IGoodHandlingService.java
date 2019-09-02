package com.wms.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.wms.model.Customer;
import com.wms.model.GDN;
import com.wms.model.GRN;
import com.wms.model.GRN_Qty;
import com.wms.model.Item;

public interface IGoodHandlingService {
	
	//Common
	public String getCustomerName(String cusID);
	
	public ArrayList<Customer> customerList();
	
	//GRN
	public void addGRN(GRN grn);
	
	public void addGRNQty(GRN_Qty grn_Qty);
	
	public GRN getGRNById(String GRNNo);
	
	public ArrayList<GRN> getGRNs();
	
	public ArrayList<GRN_Qty> getGRNQTYView(String GRNNo);
	
	public ArrayList<GRN> getGRNByCusID(String cusId);
		
	public String generateGRNNo(String cusId);
	
	public void updateGRN(GRN grn);
	
	public void requestDeleteGRN(String GRNNo,String reason);
	
	//GDN
	
	public String generateGDNNo(String cusId);
	
	public void addGDN(GDN gdn);
	
	//Item
	public int getItemCode();
	
	public void addItem(Item item);
	
	public String getItemName(String itemId);
	
	public ArrayList<Item> getReqItemList();
	
	public ArrayList<Item> getItemList();
	
	public Item getItemById(String Id);
	
	public void updateItem(Item item);
	
	public void requestDeleteItem(String itemId,String reason);
}
