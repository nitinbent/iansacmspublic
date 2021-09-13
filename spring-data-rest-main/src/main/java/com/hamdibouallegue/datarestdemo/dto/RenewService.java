package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;

public class RenewService implements Serializable{

	/**
	 *  Serial Version ID
	 */
	private static final long serialVersionUID = 9184335940577795376L;

	private Integer invoiceId;
	private String customerName;
	private Integer customerId;
	private String createdBy;
	private Float totalAmount;
	private Float totalCGSTAmount;
	private Float totalSGSTAmount;
	private Float totalIGSTAmount;
	private String subscriptionDate;
	private String serviceStartDate;
	private String serviceEndDate;
	private Integer serviceId;
	private String subscriptionValue;
	private String serviceDescription;
	
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
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
	public String getSubscriptionValue() {
		return subscriptionValue;
	}
	public void setSubscriptionValue(String subscriptionValue) {
		this.subscriptionValue = subscriptionValue;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	
}
