package com.niit.shopingbackend.backproject.DAO;

import java.util.List;

import com.niit.shopingbackend.backproject.model.Category;


public interface CategoryDAO
{

    boolean addCat(Category c);
	List<Category>getAllCategory();

	public boolean update(Category c);
	public boolean deleteCat(String id);
	public Category getCategoryId(String id);
}
