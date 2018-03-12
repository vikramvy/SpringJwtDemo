package com.testdemo.client.service;



import org.springframework.web.client.RestTemplate;

import com.testdemo.security.jwtsecurity.model.*;

public class LoginService {
	
	 public boolean login(User user){
		 
	//TO actual api call to the jwt server	 
		 
		/* final String uri = "http://localhost:8090/authenticate";
		 RestTemplate restTemplate = new RestTemplate();
		 User userfromServer = restTemplate.postForObject( uri, user, User.class);
		 
		if (userfromServer!=null){
		return true;
		}
		
		return false;*/
		 
		 
		 return true;
	 
	 }

}
