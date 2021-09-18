package com.hamdibouallegue.datarestdemo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * The persistent class for the IANS_CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="IANS_CUSTOMERS")
//@NamedQuery(name="IansCustomer.findAll", query="SELECT i FROM IansCustomer i")
public class IansCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private int customerId;

	@Column(name="COMPANY_ADDRESS")
	private String companyAddress;

	@Column(name="COMPANY_EMAIL_ID")
	private String companyEmailId;

	@Column(name="COMPANY_NAME")
	private String companyName;

	@Column(name="COMPANY_PHONE_NO")
	private String companyPhoneNo;
	
	@Column(name="LOGIN_ID")
	private String loginId;
	
	@Column(name="HEADOFFICE_ADDRESS")
	private String headOfficeAddress;

	@Column(name="HEADOFFICE_EMAIL_ID")
	private String headOfficeEmailId;

	@Column(name="HEADOFFICE_PHONE_NO")
	private String headOfficePhoneNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	@CreationTimestamp
	private Date createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CUSTOMER_NAME")
	private String customerName;

	private String description;

	@Column(name="GST_NO")
	private String gstNo;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="IS_GST_ENABLED")
	private String isGstEnabled;

	@Column(name="PRIMARY_CONTACT_EMAIL")
	private String primaryContactEmail;

	@Column(name="PRIMARY_CONTACT_MOBILENO")
	private String primaryContactMobileno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_AT")
	@UpdateTimestamp
	private Date updatedAt;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to IansCity
	@ManyToOne
	@JoinColumn(name="CITY_ID")
	private IansCity iansCity;
	

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SUBSCRIPTION_ID")
	private IansSubscription iansSubscription;

	/*
	 * //bi-directional many-to-one association to IansInvoice
	 * 
	 * @OneToMany(mappedBy="iansCustomer") private List<IansInvoice> iansInvoices;
	 */

	public IansCustomer() {
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyEmailId() {
		return this.companyEmailId;
	}

	public void setCompanyEmailId(String companyEmailId) {
		this.companyEmailId = companyEmailId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhoneNo() {
		return this.companyPhoneNo;
	}

	public void setCompanyPhoneNo(String companyPhoneNo) {
		this.companyPhoneNo = companyPhoneNo;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGstNo() {
		return this.gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getIsGstEnabled() {
		return this.isGstEnabled;
	}

	public void setIsGstEnabled(String isGstEnabled) {
		this.isGstEnabled = isGstEnabled;
	}

	public String getPrimaryContactEmail() {
		return this.primaryContactEmail;
	}

	public void setPrimaryContactEmail(String primaryContactEmail) {
		this.primaryContactEmail = primaryContactEmail;
	}

	public String getPrimaryContactMobileno() {
		return this.primaryContactMobileno;
	}

	public void setPrimaryContactMobileno(String primaryContactMobileno) {
		this.primaryContactMobileno = primaryContactMobileno;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public IansCity getIansCity() {
		return this.iansCity;
	}

	public void setIansCity(IansCity iansCity) {
		this.iansCity = iansCity;
	}

	/*
	 * public List<IansInvoice> getIansInvoices() { return this.iansInvoices; }
	 * 
	 * public void setIansInvoices(List<IansInvoice> iansInvoices) {
	 * this.iansInvoices = iansInvoices; }
	 */

	/*
	 * public IansInvoice addIansInvoice(IansInvoice iansInvoice) {
	 * getIansInvoices().add(iansInvoice); iansInvoice.setIansCustomer(this);
	 * 
	 * return iansInvoice; }
	 * 
	 * public IansInvoice removeIansInvoice(IansInvoice iansInvoice) {
	 * getIansInvoices().remove(iansInvoice); iansInvoice.setIansCustomer(null);
	 * 
	 * return iansInvoice; }
	 */

	public String getHeadOfficeAddress() {
		return headOfficeAddress;
	}

	public void setHeadOfficeAddress(String headOfficeAddress) {
		this.headOfficeAddress = headOfficeAddress;
	}

	public String getHeadOfficeEmailId() {
		return headOfficeEmailId;
	}

	public void setHeadOfficeEmailId(String headOfficeEmailId) {
		this.headOfficeEmailId = headOfficeEmailId;
	}

	public String getHeadOfficePhoneNo() {
		return headOfficePhoneNo;
	}

	public void setHeadOfficePhoneNo(String headOfficePhoneNo) {
		this.headOfficePhoneNo = headOfficePhoneNo;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public IansSubscription getIansSubscription() {
		return iansSubscription;
	}

	public void setIansSubscription(IansSubscription iansSubscription) {
		this.iansSubscription = iansSubscription;
	}

	

}