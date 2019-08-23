package com.wms.service;

import java.util.ArrayList;

import com.wms.model.GRN;

public interface IGoodHandlingService {

	public void addGRN(GRN grn);
	
	public GRN getGRNById(String GRNNo);
	
	public ArrayList<GRN> getGRNs();
}
