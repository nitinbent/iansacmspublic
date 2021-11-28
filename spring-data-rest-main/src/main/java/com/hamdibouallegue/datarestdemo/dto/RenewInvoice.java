package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;
import java.util.List;

public class RenewInvoice implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = -6727328158314281259L;
	
	private List<RenewService> renewServices;
	
	private String startInvoiceNo;
	private String endInvoiceNo;

	public List<RenewService> getRenewServices() {
		return renewServices;
	}

	public void setRenewServices(List<RenewService> renewServices) {
		this.renewServices = renewServices;
	}

	public String getStartInvoiceNo() {
		return startInvoiceNo;
	}

	public void setStartInvoiceNo(String startInvoiceNo) {
		this.startInvoiceNo = startInvoiceNo;
	}

	public String getEndInvoiceNo() {
		return endInvoiceNo;
	}

	public void setEndInvoiceNo(String endInvoiceNo) {
		this.endInvoiceNo = endInvoiceNo;
	}

}
