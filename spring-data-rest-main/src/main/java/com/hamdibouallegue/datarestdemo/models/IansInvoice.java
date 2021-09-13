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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * The persistent class for the IANS_INVOICES database table.
 * 
 */
@Entity
@Table(name="IANS_INVOICES")
@NamedQuery(name="IansInvoice.findAll", query="SELECT i FROM IansInvoice i")
public class IansInvoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INVOICE_ID")
	private int invoiceId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	@CreationTimestamp
	private Date createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CGST_AMOUNT")
	private Float cgstAmount;
	
	@Column(name="SGST_AMOUNT")
	private Float sgstAmount;
	
	@Column(name="IGST_AMOUNT")
	private Float igstAmount;

	@Column(name="INVOICE_NO")
	private String invoiceNo;

	@Column(name="IS_PAID")
	private String isPaid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="PAYMENT_DATE")
	private Date paymentDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="SUBCRIPTION_DATE")
	private Date subscriptionDate;
	
	@Column(name="SERVICE_START_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date serviceStartDate;

	@Column(name="SERVICE_END_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date serviceEndDate;
	

	@Column(name="PAYMENT_GWAY_TRANSACTION_ID")
	private String paymentGwayTransactionId;

	@Column(name="PAYMENT_LINK")
	private String paymentLink;

	@Column(name="TOTAL_AMOUNT")
	private float totalAmount;
	
	
	@Column(name="SERVICE_DESCRIPTION")
	private String serviceDescription;
	
	@Column(name="SERVICE_ID")
	private Integer iansServiceId;
	
	@Column(name="INVOICE_STATUS")
	private String invoiceStatus;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="SAC_CODE")
	private String sacCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_ID",insertable = false, updatable = false)
	private IansCustomer iansCustomer;

	//bi-directional many-to-one association to IansCustomer
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="CUSTOMER_ID") private IansCustomer iansCustomer;
	 */
	
	@Column(name="CUSTOMER_ID")
	private Integer iansCustomeId;

	//bi-directional many-to-one association to IansInvoiceService
	/*
	 * @OneToMany(mappedBy="iansInvoice") private List<IansInvoiceService>
	 * iansInvoiceServices;
	 */

	public IansInvoice() {
	}

	public int getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
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


	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentGwayTransactionId() {
		return this.paymentGwayTransactionId;
	}

	public void setPaymentGwayTransactionId(String paymentGwayTransactionId) {
		this.paymentGwayTransactionId = paymentGwayTransactionId;
	}

	public String getPaymentLink() {
		return this.paymentLink;
	}

	public void setPaymentLink(String paymentLink) {
		this.paymentLink = paymentLink;
	}

	public float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Integer getIansCustomeId() {
		return iansCustomeId;
	}

	public void setIansCustomeId(Integer iansCustomeId) {
		this.iansCustomeId = iansCustomeId;
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

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Date getServiceStartDate() {
		return serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Integer getIansServiceId() {
		return iansServiceId;
	}

	public void setIansServiceId(Integer iansServiceId) {
		this.iansServiceId = iansServiceId;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public IansCustomer getIansCustomer() {
		return iansCustomer;
	}

	public void setIansCustomer(IansCustomer iansCustomer) {
		this.iansCustomer = iansCustomer;
	}

	public String getSacCode() {
		return sacCode;
	}

	public void setSacCode(String sacCode) {
		this.sacCode = sacCode;
	}

	/*
	 * public List<IansInvoiceService> getIansInvoiceServices() { return
	 * this.iansInvoiceServices; }
	 * 
	 * public void setIansInvoiceServices(List<IansInvoiceService>
	 * iansInvoiceServices) { this.iansInvoiceServices = iansInvoiceServices; }
	 */
	/*
	 * public IansInvoiceService addIansInvoiceService(IansInvoiceService
	 * iansInvoiceService) { getIansInvoiceServices().add(iansInvoiceService);
	 * iansInvoiceService.setIansInvoice(this);
	 * 
	 * return iansInvoiceService; }
	 * 
	 * public IansInvoiceService removeIansInvoiceService(IansInvoiceService
	 * iansInvoiceService) { getIansInvoiceServices().remove(iansInvoiceService);
	 * iansInvoiceService.setIansInvoice(null);
	 * 
	 * return iansInvoiceService; }
	 */

}