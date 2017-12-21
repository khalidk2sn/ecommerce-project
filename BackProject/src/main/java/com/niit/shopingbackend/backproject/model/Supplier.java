package com.niit.shopingbackend.backproject.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier implements Serializable
{
	
	private static final long serialVersionUID = -3692513996115183800L;
	
	@Id
	private String supplierId;
	@OneToMany(mappedBy="supplierId",fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private Set<Product>product;
	
	
	@Column(unique=true)
	private String suppliername;
	private String suppliercity;
	
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSuppliercity() {
		return suppliercity;
	}
	public void setSuppliercity(String suppliercity) {
		this.suppliercity = suppliercity;
	}
	
		
}
