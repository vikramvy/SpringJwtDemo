package com.testdemo.security.jwtsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.testdemo.security.jwtsecurity.model.*;
import com.testdemo.client.service.*;


@Controller
public class RegistrationController {

 RegistrationService registrationService;
	
	@PostMapping("/registration")
	   public String register(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, 
			   @RequestParam("street") String street,@RequestParam("city") String city,@RequestParam("zipCode") String zipCode,
			   @RequestParam("state") String state,@RequestParam("email") String email,@RequestParam("phone") String phone, Model model) {
		
		RegistrationForm form= new RegistrationForm();
		form.setFirstName(firstName);
		form.setLastName(lastName);
		form.setStreet(street);
		form.setCity(city);
		form.setZipCode(zipCode);
		form.setState(state);
		form.setEmail(email);
		form.setPhone(phone);
		
		registrationService= new RegistrationService();
		
	if (registrationService.register(form))	{
		 model.addAttribute("form", form);	
	      return "success";     
	}
	return "error";
	   }

}
