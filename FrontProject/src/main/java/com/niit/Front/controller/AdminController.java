package com.niit.Front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController 
{

	@RequestMapping("/admin")
	public ModelAndView adminhome()
	{
	ModelAndView mvc=new ModelAndView("/admin/Admin");
	return mvc;
	}
	
	
	
}
