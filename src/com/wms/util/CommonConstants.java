package com.wms.util;

public class CommonConstants {
	
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in EmployeeQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in EmployeeQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for employee id prefix */
	public static final String EMPLOYEE_ID_PREFIX = "E300";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";
	
	/** Constant for query id of drop_table in Query.xml */
	public static final String QUERY_ID_DROP_TABLE_FUNCTION = "drop_table_function";

	/** Constant for query id of drop_table in Query.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in Query.xml */
	public static final String QUERY_ID_CREATE_CUSTOMER_TABLE = "create_customer_table";
	public static final String QUERY_ID_CREATE_GRN_TABLE = "create_GRN_table";
	public static final String QUERY_ID_CREATE_GRN_QTY_TABLE = "create_GRN_Qty_table";
	public static final String QUERY_ID_CREATE_ITEM_TABLE = "create_item_table";
	public static final String QUERY_ID_CREATE_GRN_DELETE_REQUEST_TABLE = "create_grn_delete_req";
	public static final String QUERY_ID_CREATE_ITEM_DELETE_REQUEST_TABLE = "create_item_delete_req";
	public static final String QUERY_ID_CREATE_GDN_TABLE = "create_gdn_table";
	public static final String QUERY_ID_CREATE_GDN_QTY_TABLE = "create_gdn_qty_table";
	public static final String QUERY_ID_CREATE_GDN_DELETE_REQUEST_TABLE = "create_gdn_delete_req";
	
	/** Constant for query id of insert GRN in Query.xml */
	public static final String QUERY_ID_INSERT_GRN = "insert_GRN";
	
	/** Constant for query id of get all GRN in Query.xml */
	public static final String QUERY_ID_ALL_GRN = "all_GRNS";
	
	/** Constant for query id of get specific GRN in Query.xml */
	public static final String QUERY_ID_GET_GRN = "GRN_by_id";
	
	/** Constant for query id of get specific Customer Name in Query.xml */
	public static final String QUERY_ID_GET_CUSTOMER_NAME = "get_Customer_Name";
	
	/** Constant for query id of get specific Customer Name List in Query.xml */
	public static final String QUERY_ID_GET_CUSTOMER_NAME_LIST = "get_Customer_Name_List";
	
	/** Constant for query id of get specific Customer REF in Query.xml */
	public static final String QUERY_ID_GET_CUSTOMER_REF = "get_Customer_REF";
	
	/** Constant for query id of get GRN COUNT in Query.xml */
	public static final String QUERY_ID_GET_GRN_COUNT_BY_ID = "GRN_COUNT_BY_ID";
	
	/** Constant for query id of insert GRN QTY in Query.xml */
	public static final String QUERY_ID_INSERT_GRN_QTY = "insert_GRN_QTY";
	
	/** Constant for query id of get GRN QTY view in Query.xml */
	public static final String QUERY_ID_GET_GRNQTY_VIEW = "get_GRN_View";
	
	/** Constant for query id of get GRN By cusid view in Query.xml */
	public static final String QUERY_ID_GET_GRN_BY_CUSID = "get_GRN_By_cusId";
	
	/** Constant for query id of Update GRN in Query.xml */
	public static final String QUERY_ID_UPDATE_GRN = "update_GRN";
	
	/** Constant for query id of DELETE req GRN in Query.xml */
	public static final String QUERY_ID_REQUEST_DELETE_GRN = "request_delete_GRN";
	
	/** Constant for query id of get GRN in Query.xml */
	public static final String QUERY_ID_GET_GRNQTY_GRNNOANDITEMID = "get_GRN_By_ItemIdAndCusId";
	
	/** Constant for query id of insert Item in Query.xml */
	public static final String QUERY_ID_INSERT_ITEM = "insert_ITEM";
	
	/** Constant for query id of get item code in Query.xml */
	public static final String QUERY_ID_GET_ITEM_CODE = "get_Item_Code";
	
	/** Constant for query id of get Item name in Query.xml */
	public static final String QUERY_ID_GET_ITEM_NAME = "GET_ITEM_NAME";
	
	/** Constant for query id of get Item List in Query.xml */
	public static final String QUERY_ID_GET_ITEM_LIST = "GET_ITEM_LIST";
	
	/** Constant for query id of Update Item in Query.xml */
	public static final String QUERY_ID_UPDATE_ITEM = "GET_ITEM_UPDATE";

	/** Constant for query id of Update Item in Query.xml */
	public static final String QUERY_ID_GET_ITEM_BY_ID = "GET_ITEM_BY_ID";
	
	/** Constant for query id of DELETE req Item in Query.xml */
	public static final String QUERY_ID_REQUEST_DELETE_ITEM = "request_delete_ITEM";
	
	/** Constant for query id of get GRN COUNT in Query.xml */
	public static final String QUERY_ID_GET_GDN_COUNT_BY_ID = "GDN_COUNT_BY_ID";
	
	/** Constant for query id of insert GDN in Query.xml */
	public static final String QUERY_ID_INSERT_GDN = "insert_GDN";
	
	/** Constant for query id of insert GDN in Query.xml */
	public static final String QUERY_ID_INSERT_GDN_QTY = "insert_GDN_QTY";
	
	/** Constant for query id of get all GDN in Query.xml */
	public static final String QUERY_ID_ALL_GDN = "all_GDNS";
	
	/** Constant for query id of get GDN in Query.xml */
	public static final String QUERY_ID_GET_GDNQTY_BY_GDNNO = "get_GDNQTY_BY_GDNNO";
	
	/** Constant for query id of Update GDN in Query.xml */
	public static final String QUERY_ID_UPDATE_GDN = "update_GDN";
	
	/** Constant for query id of get GDN by id in Query.xml */
	public static final String QUERY_ID_GET_GDN_BY_GDNNO = "get_GDN_BYID";
	
	/** Constant for query id of DELETE req GDN in Query.xml */
	public static final String QUERY_ID_REQUEST_DELETE_GDN = "request_delete_gdn";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINE = 9;
	
	/** Constant for Column index ten */
	public static final int COLUMN_INDEX_TEN = 10;
	
	/** Constant for Column index eleven */
	public static final int COLUMN_INDEX_ELEVEN = 11;
	
}
