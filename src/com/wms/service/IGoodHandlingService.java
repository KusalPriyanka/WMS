package com.wms.service;

import com.wms.model.GRN;

public interface IGoodHandlingService {

	public void addGRN(GRN grn);
	
	public GRN getGRNById(String GRNNo);
}
