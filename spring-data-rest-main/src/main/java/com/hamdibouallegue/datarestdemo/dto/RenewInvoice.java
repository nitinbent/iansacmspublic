package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;
import java.util.List;

public class RenewInvoice implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = -6727328158314281259L;
	
	private List<RenewService> renewServices;

	public List<RenewService> getRenewServices() {
		return renewServices;
	}

	public void setRenewServices(List<RenewService> renewServices) {
		this.renewServices = renewServices;
	}

}
