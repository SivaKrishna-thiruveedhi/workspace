package com.cglia.aop.controller;

import java.util.List;

import com.cglia.aop.model.Village;
import com.cglia.aop.model.Zipcode;
import com.cglia.aop.service.VillageService;
import com.cglia.aop.service.ZipcodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeContoller {
	
	@Autowired
	VillageService villageService;
	@Autowired
	ZipcodeService zipcodeService;
	
	
	@RequestMapping("/")
	public String home(ModelMap model)
	{
		return "home";
	}
	
	@PostMapping("/save")
	public String addVillage(@RequestBody Village village) {
		villageService.saveVillage(village);
		return "Village Added";
	}
		
	@GetMapping("/getall")
	public List<Village> getall() {
		return villageService.getAllVillages();
	}
	
	@GetMapping("/{id}")
	public Village getVillage(@PathVariable int id) {
		return villageService.getVillageById(id);
	}
	
	@PutMapping("/{id}")
	public String updateVillage(@PathVariable int id, @RequestBody Village village) {
		villageService.updateVillageById(id, village);
		return "Updated Successfully";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		villageService.deleteVillage(id);
		return "Village Deleted..!!";
	}
	
	
}
