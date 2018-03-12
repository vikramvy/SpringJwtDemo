package com.testdemo.security.jwtsecurity.controller;


import javax.validation.Valid;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello World Payload Sample";
 
    }
    

	@RequestMapping(method=RequestMethod.POST, value="/rest/message")
	public String addMessage()
	{
		return "Hello Message";
	}
    
}


