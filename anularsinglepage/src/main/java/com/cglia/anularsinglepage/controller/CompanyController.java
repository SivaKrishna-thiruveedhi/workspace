package com.cglia.anularsinglepage.controller;

import java.util.List;

import com.cglia.anularsinglepage.model.Company;
import com.cglia.anularsinglepage.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@PostMapping("/company")
	public String add(@RequestBody Company company) {
		companyService.addCompany(company);
		return "Company added successfully";
	}
	
	@GetMapping("/company")
	public List<Company> getall() {
		return companyService.getAllCompanies();
	}
	
	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getone(@PathVariable int id) {
		Company company = companyService.getOneCompany(id);
		return ResponseEntity.ok(company);
	}
	
	@PutMapping("/company/{id}")
	public ResponseEntity<Company> updateOne(@PathVariable int id, @RequestBody Company oldcompany) {
		Company company = companyService.updateOneCompany(id, oldcompany);
		return ResponseEntity.ok(company);
	}
	
	@DeleteMapping("/company/{id}")
	public String deleteOne(@PathVariable int id) {
		companyService.deleteOneCompany(id);
		return "Company deleted successfully";
	}
}



















