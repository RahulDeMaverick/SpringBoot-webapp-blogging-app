package com.foodapp.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	
	 @GetMapping("/")
	public String handleGet() {
	return "home";
	}
	 
	 @GetMapping("/loggedout.htm")
	public String Get() {
	return "home";
	}

}
