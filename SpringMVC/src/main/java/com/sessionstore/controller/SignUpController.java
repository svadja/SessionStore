package com.sessionstore.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sessionstore.model.Customer;


public class SignUpController {


	public String addCustomer(
			@Valid Customer customer,
			BindingResult result) {

		/*for (Object object : result.getAllErrors()) {
			if (object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;

				System.out.println(fieldError.getField() + ":"
						+ fieldError.getCode());

			}

			if (object instanceof ObjectError) {
				ObjectError objectError = (ObjectError) object;

			}
		}*/

		if (result.hasErrors()) {
			return "SignUpForm";
		} else {
			return "Done";
		}

	}


	public String displayCustomerForm(ModelMap model) {

		model.addAttribute("customer", new Customer());
		return "SignUpForm";

	}

}