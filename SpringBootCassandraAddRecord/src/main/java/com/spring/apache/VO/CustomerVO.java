package com.spring.apache.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@Table(value = "customer_Details")
@JsonInclude(value = Include.NON_NULL)
public class CustomerVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey(value = "customer_Id")
	private UUID customerId;
	@Column(value = "mobile_number")
	private String mobNumber;
	@Column(value = "Email")
	private String email;
	@Column(value = "first_name")
	private String firstName;
	@Column(value = "last_name")
	private String lastName;
	@Column(value = "ssn")
	private String ssn;

	public CustomerVO() {
		super();
	}

	public CustomerVO(UUID customerId, String mobNumber, String email, String firstName, String lastName, String ssn) {
		super();
		this.customerId = customerId;
		this.mobNumber = mobNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "CustomerVO [customerId=" + customerId + ", mobNumber=" + mobNumber + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", ssn=" + ssn + "]";
	}

}
