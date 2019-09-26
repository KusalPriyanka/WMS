package com.wms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.wms.model.Customer;
import com.wms.model.DeleteReq;
import com.wms.model.GDN;
import com.wms.model.GDN_Qty;
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
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ITEM_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_GRN_QTY_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_GDN_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_GDN_QTY_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_GRN_DELETE_REQUEST_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_ITEM_DELETE_REQUEST_TABLE));
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_GDN_DELETE_REQUEST_TABLE));
			

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
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, grn_Qty.getItemId());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_FOUR, grn_Qty.getQty());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, grn_Qty.getSeqFeet());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, grn_Qty.getCBM());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, grn_Qty.getwLocId());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_EIGHT, grn_Qty.getDamageQty());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, grn_Qty.getStatus());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, grn_Qty.getRemark());
			
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
	public ArrayList<GRN> getGRNByCusID(String cusId) {
		
		ArrayList<GRN> grnlist = new ArrayList<GRN>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GRN_BY_CUSID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cusId);
			
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
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getItemDes());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getRemark());
			
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
	public String getItemCode() {
		
		int itemCount = 0;
		String itemCode = "Item-";
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_CODE));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				itemCount = resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE);
				
			}
			
			itemCode += String.format("%02d", ++itemCount);
			
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
		
		return itemCode;
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
				grn_Qty.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				grn_Qty.setQty(resultSet.getFloat(CommonConstants.COLUMN_INDEX_TWO));
				grn_Qty.setSeqFeet(resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE));
				grn_Qty.setCBM(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				grn_Qty.setwLocId(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				grn_Qty.setDamageQty(resultSet.getFloat(CommonConstants.COLUMN_INDEX_SIX));
				grn_Qty.setStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				grn_Qty.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
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
	public String getItemName(String itemId) {
		
		String name = null;
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_NAME));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
			
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

	@Override
	public ArrayList<Item> getReqItemList() {
		
		ArrayList<Item> itemList = getItemListAction(0);
		
		return itemList;
	}
	
	@Override
	public ArrayList<Item> getItemList() {
		
		ArrayList<Item> itemList = getItemListAction(1);
		
		return itemList;
	}
	
	private ArrayList<Item> getItemListAction(int status) {
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_LIST));
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(status == 0) {
				
				while(resultSet.next()) {
					
					if(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE) == -1 && resultSet.getFloat(CommonConstants.COLUMN_INDEX_SIX) == -1) {
					
						Item item = new Item();
						item.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
						item.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
						item.setItemDes(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
						item.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
						item.setPaymentMethod(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
						item.setPrice(resultSet.getFloat(CommonConstants.COLUMN_INDEX_SIX));
						item.setUom(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
						itemList.add(item);
					
					}
					
				}				
			}

			else if(status == 1) {
				
				while(resultSet.next()) {
					
					if(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE) != -1 && resultSet.getFloat(CommonConstants.COLUMN_INDEX_SIX) != -1) {
					
						Item item = new Item();
						item.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
						item.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
						item.setItemDes(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
						item.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
						item.setPaymentMethod(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
						item.setPrice(resultSet.getFloat(CommonConstants.COLUMN_INDEX_SIX));
						item.setUom(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
						itemList.add(item);
					
					}
					
				}
				
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
		
		return itemList;
	}


	@Override
	public void updateGRN(GRN grn) {
		
		if(grn != null) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_GRN));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, grn.getVehicleNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, grn.getContainerNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, grn.getTrailerNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, grn.getGRNNo());
				
				preparedStatement.executeUpdate();
				
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
		
	}


	@Override
	public void requestDeleteGRN(DeleteReq deleteReq) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REQUEST_DELETE_GRN));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, deleteReq.getCusName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, deleteReq.getNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, deleteReq.getReason());
			
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
	public void updateItem(Item item) {
		
		if(item != null) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ITEM));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemDes());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getRemark());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, item.getItemId());
				
				preparedStatement.executeUpdate();
				
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
		
	}


	@Override
	public Item getItemById(String Id) {
		
		Item item = new Item();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ITEM_BY_ID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				item.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				item.setItemName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				item.setItemDes(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				item.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				item.setPaymentMethod(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
				item.setPrice(resultSet.getFloat(CommonConstants.COLUMN_INDEX_SIX));
				item.setUom(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				
			}
			
		} catch(Exception e){
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
			
		return item;
	}


	@Override
	public void requestDeleteItem(String itemId, String reason) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REQUEST_DELETE_ITEM));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, itemId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, reason);
			
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
	public String generateGDNNo(String cusId) {
		
		String GDNNo = "DWW/" + getCustomerRef(cusId) + "/";
		int count = 0;
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GDN_COUNT_BY_ID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, cusId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
					
				count = resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE);

			}
			
			GDNNo += String.format("%02d", ++count);
			
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
		
		
		return GDNNo;
		
	}


	@Override
	public void addGDN(GDN gdn) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_GDN));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, gdn.getGDNNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, gdn.getVehicleNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, gdn.getContainerNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, gdn.getDate());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, gdn.getsTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, gdn.geteTime());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, gdn.getCusId());
			
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
	public GRN_Qty getGRNQtyByGRNNoAndItemId(String GRNNo, String ItemId) {
		
		GRN_Qty grn_Qty = new GRN_Qty();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GRNQTY_GRNNOANDITEMID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, GRNNo);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, ItemId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				grn_Qty.setQty(resultSet.getFloat(CommonConstants.COLUMN_INDEX_ONE));
				grn_Qty.setSeqFeet(resultSet.getInt(CommonConstants.COLUMN_INDEX_TWO));
				grn_Qty.setCBM(resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE));
				grn_Qty.setwLocId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				grn_Qty.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
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
		return grn_Qty;
	}


	@Override
	public void addGDNQty(GDN_Qty GDNQty) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_GDN_QTY));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, GDNQty.getGDNNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, GDNQty.getGRNNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, GDNQty.getItemId());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_FOUR, GDNQty.getQty());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, GDNQty.getSeqFeet());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX,GDNQty.getCBM());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, GDNQty.getRemark());
			
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
	public ArrayList<GDN_Qty> getGDNQTYView(String GDNNo) {
		
		ArrayList<GDN_Qty> GDNList = new ArrayList<>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GDNQTY_BY_GDNNO));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, GDNNo);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				GDN_Qty gdn_Qty = new GDN_Qty();
				gdn_Qty.setId(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
				gdn_Qty.setGDNNo(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				gdn_Qty.setGRNNo(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				gdn_Qty.setItemId(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				gdn_Qty.setQty(resultSet.getFloat(CommonConstants.COLUMN_INDEX_FIVE));
				gdn_Qty.setSeqFeet(resultSet.getInt(CommonConstants.COLUMN_INDEX_SIX));
				gdn_Qty.setCBM(resultSet.getInt(CommonConstants.COLUMN_INDEX_SEVEN));
				gdn_Qty.setRemark(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				GDNList.add(gdn_Qty);
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
		
		return GDNList;
	}


	@Override
	public void updateGDN(GDN gdn) {
		
		if(gdn != null) {
			
			try {
				
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_GDN));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, gdn.getVehicleNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, gdn.getContainerNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, gdn.getGDNNo());
				
				preparedStatement.executeUpdate();
				
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
		
	}

	@Override
	public GDN getGDNById(String GDNNo) {
		return actionGDN(GDNNo).get(0);
	}
	
	@Override
	public ArrayList<GDN> getGDNs() {
		return actionGDN(null);
	}
	

	public ArrayList<GDN> actionGDN(String GDNNo) {
		
		ArrayList<GDN> GDNList = new ArrayList<>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			if (GDNNo != null && !GDNNo.isEmpty()) {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_GDN_BY_GDNNO));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, GDNNo);
				
			}
			
			else {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_GDN));
				
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				GDN gdn = new GDN();
				gdn.setGDNNo(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				gdn.setVehicleNo(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				gdn.setContainerNo(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				gdn.setDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				gdn.setsTime(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				gdn.seteTime(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				gdn.setCusId(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				GDNList.add(gdn);
				
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
		
		return GDNList;
	}


	@Override
	public void requestDeleteGDN(DeleteReq deleteReq) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REQUEST_DELETE_GDN));
			connection.setAutoCommit(false);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, deleteReq.getCusName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, deleteReq.getNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, deleteReq.getReason());
			
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
	public void deleteGRN(String GRNNo) {				
		actionDeleteGRN("GRN",GRNNo);
	}


	@Override
	public void deleteGDN(String GDNNo) {
		actionDeleteGRN("GDN",GDNNo);
	}
	
	private void actionDeleteGRN(String Type , String No) {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			if(Type.equals("GRN")) {
				
				for(int i = 0; i < 2; i++) {
					if(i == 0) {
						preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_GRN_DEL_REQ));	
						preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, No);			
						preparedStatement.executeUpdate();
					}
					else if(i == 1) {
						preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_GRN));	
						preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, No);			
						preparedStatement.executeUpdate();
					}
				}
				
			}
			else if(Type.equals("GDN")) {
				
				for(int i = 0; i < 2; i++) {
					if(i == 0) {
						preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_GDN_DEL_REQ));	
						preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, No);			
						preparedStatement.executeUpdate();
					}
					else if(i == 1) {
						preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_GDN));
						preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, No);			
						preparedStatement.executeUpdate();
					}
				}
				
			}		
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
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
	public ArrayList<DeleteReq> showReqDeleteGRN() {
		
		return actionGetDeleteReq("GRN");
	}


	@Override
	public ArrayList<DeleteReq> showReqDeleteGDN() {
		
		return actionGetDeleteReq("GDN");
	}
	
	private ArrayList<DeleteReq> actionGetDeleteReq(String Type){
		
		ArrayList<DeleteReq> delReq = new ArrayList<>();
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();
			
			if (Type.equals("GRN")) {
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SHOW_REQUEST_DELETE_GRN));			
				
			}
			
			else if (Type.equals("GDN")){
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_SHOW_REQUEST_DELETE_GDN));
				
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				DeleteReq Req = new DeleteReq();
				Req.setId(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
				Req.setCusName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				Req.setNo(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				Req.setReason(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				delReq.add(Req);
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
		
		return delReq;
	}


	@Override
	public void dropDeleteReqGRN(String GRNNo) {
		
		actionDropDeleteReq(GRNNo, "GRN");
	}


	@Override
	public void dropDeleteReqGDN(String GDNNo) {
		
		actionDropDeleteReq(GDNNo, "GDN");
	}
	
	private void actionDropDeleteReq(String No,String Type) {
		
		try {
			
			connection = DBConnectionUtil.getDBConnection();

			if(Type.equals("GRN")) {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_GRN_DEL_REQ));	
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, No);			
				preparedStatement.executeUpdate();
			}
			
			else if(Type.equals("GDN")) {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_GDN_DEL_REQ));	
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, No);			
				preparedStatement.executeUpdate();				
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
		
	}


	@Override
	public void confirmItem(Item item) {
		
		try {

			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CONFIRM_ITEM));
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, item.getItemName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, item.getItemDes());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, item.getRemark());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, item.getPaymentMethod());
			preparedStatement.setFloat(CommonConstants.COLUMN_INDEX_FIVE, item.getPrice());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, item.getUom());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, item.getItemId());
			
			preparedStatement.executeUpdate();
			
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
	
}