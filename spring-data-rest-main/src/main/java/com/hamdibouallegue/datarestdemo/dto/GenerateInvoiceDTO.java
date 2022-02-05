package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;

public class GenerateInvoiceDTO implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 5267814646899219602L;
	
	private Integer invoiceId;
	private String invoiceNo;
	private Integer customerId;
	private String createdBy;
	private Float totalAmount;
	private Float totalCGSTAmount;
	private Float totalSGSTAmount;
	private Float totalIGSTAmount;
	private String subscriptionStartDate;
	private String subscriptionDate;
	private String startDate;
	private String endDate;
	private Integer serviceId;
	private String serviceDescription;
	private String sacCode;
	
	private String companyName;
	
	private String headOfficeAddressLine1;
	private String headOfficeAddressLine2;
	private String headOfficeAddressLine3;
	private String headOfficeAddressLine4;
	private String headOfficeAddressLine5;
	private String headOfficeAddressLine6;
	
	private String gstNo;
	private String invoiceDate;

	
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getSubscriptionStartDate() {
		return subscriptionStartDate;
	}
	public void setSubscriptionStartDate(String subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}
	public String getSacCode() {
		return sacCode;
	}
	public void setSacCode(String sacCode) {
		this.sacCode = sacCode;
	}
	
	public String getHeadOfficeAddressLine1() {
		return headOfficeAddressLine1;
	}
	public void setHeadOfficeAddressLine1(String headOfficeAddressLine1) {
		this.headOfficeAddressLine1 = headOfficeAddressLine1;
	}
	public String getHeadOfficeAddressLine2() {
		return headOfficeAddressLine2;
	}
	public void setHeadOfficeAddressLine2(String headOfficeAddressLine2) {
		this.headOfficeAddressLine2 = headOfficeAddressLine2;
	}
	public String getHeadOfficeAddressLine3() {
		return headOfficeAddressLine3;
	}
	public void setHeadOfficeAddressLine3(String headOfficeAddressLine3) {
		this.headOfficeAddressLine3 = headOfficeAddressLine3;
	}
	public String getHeadOfficeAddressLine4() {
		return headOfficeAddressLine4;
	}
	public void setHeadOfficeAddressLine4(String headOfficeAddressLine4) {
		this.headOfficeAddressLine4 = headOfficeAddressLine4;
	}
	public String getHeadOfficeAddressLine5() {
		return headOfficeAddressLine5;
	}
	public void setHeadOfficeAddressLine5(String headOfficeAddressLine5) {
		this.headOfficeAddressLine5 = headOfficeAddressLine5;
	}
	public String getHeadOfficeAddressLine6() {
		return headOfficeAddressLine6;
	}
	public void setHeadOfficeAddressLine6(String headOfficeAddressLine6) {
		this.headOfficeAddressLine6 = headOfficeAddressLine6;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

}
