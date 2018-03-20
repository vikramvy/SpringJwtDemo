package com.testdemo.security.jwtsecurity.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testdemo.security.jwtsecurity.model.RegistrationForm;
import com.testdemo.security.jwtsecurity.service.RepositoryService;

@RestController
@RequestMapping("/rest")
public class HelloController {

	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private  RepositoryService repoService;
    @GetMapping
    public String hello() {
        return "Hello World Payload Sample";
 
    }
    
    @RequestMapping("/allRegistered")
	public List<RegistrationForm> getAllContacts()
	{
		log.info("log: accessing contacts resource get all contacts");
		return repoService.getAllContacts();
	}

	@RequestMapping(method=RequestMethod.POST, value="/registration")
	public void addContact(@Valid @RequestBody RegistrationForm contact)
	{
		repoService.addRegistration(contact);		
	}

	@RequestMapping(method=RequestMethod.POST, value="/message")
	public String addMessage()
	{
		return "Hello Message";
	}
    
}


