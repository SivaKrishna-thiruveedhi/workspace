package com.cglia.junittesting.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.junittesting.model.Village;
import com.cglia.junittesting.service.VillageServices;

@RestController
@RequestMapping("/village")
public class VillageController {
	
	private static final Logger logger = Logger.getLogger(VillageController.class.getName());
	
	@Autowired
	VillageServices villageService;
	Optional<Village> village;
	
	
	@GetMapping("/v1")
	public List<Village> getall() {
		List<Village> villa = villageService.getAllVillages();
		if (villa != null) {
			return villa;
		} else {
			return null;
		}
	}
	
	@GetMapping("/v1/getone/{id}")
	public Village getOneVillage(@PathVariable int id) {
		logger.info("Get by villageId is mapped");
		village = villageService.getOneVillage(id);
		logger.info("Get by villageId is Done");
		if (village.isPresent()) {
			return village.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/v1/getByName/{name}")
	public Village getByName(@PathVariable String name) {
		logger.info("Get by villageName is mapped");
		village = villageService.getOneByVillageName(name);
		logger.info("Get by villageName is Done");
		if (village.isPresent()) {
			return village.get();
		} else {
			return null;
		}
	}
	
	@PostMapping("/v1/save")
	public String save(@RequestBody Village village) {
		Village villa = villageService.addVillage(village);
		if (villa != null ) {
			return "Village Added";
		} else {
			return "Village not added";
		}
	}
	
	@DeleteMapping("/v1/deleteById/{id}")
	public String delete(@PathVariable int id) {
		Village villa = villageService.deleteById(id);
		if (villa != null) {
			return "Deleted Successfully";
		} else {
			return "Not deleted";
		}
	}
	
	@PutMapping("/v1/updateById/{id}")
	public String updateById(@RequestBody Village village, @PathVariable int id) {
		String msg = villageService.updateById(village, id);
		if (msg!=null) {
			return "Update Successfull";
		} else {
			return "Not updated";
		}
	}
	
}















