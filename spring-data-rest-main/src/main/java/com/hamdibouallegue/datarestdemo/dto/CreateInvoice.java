package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;

public class CreateInvoice implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = -1038859659527077400L;
	
	private Integer customerId;
	private String customerName;
	private String createdBy;
	private Float totalAmount;
	private Float totalCGSTAmount;
	private Float totalSGSTAmount;
	private Float totalIGSTAmount;
	private String subscriptionDate;
	private String serviceStartDate;
	private String serviceEndDate;
	private Integer serviceId;
	private String sacCode;
	private String serviceDescription;
	private String invoiceNo;

	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Float getTotalCGSTAmount() {
		return totalCGSTAmount;
	}
	public void setTotalCGSTAmount(Float totalCGSTAmount) {
		this.totalCGSTAmount = totalCGSTAmount;
	}
	public Float getTotalSGSTAmount() {
		return totalSGSTAmount;
	}
	public void setTotalSGSTAmount(Float totalSGSTAmount) {
		this.totalSGSTAmount = totalSGSTAmount;
	}
	public Float getTotalIGSTAmount() {
		return totalIGSTAmount;
	}
	public void setTotalIGSTAmount(Float totalIGSTAmount) {
		this.totalIGSTAmount = totalIGSTAmount;
	}
	public String getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
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
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSacCode() {
		return sacCode;
	}
	public void setSacCode(String sacCode) {
		this.sacCode = sacCode;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

}
