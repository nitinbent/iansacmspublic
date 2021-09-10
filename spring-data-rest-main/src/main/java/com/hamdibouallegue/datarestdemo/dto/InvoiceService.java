package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;

public class InvoiceService implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 4534267206303293355L;

	private Integer serviceId;
	private Float serviceAmount;
	private String serviceDescription;
    private Float cgstAmount;
    private Float sgstAmount;
    private Float igstAmount;
    private String createdBy;
    private String serviceStartDate;
    private String serviceEndDate;
    
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Float getServiceAmount() {
		return serviceAmount;
	}
	public void setServiceAmount(Float serviceAmount) {
		this.serviceAmount = serviceAmount;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getServiceStartDate() {
		return serviceStartDate;
	}
	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}
	public String getServiceEndDate() {
		return serviceEndDate;
	}
	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}
	public Float getCgstAmount() {
		return cgstAmount;
	}
	public void setCgstAmount(Float cgstAmount) {
		this.cgstAmount = cgstAmount;
	}
	public Float getSgstAmount() {
		return sgstAmount;
	}
	public void setSgstAmount(Float sgstAmount) {
		this.sgstAmount = sgstAmount;
	}
	public Float getIgstAmount() {
		return igstAmount;
	}
	public void setIgstAmount(Float igstAmount) {
		this.igstAmount = igstAmount;
	}
	
	
}
