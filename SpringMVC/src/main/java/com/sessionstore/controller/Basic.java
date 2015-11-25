package com.sessionstore.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sessionstore.model.Customer;

@Controller
@SessionAttributes({"customer"})
public class Basic {
	
	@RequestMapping(value = "/1",method = RequestMethod.GET)
	public String displayCustomerForm1(ModelMap model) {
		Customer customer = new Customer(1,"cid_1", "customer1", 18);
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@RequestMapping(value = "/2",method = RequestMethod.GET)
	public String displayCustomerForm2(ModelMap model) {
		Customer customer = new Customer(2,"cid_2", "customer2", 20);
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String addCustomer(Customer customer) {
		System.err.println("Customer " + customer); 
		return "Done";
	}
}
