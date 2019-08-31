package com.wms.model;

public class Customer {
	
	private String CustomerId;
	private String CusName;
	private String Address;
	private String Email;
	private String MobileNo;
	private boolean PayMethod;
	private String CusRef;
	
	public Customer() { }

	public Customer(String customerId, String cusName, String address, String email, String mobileNo, boolean payMethod,
			String cusRef) {
		CustomerId = customerId;
		CusName = cusName;
		Address = address;
		Email = email;
		MobileNo = mobileNo;
		PayMethod = payMethod;
		CusRef = cusRef;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getCusName() {
		return CusName;
	}

	public void setCusName(String cusName) {
		CusName = cusName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

	public boolean isPayMethod() {
		return PayMethod;
	}

	public void setPayMethod(boolean payMethod) {
		PayMethod = payMethod;
	}

	public String getCusRef() {
		return CusRef;
	}

	public void setCusRef(String cusRef) {
		CusRef = cusRef;
	}
	
	
}
