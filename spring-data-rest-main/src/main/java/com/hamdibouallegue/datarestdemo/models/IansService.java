package com.hamdibouallegue.datarestdemo.models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the IANS_SERVICES database table.
 * 
 */
@Entity
@Table(name="IANS_SERVICES")
@NamedQuery(name="IansService.findAll", query="SELECT i FROM IansService i")
public class IansService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SERVICE_ID")
	private int serviceId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	@CreationTimestamp
	private Date createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="SAC_CODE")
	private String sacCode;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="SERVICE_CODE")
	private String serviceCode;

	@Column(name="SERVICE_DESCRIPTION")
	private String serviceDescription;

	@Column(name="SERVICE_NAME")
	private String serviceName;

	@Column(name="SERVICE_TYPE")
	private String serviceType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_AT")
	@UpdateTimestamp
	private Date updatedAt;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to IansInvoiceService
	/*
	 * @OneToMany(mappedBy="iansService") private List<IansInvoiceService>
	 * iansInvoiceServices;
	 */

	public IansService() {
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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


	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getServiceCode() {
		return this.serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceDescription() {
		return this.serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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
	 * iansInvoiceService.setIansService(this);
	 * 
	 * return iansInvoiceService; }
	 * 
	 * public IansInvoiceService removeIansInvoiceService(IansInvoiceService
	 * iansInvoiceService) { getIansInvoiceServices().remove(iansInvoiceService);
	 * iansInvoiceService.setIansService(null);
	 * 
	 * return iansInvoiceService; }
	 */
}