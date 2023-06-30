package com.cglia.springsecurity.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContoller {
	@RequestMapping("/")
	public String home(ModelMap model)
	{
		model.put("name", "SivaKrishna");
		return "home";
	}
}
