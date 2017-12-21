package com.niit.Front.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shopingbackend.backproject.DAO.CartDAO;
import com.niit.shopingbackend.backproject.DAO.ProductDAO;
import com.niit.shopingbackend.backproject.model.Cart;
import com.niit.shopingbackend.backproject.model.Product;

@Controller
public class CartController 
{
	private final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private HttpSession session;

	
	@RequestMapping("/Cart")
	public String getCart() 
	{
		logger.info("Starting getCart method in CartController");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		String loggedInUsername = username;
		session.setAttribute("numberProducts", cartDAO.getNumberOfProducts(loggedInUsername));
		session.setAttribute("cartList", cartDAO.getCartList(loggedInUsername));
		session.setAttribute("totalAmount", cartDAO.getTotalAmount(loggedInUsername));
		return "Cart";
	}

	
	@RequestMapping(value="/addCart/{productId}" , method=RequestMethod.GET)
	public String addToCart(@PathVariable("productId") int productId, RedirectAttributes redirect, Model model) {
		logger.info("Starting addtocart method in CartController");
		System.out.println("add to cart");
		try 
		{
			Cart cart = new Cart();
			Product product = productDAO.getProductByID(productId);
			cart.setProductName(product.getProductname());
			cart.setPrice(product.getProductprice());
			cart.setDateAdded(new Date());
			String loggedInUsername = null;
			if (loggedInUsername == null) 
			{
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String username = auth.getName();
				loggedInUsername = username;
            }
			cart.setUsername(loggedInUsername);
			cart.setStatus("NEW");
			Cart existCart = cartDAO.getCartByUsername(loggedInUsername, cart.getProductName());
			if (existCart != null) 
            {
			    int currentQuantity = cartDAO.getQuantity(loggedInUsername, cart.getProductName());
				cart.setId(existCart.getId());
				cart.setQuantity(currentQuantity + 1);
				boolean flag = cartDAO.update(cart);
				if (flag) {

					redirect.addFlashAttribute("success", product.getProductname() + " " + "Successfully added to cart!");
					session.setAttribute("numberProducts", cartDAO.getNumberOfProducts(loggedInUsername));
					return "redirect:/Cart";

				} else {
					redirect.addFlashAttribute("error", "Failed to add product to cart!");
					return "redirect:/AllProductCategory";
				}
			}
            else 
            {
				cart.setQuantity(1);
				boolean flag = cartDAO.save(cart);

				if (flag) {

					redirect.addFlashAttribute("success", product.getProductname() + " " + "Successfully added to cart!");
					session.setAttribute("numberProducts", cartDAO.getNumberOfProducts(loggedInUsername));
					return "redirect:/Cart";

				} else {
					redirect.addFlashAttribute("error", "Failed to add product to cart!");
					return "redirect:/AllProductCategory";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured " + e);
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "Error";
		}
	}
	
	
	

	@RequestMapping("/removeCart/{id}")
	public ModelAndView removeCart(@PathVariable("id") int productId)throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/index");
		boolean b=this.cartDAO.delete(productId);
		if(b)
		{
			   session.setAttribute("total",cartDAO);
		}
	    return mv;
	}	



	
	
	
	
	@RequestMapping("/clearCart")
	public String clearCart(RedirectAttributes redirect, Model model) {
		logger.info("Starting clearCart method in CartController");
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			int flag = cartDAO.clearCart(username);

			if (flag >= 1) {
				redirect.addFlashAttribute("success", "All Items removed successfully.");
				return "redirect:/index";
			} else {
				redirect.addFlashAttribute("error", "Failed to clear cart!");
				return "redirect:/index";
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured " + e);
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "Error";
		}
	}


}
