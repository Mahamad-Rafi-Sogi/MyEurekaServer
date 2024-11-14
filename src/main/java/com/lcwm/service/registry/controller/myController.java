package com.lcwm.service.registry.controller;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwm.service.registry.component.MyComponent;
import com.lcwm.service.registry.service.MyService;

@RestController
@RequestMapping("/api")
public class myController {
	

	@Autowired
	MyService myService;
	@Autowired
	MyComponent myComponent;
	
	
	@GetMapping("/greeting")
	public String welcome() {
		return myService.getServiceMessage();
	}
	
	@GetMapping("/greeting2")
	public String welcome2() {
		return myComponent.myComponent();
	}

}
