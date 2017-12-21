package com.niit.shopingbackend.backproject.model;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product implements Serializable
{
	private static final long serialVersionUID = -3692513996115183800L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@Column(unique=true)
	private String productname;
	
	private String productdescriptionfield1;
	private String productdescriptionfield2;
	private String productdescriptionfield3;
	
	@Transient
	private MultipartFile image;
	
	private String supplierId;
	@ManyToOne
	@JoinColumn(name="supplierId",insertable=false,nullable=false,updatable=false)
	Supplier supplier;

	
	private String categoryId;
	@ManyToOne
	@JoinColumn(name="categoryId",insertable=false,nullable=false,updatable=false)
	Category category;

	 @Column(name = "Price")
	private long productprice;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public long getProductprice() {
		return productprice;
	}
	public void setProductprice(long productprice) {
		this.productprice = productprice;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdescriptionfield1() {
		return productdescriptionfield1;
	}
	public void setProductdescription(String productdescriptionfield1) {
		this.productdescriptionfield1 = productdescriptionfield1;
	}
	
	public String getProductdescriptionfield2() {
		return productdescriptionfield2;
	}
	public void setProductdescriptionfield2(String productdescriptionfield2) {
		this.productdescriptionfield2 = productdescriptionfield2;
	}
	public String getProductdescriptionfield3() {
		return productdescriptionfield3;
	}
	public void setProductdescriptionfield3(String productdescriptionfield3) {
		this.productdescriptionfield3 = productdescriptionfield3;
	}
	public void setProductdescriptionfield1(String productdescriptionfield1) {
		this.productdescriptionfield1 = productdescriptionfield1;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
