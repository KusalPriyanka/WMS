package com.wms.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.wms.model.Customer;
import com.wms.model.DeleteReq;
import com.wms.model.GDN;
import com.wms.model.GDN_Qty;
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
	
	public GRN_Qty getGRNQtyByGRNNoAndItemId(String GRNNo, String ItemId);
	
	public ArrayList<GRN_Qty> getGRNQTYView(String GRNNo);
	
	public ArrayList<GRN> getGRNByCusID(String cusId);
		
	public String generateGRNNo(String cusId);
	
	public void updateGRN(GRN grn);
	
	public void requestDeleteGRN(DeleteReq deleteReq);
	
	public void deleteGRN(String GRNNo);
	
	public ArrayList<DeleteReq> showReqDeleteGRN();
	
	public void dropDeleteReqGRN(String GRNNo);
	
	//GDN
	
	public String generateGDNNo(String cusId);
	
	public void addGDN(GDN gdn);
	
	public void addGDNQty(GDN_Qty GDNQty);
	
	public ArrayList<GDN> getGDNs();
	
	public ArrayList<GDN_Qty> getGDNQTYView(String GDNNo);
	
	public void updateGDN(GDN gdn);
	
	public GDN getGDNById(String GDNNo);
	
	public void requestDeleteGDN(DeleteReq deleteReq);
	
	public void deleteGDN(String GDNNo);
	
	public ArrayList<DeleteReq> showReqDeleteGDN();
	
	public void dropDeleteReqGDN(String GDNNo);
	
	//Item
	public String getItemCode();
	
	public void addItem(Item item);
	
	public String getItemName(String itemId);
	
	public ArrayList<Item> getReqItemList();
	
	public ArrayList<Item> getItemList();
	
	public Item getItemById(String Id);
	
	public void updateItem(Item item);
	
	public void requestDeleteItem(String itemId,String reason);
	
	public void confirmItem(Item item);
}