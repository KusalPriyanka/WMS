package com.wms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.wms.model.Customer;
import com.wms.model.GRN;
import com.wms.model.GRN_Qty;
import com.wms.model.Item;
import com.wms.util.CommonConstants;
import com.wms.util.DBConnectionUtil;
import com.wms.util.QueryUtil;

public class GoodHandlingServiceImpl implements IGoodHandlingService {
	
	public static final Logger log = Logger.getLogger(IGoodHandlingService.class.getName());
	
	private static Connection connection;

	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	static{
		//create table or drop if exist
		createTable();
	}
	
	private static void createTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			//Create Stored Procedure to drop tables 
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE_FUNCTION));
			
			// Drop table if already exists and as per SQL query available in

			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
			
			// Create new employees table as per SQL query available in
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_CUSTOMER_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_GRN_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_GRN_QTY_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ITEM_TABLE));
			

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			
		}
		
	}

	
	@Override
	public void addGRN(GRN grn) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_GRN));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, grn.getGRNNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, grn.getVehicleNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, grn.getContainerNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, grn.getTrailerNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, grn.getDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, grn.getsTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, grn.geteTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, grn.getCusId());
			
			preparedStatement.execute();
			connection.commit();
			
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
			
		}
		
	}
	
	
	@Override
	public void addGRNQty(GRN_Qty grn_Qty) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_GRN_QTY));
			connection.setAutoCommit(false);
			
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, grn_Qty.getId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, grn_Qty.getGRNNo());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, grn_Qty.getItemId());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_FOUR, grn_Qty.getQty());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, grn_Qty.getUom());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, grn_Qty.getSeqFeet());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SEVEN, grn_Qty.getCBM());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, grn_Qty.getwLocId());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_NINE, grn_Qty.getDamageQty());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, grn_Qty.getStatus());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, grn_Qty.getRemark());
			
			preparedStatement.execute();
			connection.commit();
	
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
			
	}

	
	@Override
	public GRN getGRNById(String GRNNo) {
		
		return actionGRN(GRNNo).get(0);
	}
	
	@Override
	public ArrayList<GRN> getGRNs() {
		
		return actionGRN(null);
	}
	
	private ArrayList<GRN> actionGRN(String GRNNo){
		
		ArrayList<GRN> grnlist = new ArrayList<GRN>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			if (GRNNo != null && !GRNNo.isEmpty()) {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GRN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, GRNNo);
				
			}
			
			else {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_GRN));
				
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				GRN grn = new GRN();
				grn.setGRNNo(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				grn.setVehicleNo(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				grn.setContainerNo(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				grn.setTrailerNo(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				grn.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				grn.setsTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				grn.seteTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				grn.setCusId(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				grnlist.add(grn);
								
			}
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return grnlist;
		
	}


	@Override
	public void addItem(Item item) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEM));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemDes());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getRemark());
			
			preparedStatement.execute();
			connection.commit();
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}

	@Override
	public int getItemCode() {
		
		int itemCount = 0;
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_CODE));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				itemCount = resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE);
				
			}
			
		} catch (Exception e) {
			
			log.log(Level.SEVERE, e.getMessage());
			
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return ++itemCount;
	}


	@Override
	public String getCustomerName(String cusID) {
		
		String name = null;
	
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_NAME));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cusID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				name = resultSet.getString(CommonConstants.COLUMN_INDEX_ONE);
				
			}
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return name;
	}


	@Override
	public ArrayList<GRN_Qty> getGRNQTYView(String GRNNo) {
		
		ArrayList<GRN_Qty> grnlist = new ArrayList<GRN_Qty>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GRNQTY_VIEW));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, GRNNo);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				GRN_Qty grn_Qty = new GRN_Qty();
				grn_Qty.setGRNNo(GRNNo);
				grn_Qty.setItemId(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
				grn_Qty.setQty(resultSet.getFloat(CommonConstants.COLUMN_INDEX_TWO));
				grn_Qty.setUom(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				grn_Qty.setSeqFeet(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				grn_Qty.setCBM(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
				grn_Qty.setwLocId(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				grn_Qty.setDamageQty(resultSet.getFloat(CommonConstants.COLUMN_INDEX_SEVEN));
				grn_Qty.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				grn_Qty.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				grnlist.add(grn_Qty);
				
			}
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return grnlist;
	}


	@Override
	public String getItemName(int itemId) {
		
		String name = null;
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_NAME));
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, itemId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				name = resultSet.getString(CommonConstants.COLUMN_INDEX_ONE);
				
			}
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return name;
	}


	@Override
	public ArrayList<Customer> customerList() {
		
		ArrayList<Customer> cusList = new ArrayList<Customer>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_NAME_LIST));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				customer.setCusName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				cusList.add(customer);
			}
			
				
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return cusList;
	}


	@Override
	public String generateGRNNo(String cusId) {
		
		String GRNNo = "DWW/" + getCustomerRef(cusId) + "/";
		int count = 0;
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GRN_COUNT_BY_ID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cusId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
					
				count = resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE);

			}
			
			GRNNo += String.format("%02d", ++count);
			
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		
		return GRNNo;
	}

	private String getCustomerRef(String cusId) {
		
		String CusRef = null;
		
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CUSTOMER_REF));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cusId);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
						
					CusRef = resultSet.getString(CommonConstants.COLUMN_INDEX_ONE);

				}
				
			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		
		return CusRef;	
		
	}
}
