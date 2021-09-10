package com.hamdibouallegue.datarestdemo.models;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the IANS_STATE database table.
 * 
 */
@Entity
@Table(name="IANS_STATE")
@NamedQuery(name="IansState.findAll", query="SELECT i FROM IansState i")
public class IansState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STATE_ID")
	private int stateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_AT")
	@CreationTimestamp
	private Date createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="IS_ACTIVE")
	private String isActive;

	@Column(name="STATE_CODE")
	private String stateCode;

	@Column(name="STATE_NAME")
	private String stateName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_AT")
	@UpdateTimestamp
	private Date updatedAt;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to IansCity
	/*
	 * @OneToMany(mappedBy="iansState") private List<IansCity> iansCities;
	 */

	//bi-directional many-to-one association to IansCountry
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COUNTRY_ID")
	private IansCountry iansCountry;

	public IansState() {
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
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

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
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

	/*
	 * public List<IansCity> getIansCities() { return this.iansCities; }
	 * 
	 * public void setIansCities(List<IansCity> iansCities) { this.iansCities =
	 * iansCities; }
	 */
	/*
	 * public IansCity addIansCity(IansCity iansCity) {
	 * getIansCities().add(iansCity); iansCity.setIansState(this);
	 * 
	 * return iansCity; }
	 * 
	 * public IansCity removeIansCity(IansCity iansCity) {
	 * getIansCities().remove(iansCity); iansCity.setIansState(null);
	 * 
	 * return iansCity; }
	 */

	public IansCountry getIansCountry() {
		return this.iansCountry;
	}

	public void setIansCountry(IansCountry iansCountry) {
		this.iansCountry = iansCountry;
	}

}