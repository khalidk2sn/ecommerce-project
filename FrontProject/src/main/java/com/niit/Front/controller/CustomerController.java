package com.niit.Front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shopingbackend.backproject.DAO.CategoryDAO;
import com.niit.shopingbackend.backproject.DAO.CustomerDAO;
import com.niit.shopingbackend.backproject.DAO.ProductDAO;
import com.niit.shopingbackend.backproject.DAO.SupplierDAO;
import com.niit.shopingbackend.backproject.model.BillingAddress;
import com.niit.shopingbackend.backproject.model.Customer;
import com.niit.shopingbackend.backproject.model.Product;
import com.niit.shopingbackend.backproject.model.ShippingAddress;

@Controller
public class CustomerController 
{
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);


	@Autowired
	private CustomerDAO customerDAO;


	@Autowired
	private HttpSession session;

	

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String validate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("starting of the method validate in CustomerController");

		session = request.getSession(true);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		session.setAttribute("loggedInUser", true);
		session.setAttribute("loggedInUsername", customerDAO.getUserByUserName(username));
		session.setAttribute("loggedInName", customerDAO.getUserByUserName(username).getName());

		String role = customerDAO.getUserRole(username);

		if (role.equals("ROLE_ADMIN")) {
			session.setAttribute("isAdmin", true);
			return "redirect:/admin/dashboard";
		} else {
			session.setAttribute("isAdmin", false);
			/*
			 * mv.addObject("myCart", myCart); // Fetch the myCart list based on
			 * user ID List<MyCart> mycartList = mycartDAO.list(userID);
			 * mv.addObject("cartList", mycartList); mv.addObject("cartSize",
			 * mycartList.size()); mv.addObject("totalAmount",
			 * mycartDAO.getTotalAmount(userID));
			 */
			return "redirect:/";

		}
	}

	@RequestMapping(value = "/loginError", method = RequestMethod.POST)
	public String loginError(Model model) {
		logger.info("Starting of the method loginError");
		model.addAttribute("error", "Invalid Credentials.  Please try again.");

		return "login";
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		logger.debug("Starting of the method accessDenied");
		model.addAttribute("error", "You are not authorized to access this page");

		return "error";

	}



	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegister(Model model) {
		logger.info("Executing Registration page...");

		ShippingAddress shippingAddress = new ShippingAddress();
		BillingAddress billingAddress = new BillingAddress();
		Customer customer = new Customer();

		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);
		model.addAttribute("customer", customer);
		return "register";
	}

	// @PostMapping("/register")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
		logger.info("Starting saveUser method in CustomerController");
		if (result.hasErrors()) {
			logger.error("Binding Result has error");
			model.addAttribute("error", "Binding Result has error");
			return "error";
		}

		List<Customer> usersList = customerDAO.getAllCustomers();

		try {
			logger.info("Saving user...");
			for (int i = 0; i < usersList.size(); i++) {
				if (customer.getEmail().equalsIgnoreCase(usersList.get(i).getEmail())) {
					model.addAttribute("emailError", "This email is already exists");
					logger.error("Email is already exist");
					return "register";
				}

				if (customer.getUsername().equalsIgnoreCase(usersList.get(i).getUsername())) {
					model.addAttribute("usernameError", "This username is already exists");
					logger.error("Username is already exists");
					return "register";
				}

				if (customer.getMobileno().equalsIgnoreCase(usersList.get(i).getMobileno())) {
					model.addAttribute("mobileError", "Mobile number is already exists");
					logger.error("Mobile number is already exists");
					return "register";
				}
			}

			boolean flag = customerDAO.save(customer);

			if (flag == true) {

				model.addAttribute("success", "Registered successfully");
				logger.info("User registered successfully");
				return "login";
			} else {
				model.addAttribute("error", "Registration Failed, Please try again !");
				logger.error("Registration failed");
				return "register";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Exception occured " + e);
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}

	}

	@RequestMapping("/customer/profile")
	public String showProfile(Model model) {
		logger.info("Starting showProfile method of CustomerController");
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();

			Customer customer = customerDAO.getUserByUserName(username);
			session.setAttribute("customer", customer);

			return "admin/customerprofile";
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured " + e);
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}
	}

	@RequestMapping(value = "/customer/editCustomer/{id}", method = RequestMethod.GET)
	public String editProfile(@PathVariable("id") int id, Model model) {
		logger.info("Starting editProfile(GET) method of CustomerController");
		try {
			Customer customer = customerDAO.getUserById(id);
			model.addAttribute("editCustomer", customer);
			return "editprofile";
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured " + e);
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}
	}

	@RequestMapping(value = "/customer/editCustomer", method = RequestMethod.POST)
	public String editProfile(@ModelAttribute("editCustomer") Customer customer, BindingResult result, Model model) {
		logger.info("Starting editProfile(POST) method of CustomerController");
		if (result.hasErrors()) {
			return "error";
		}
		try {

			boolean flag = customerDAO.update(customer);
			if (flag) {
				model.addAttribute("success", "Your Profile is updated successfully");
				logger.info("Your Profile is updated successfully");
				return "admin/customerprofile";
			} else {
				model.addAttribute("error", "Failed to update profile");
				logger.info("Failed to update profile");
				return "admin/customerprofile";
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured " + e);
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}
	}


}
