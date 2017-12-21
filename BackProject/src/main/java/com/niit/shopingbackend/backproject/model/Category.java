package com.niit.shopingbackend.backproject.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.stereotype.Component;


@Entity
@Component
public class Category implements Serializable
{
	private static final long serialVersionUID = -3692513996115183800L;

	@Id
	private String categoryId;
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	private Set<Product>product;
	
	@Column(unique=true)
	private String categoryname;
	private String categorydescription;
	 
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydescription() {
		return categorydescription;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	
}
