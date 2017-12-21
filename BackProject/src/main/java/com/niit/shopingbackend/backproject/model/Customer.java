package com.niit.shopingbackend.backproject.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Customer implements Serializable 
{
	private static final long serialVersionUID = 3607187884251752653L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;


	@Column
	private String name;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String username;

	private String password;

	@Column(unique = true)
	private String mobileno;

	@OneToOne
	@JoinColumn(name = "BILLINGADD_ID")
	private BillingAddress billingAddress;

	@OneToOne
	@JoinColumn(name = "SHIPPINGADD_ID")
	private ShippingAddress shippingAddress;

	@OneToOne
	private User user;



	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
