package com.testdemo.security.jwtsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testdemo.security.jwtsecurity.model.RegistrationForm;

@Service("repositoryService")
public class RepositoryService {

	
	@Autowired
	RegistrationRepository registrationFormRepo;
	
	public void addRegistration(RegistrationForm contact) {
		registrationFormRepo.save(contact);			
	}
	
	public List<RegistrationForm> getAllContacts()
	{
		List<RegistrationForm> contacts = new ArrayList<RegistrationForm>();
		registrationFormRepo.findAll()
		.forEach(contacts::add);
		return contacts;
	}
}
