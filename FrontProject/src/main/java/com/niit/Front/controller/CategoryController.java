package com.niit.Front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shopingbackend.backproject.DAO.CategoryDAO;
import com.niit.shopingbackend.backproject.model.Category;


@Controller
public class CategoryController 

{
	//-----------------------Category -----------------//
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping("/cate")
	public String Cat(Model model)
	{
		model.addAttribute("categoryList",categoryDAO.getAllCategory());
		model.addAttribute("Category", new Category());
		return "category";
	}	
	
	
	@RequestMapping("/addCat")
	public String category (@ModelAttribute("Category") Category c, Model model)
	{
		if(c.getCategoryId()==null || c.getCategoryId().isEmpty())
		{
		if(categoryDAO.addCat(c))
	{
		model.addAttribute("msg", "The Data Save in Database");
	}
	else
	{
		model.addAttribute("msg","not correct");
	}
		}
		else
		{
          categoryDAO.update(c);
		}
	return "redirect:/cate";
	}

		
	@RequestMapping("/updateCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId") String categoryId, Model model)
	{
		model.addAttribute("Category",categoryDAO.getCategoryId(categoryId));
		model.addAttribute("categoryList",categoryDAO.getAllCategory());
		return "category";
				
	}
	
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") String categoryId, Model model)
	{
		categoryDAO.deleteCat(categoryId);
		return "redirect:/cate";
	}
	
	
	
}
