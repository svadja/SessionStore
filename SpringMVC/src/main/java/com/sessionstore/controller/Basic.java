package com.sessionstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.sessionstore.model.Customer;

@Controller
@SessionAttributes(types= Customer.class)
public class Basic {
	
	@RequestMapping(value = "/1",method = RequestMethod.GET)
	public String displayCustomerForm1(ModelMap model, HttpServletRequest request) {
		Customer customer = new Customer(1,  "customer1", 18);
		request.setAttribute("customer_cid", getCID(customer));
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@RequestMapping(value = "/2",method = RequestMethod.GET)
	public String displayCustomerForm2(ModelMap model,  HttpServletRequest request) {
		Customer customer = new Customer(2, "customer2", 20);
		request.setAttribute("customer_cid", getCID(customer));
		model.addAttribute("customer", customer);
		return "customer";
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String addCustomer(Customer customer) {
		System.err.println("Customer " + customer); 
		return "Done";
	}
	
	private String getCID(Object obj){
		return Integer.toString(obj.hashCode());
	}
}
