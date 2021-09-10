package com.hamdibouallegue.datarestdemo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="IANS_SUBSCRIPTION")
//@NamedQuery(name="IansSubscription.findAll", query="SELECT i FROM IANS_SUBSCRIPTION i")
public class IansSubscription implements Serializable {

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 6532963852423602172L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SUBSCRIPTION_ID")
	private int subscriptionId;
	
	@Column(name="SUBSCRIPTION_VALUE")
	private String subscriptionValue;
	
	@Column(name="DISPLAY_NAME")
	private String displayName;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getSubscriptionValue() {
		return subscriptionValue;
	}

	public void setSubscriptionValue(String subscriptionValue) {
		this.subscriptionValue = subscriptionValue;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	

}
