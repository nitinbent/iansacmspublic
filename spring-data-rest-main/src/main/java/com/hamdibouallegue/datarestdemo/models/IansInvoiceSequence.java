package com.hamdibouallegue.datarestdemo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="IANS_INVOICE_SEQUENCE")
public class IansInvoiceSequence implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 670618753723091409L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="INVOICE_SEQUENCE_ID")
	private Integer invoiceId;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_AT")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date createdAt;

	@Column(name="CREATED_BY")
	private String createdBy;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_AT")
	@UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date updatedAt;

	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Column(name="SEQUENCE_START_VALUE")
	private Integer sequenceStartValue;
	
	@Column(name="SEQUENCE_END_VALUE")
	private Integer sequenceEndValue;
	
	@Column(name="SEQUENCE_TYPE")
	private String sequenceType;
	
	@Column(name="SEQUENCE_PREFIX")
	private String sequencePrefix;
	
	@Column(name="YEAR_VALUE")
	private String yearValue;
	
	@Column(name="MONTH_VALUE")
	private String monthValue;

	
	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public String getYearValue() {
		return yearValue;
	}

	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}

	public String getMonthValue() {
		return monthValue;
	}

	public void setMonthValue(String monthValue) {
		this.monthValue = monthValue;
	}

	public String getSequencePrefix() {
		return sequencePrefix;
	}

	public void setSequencePrefix(String sequencePrefix) {
		this.sequencePrefix = sequencePrefix;
	}

	public Integer getSequenceStartValue() {
		return sequenceStartValue;
	}

	public void setSequenceStartValue(Integer sequenceStartValue) {
		this.sequenceStartValue = sequenceStartValue;
	}

	public Integer getSequenceEndValue() {
		return sequenceEndValue;
	}

	public void setSequenceEndValue(Integer sequenceEndValue) {
		this.sequenceEndValue = sequenceEndValue;
	}

	public String getSequenceType() {
		return sequenceType;
	}

	public void setSequenceType(String sequenceType) {
		this.sequenceType = sequenceType;
	}
	
	
	

}
