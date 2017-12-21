package com.niit.Front.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;



import com.niit.shopingbackend.backproject.DAO.UserDAO;

import com.niit.shopingbackend.backproject.model.User;



@Controller

public class UserController 

{



	@Autowired

	private UserDAO userDAO;

	

	

	@RequestMapping("/signup")

	public String sign(Model model) 

	{

		model.addAttribute("userList",userDAO.getAllUser());

		model.addAttribute("user",new User());

		return "signup";

	}

	

	@RequestMapping("/addUser")

	public String user(@ModelAttribute("user") User u, Model model)

	{

		System.out.println("In User Cntroller");

		if (userDAO.addUser(u))

		{

			model.addAttribute("msg", "Data SAVE in Database");

		    return "login";

		}

		else {

			model.addAttribute("msg", "Data not save in database");

			return "redirect:/signup";

		}

		

}

}


