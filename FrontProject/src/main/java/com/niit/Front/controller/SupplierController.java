package com.niit.Front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.shopingbackend.backproject.DAO.SupplierDAO;
import com.niit.shopingbackend.backproject.model.Supplier;

@Controller
public class SupplierController {

	// ---------------------------------------Supplier-----------------------------///

	@Autowired
	private SupplierDAO supplierDAO;

	@RequestMapping("/supl")
	public String Supl(Model model) {
		model.addAttribute("supplierList", supplierDAO.getAllSupplier());
		model.addAttribute("supplier", new Supplier());
		return "supplier";

	}

	@RequestMapping("/addSup")
	public String Supplier(@ModelAttribute("supplier") Supplier s, Model model) {

		if (s.getSupplierId() == null || s.getSupplierId().isEmpty()) {
			System.out.println("if");
			if (supplierDAO.addSup(s)) {
				System.out.println("Add Supplier");
				model.addAttribute("msg", "Data SAVE in Database");
			}

			else {
				model.addAttribute("msg", "Data not save in database");
			}
		} else {
			supplierDAO.update(s);
		}
		return "redirect:/supl";
	}

	@RequestMapping("/updateSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId") String supplierId, Model model)
	{
		model.addAttribute("supplier", supplierDAO.getSupplierId(supplierId));
		model.addAttribute("supplierList", supplierDAO.getAllSupplier());
		return "supplier";

	}

	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") String supplierId, Model model) {
		supplierDAO.deleteSup(supplierId);
		return "redirect:/supl";
	}

}
