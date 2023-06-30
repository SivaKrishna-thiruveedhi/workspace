package com.cglia.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.dto.Customer;
import com.cglia.dto.Employee;
import com.cglia.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerController {
	@Autowired
	Customer customer;
	@Autowired
	CustomerService customerService;
	
	
	// Saving customer {provide customername, customerEmail in request body}	
	@PostMapping("/save")
	public String saveCustomer(@RequestBody Customer customer1) {
		customer = customerService.saveCustomer(customer1);
		if (customer != null) {
			return "Customer added succesfully";
		} else {
			return "Customer is not added!!";
		}
	}
	
		
	// Retriving customer  {provide id in path}
	@GetMapping("/{id}")
	public Customer displayCustomer(@PathVariable int id) {
		customer = customerService.getCustomer(id);
		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}
	
	@GetMapping("/{id}/{name}")
	public Customer displayCustomer(@PathVariable int id, @PathVariable String name) {
		customer = customerService.getCustomerByNameAndId(id, name);
		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}
	
	
	// Updating customer  {provide id in path and customername, customerEmail modifiedBy in request body}
	@PutMapping("/put/{id}")
	public Customer updateCustomer(@RequestBody Customer customer1, @PathVariable int id) {
		customer = customerService.updateAndReturn(customer1, id);
		if (customer != null) {
			return customer;
		} else {
			return null;
		}
	}
	
	
	// Deleting customer {provide id in path}
	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return customerService.deleteCustomer(id);
	}
	
	
	
	// Retriving one employee by id {provide only id in url with no request body}
	
	@GetMapping("/employee/{id}")
	@ResponseBody
	public String getEmployee(@PathVariable int id) throws IOException, InterruptedException {

		String url = "http://192.168.60.55:5000/getone/"+id;
		
		HttpRequest request = 	HttpRequest.newBuilder()
								.GET()
								.uri(URI.create(url))
								.build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> responce = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		return responce.statusCode()+"\n"+responce.body();
	}
	
	// Updating employee {provide only name, email, salary in request body}
	
	@PutMapping("/employee/{id}")
	@ResponseBody
	public String updateEmployee(@RequestBody Employee employee, @PathVariable int id) throws IOException, InterruptedException {

	    String url = "http://192.168.60.55:5000/update/" + id;
	    ObjectMapper objectMapper = new ObjectMapper();
	    String requestBody = objectMapper.writeValueAsString(employee);
	    
	    HttpRequest request = HttpRequest.newBuilder()
	            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
	            .header("Content-Type", "application/json")
	            .uri(URI.create(url))
	            .build();

	    HttpClient client = HttpClient.newBuilder().build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	    return response.statusCode() + "\n" + response.body();
	}
	
	// Adding Employee {provide empId, name, email, salary in request body}
	
	@PostMapping("/employee")
	@ResponseBody
	public String saveEmployee(@RequestBody Employee employee) throws IOException, InterruptedException {

	    String url = "http://192.168.60.55:5000/save";
	    ObjectMapper objectMapper = new ObjectMapper();
	    String requestBody = objectMapper.writeValueAsString(employee);
	    
	    HttpRequest request = HttpRequest.newBuilder()
	            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
	            .header("Content-Type", "application/json")
	            .uri(URI.create(url))
	            .build();

	    HttpClient client = HttpClient.newBuilder().build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	    return response.statusCode() + "\n" + response.body();
	}
	
	
	// Deleting employee {provide id in path}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable  int id) throws IOException, InterruptedException {
		
	    String url = "http://192.168.60.55:5000/delete/"+id;
//	    ObjectMapper objectMapper = new ObjectMapper();
//	    String requestBody = objectMapper.writeValueAsString(employee);
	    HttpRequest request = HttpRequest.newBuilder()
	            .DELETE()
	            .header("Content-Type", "application/json")
	            .uri(URI.create(url))
	            .build();

	    HttpClient client = HttpClient.newBuilder().build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	    return response.uri()+ "\n" + response.statusCode() + "\n" + response.body();
	}
	
}
	




































