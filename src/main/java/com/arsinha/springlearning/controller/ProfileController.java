package com.arsinha.springlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	@Value("${appName}")
	private String appName;
	
	@Autowired
	private String version;
	@GetMapping("/appName")
	public String appName() {
		return appName +" "+version ;
	}

}
