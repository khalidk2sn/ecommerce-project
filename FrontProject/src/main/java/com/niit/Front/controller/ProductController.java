package com.niit.Front.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shopingbackend.backproject.DAO.CategoryDAO;
import com.niit.shopingbackend.backproject.DAO.ProductDAO;
import com.niit.shopingbackend.backproject.DAO.SupplierDAO;
import com.niit.shopingbackend.backproject.model.Product;



@Controller
public class ProductController 
{

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	
	@RequestMapping("/pro")
	public String pro(Model model) 
	{
		model.addAttribute("productList", productDAO.getAllProduct());
		model.addAttribute("product", new Product());
		httpSession.setAttribute("supplierList",supplierDAO.getAllSupplier());
		httpSession.setAttribute("categoryList",categoryDAO.getAllCategory());
		return "product";

	}
	
	
	@RequestMapping("/addPro")
	public String Product(@ModelAttribute("product") Product p, Model model) {

		if (p.getProductId() == 0) {
			
			if (productDAO.addPro(p)) {
				model.addAttribute("msg", "Data SAVE in Database");
				MultipartFile file = p.getImage();
				ServletContext con = httpSession.getServletContext();
				String filelocation = con.getRealPath("/resources/images/");
				// String filename=filelocation+"\\"+p.getProductId()+".jpg";
				String filename = filelocation + File.separator + p.getProductId() + ".jpg";
				System.out.println(filename);
				try {
					byte b[] = file.getBytes();
					FileOutputStream fos = new FileOutputStream(filename);
					fos.write(b);
					fos.close();
				}

				catch (IOException ex) {
				} catch (Exception e) {
				}
			}

			else {
				model.addAttribute("msg", "Data not save in database");
			}
		} else {
			productDAO.update(p);
		}
		return "redirect:/pro";
	}
	
	@RequestMapping("/updateProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model model)
	{
		model.addAttribute("product", productDAO.getProductId(productId));
		model.addAttribute("productList", productDAO.getAllProduct());
		return "product";
    }
	
	
	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model model) 
	{
		productDAO.deletePro(productId);
		return "redirect:/pro";
	}
	
	
	
	
	@RequestMapping("/ProductByCategory/{categoryId}")
	public String getProdByCat(@PathVariable("categoryId") String id, Model model)
	{
	   System.out.println("Oll Category in Product ");
		model.addAttribute("listCategoryProduct",productDAO.getProductByCategory(id));
	    return "AllProductCategory";
	    
	}
	
	
	@RequestMapping("/More/{productId}")
	public String getdetail(@PathVariable("productId") int id, Model model)
	{
		System.out.println(" Check Controller ");
		model.addAttribute("productData",productDAO.getProductId(id));
	    return "Samsung";
	}
	
	
	
}
