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
import org.hibernate.annotations.UpdateTimestamp;


/**
 * The persistent class for the IANS_CITY database table.
 * 
 */
@Entity
@Table(name="IANS_CITY")
@NamedQuery(name="IansCity.findAll", query="SELECT i FROM IansCity i")
public class IansCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CITY_ID")
	private int cityId;

	@Column(name="CITY_CODE")
	private String cityCode;

	@Column(name="CITY_NAME")
	private String cityName;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="CREATED_AT")
	private Date createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name="UPDATED_AT")
	private Date updatedAt;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to IansState
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="STATE_ID")
	private IansState iansState;

	/*
	 * //bi-directional many-to-one association to IansCustomer
	 * 
	 * @OneToMany(mappedBy="iansCity") private List<IansCustomer> iansCustomers;
	 */

	public IansCity() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public IansState getIansState() {
		return this.iansState;
	}

	public void setIansState(IansState iansState) {
		this.iansState = iansState;
	}

	/*
	 * public List<IansCustomer> getIansCustomers() { return this.iansCustomers; }
	 * 
	 * public void setIansCustomers(List<IansCustomer> iansCustomers) {
	 * this.iansCustomers = iansCustomers; }
	 * 
	 * public IansCustomer addIansCustomer(IansCustomer iansCustomer) {
	 * getIansCustomers().add(iansCustomer); iansCustomer.setIansCity(this);
	 * 
	 * return iansCustomer; }
	 * 
	 * public IansCustomer removeIansCustomer(IansCustomer iansCustomer) {
	 * getIansCustomers().remove(iansCustomer); iansCustomer.setIansCity(null);
	 * 
	 * return iansCustomer; }
	 */

}