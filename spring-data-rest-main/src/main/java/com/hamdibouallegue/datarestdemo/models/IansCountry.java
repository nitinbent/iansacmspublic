package com.hamdibouallegue.datarestdemo.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * The persistent class for the IANS_COUNTRY database table.
 * 
 */
@Entity(name="IANS_COUNTRY")
//@Table(name="IANS_COUNTRY")
//@NamedQuery(name="IansCountry.findAll", query="SELECT i FROM IansCountry i")
public class IansCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	private int countryId;

	@Column(name="COUNTRY_CODE")
	private String countryCode;

	@Column(name="COUNTRY_NAME")
	private String countryName;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name="CREATED_AT")
	private Date createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;

	private String currency;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_AT")
	@UpdateTimestamp
	private Date updatedAt;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to IansState
	//@OneToMany(mappedBy="iansCountry",fetch = FetchType.LAZY)
	//private List<IansState> iansStates;

	public IansCountry() {
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	
	 // public List<IansState> getIansStates() { return this.iansStates; }
	  
		/*
		 * public void setIansStates(List<IansState> iansStates) { this.iansStates =
		 * iansStates; }
		 */
	/*
	 * public IansState addIansState(IansState iansState) {
	 * getIansStates().add(iansState); iansState.setIansCountry(this);
	 * 
	 * return iansState; }
	 * 
	 * public IansState removeIansState(IansState iansState) {
	 * getIansStates().remove(iansState); iansState.setIansCountry(null);
	 * 
	 * return iansState; }
	 */

}