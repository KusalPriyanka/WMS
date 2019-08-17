package com.wms.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wms.service.IGoodHandlingService;

public class CommonUtil {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(IGoodHandlingService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
			
		} catch (IOException e) {
			
		}
	}
/*
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.EMPLOYEE_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.EMPLOYEE_ID_PREFIX + next;
		}
		return id;
	}
*/
}
