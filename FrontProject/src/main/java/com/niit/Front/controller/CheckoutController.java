/*package com.niit.Front.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.shopingbackend.backproject.DAO.CustomerDAO;
import com.niit.shopingbackend.backproject.model.Customer;

@Controller
public class CheckoutController 
{

	private final Logger logger = LoggerFactory.getLogger(CheckoutController.class);

	@Autowired
	private CustomerDAO customerDAO;

@RequestMapping("/Ord")
public String Order()
{
	return "order";
}
	
//	@RequestMapping("/order")
//	public String createOrder() {
//		logger.info("Starting createOrder method in CheckoutController");
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String username = auth.getName();
//		String loggedInUsername = username;
//    	Customer customer = customerDAO.getUserByUserName(loggedInUsername);
//		logger.info("Starting checkout Spring Web Flow...");
//		return "redirect:/order?userId=" + customer.getCustomerid();
//	}

	
}
*/