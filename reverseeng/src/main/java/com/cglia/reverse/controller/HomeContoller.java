package com.cglia.reverse.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeContoller {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model)
	{
		model.put("name", "SivaKrishna");
		return "home";
	}
}
