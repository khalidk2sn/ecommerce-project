package com.niit.shopingbackend.backproject.DAO;

import java.util.List;

import com.niit.shopingbackend.backproject.model.Product;



public interface ProductDAO 
{

	boolean addPro(Product p);
	
	List<Product>getAllProduct();

	public boolean update(Product p);
	
	public boolean deletePro(int id);
	
	public Product getProductId(int id);
	
	List<Product> getProductByCategory(String categoryId);
	
	public Product getProductByName(String name); // get() product by name

	public List<Product> viewByStatus(String status);


	public Product getProductByID(int id); 

	
}
