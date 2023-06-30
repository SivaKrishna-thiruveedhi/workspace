package com.cglia.anularsinglepage.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.cglia.anularsinglepage.model.Company;
import com.cglia.anularsinglepage.repo.CompanyRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServices implements CompanyService {

	@Autowired
	CompanyRepo companyRepo;
	String date = "yyyy-MM-dd HH:mm:ss";

	@Override
	public void addCompany(Company company) {
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(date); // Create a DateTimeFormatter 
																						  // object to specify the desired date and time format
		String currentDateTimeString = currentDateTime.format(formatter); // Format the current date and time to a string
		
		company.setStatus(1);
		company.setCreatedBy("sk");
		company.setModifiedBy("\t-\t");
		company.setModifiedon(currentDateTimeString);
		companyRepo.save(company);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepo.findByStatusGreaterThan(0);
	}

	@Override
	public Company getOneCompany(int id) {
		Optional<Company> option = companyRepo.findById(id);
		if (option.isPresent()) {
			Company oldCompany = option.get();
			if (oldCompany.getStatus() != 0) {
				if (oldCompany.getModifiedBy() == null) {
					oldCompany.setModifiedBy("\t----\t");
				}
				return oldCompany;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	@Override
	public  Company updateOneCompany(int id, Company company) {
		Optional<Company> option = companyRepo.findById(id);
		if (option.isPresent()) {
			Company oldCompany = option.get();
			if (oldCompany.getStatus() != 0) {
				
				LocalDateTime currentDateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(date); // Create a DateTimeFormatter 
																								  // object to specify the desired date and time format
				String currentDateTimeString = currentDateTime.format(formatter); // Format the current date and time to a string
								
				oldCompany.setAbout(company.getAbout());
				oldCompany.setCompanyName(company.getCompanyName());
				oldCompany.setYearStarted(company.getYearStarted());
				oldCompany.setModifiedBy("krishna");
				oldCompany.setModifiedon(currentDateTimeString);
				companyRepo.save(oldCompany);
				return oldCompany;
			}
		}
		return null;
	}

	@Override
	public void deleteOneCompany(int id) {
		Optional<Company> option = companyRepo.findById(id);
		if (option.isPresent()) {
			Company oldCompany = option.get();
			
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(date); // Create a DateTimeFormatter 
																							  // object to specify the desired date and time format
			String currentDateTimeString = currentDateTime.format(formatter); // Format the current date and time to a string
			
			oldCompany.setModifiedon(currentDateTimeString);
			oldCompany.setStatus(0);
			companyRepo.save(oldCompany);
		}
	}

}
