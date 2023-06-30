package com.cglia.anularsinglepage.service;

import java.util.List;
import com.cglia.anularsinglepage.model.Company;

public interface CompanyService {

	void addCompany(Company company);

	List<Company> getAllCompanies();

	Company getOneCompany(int id);

	Company updateOneCompany(int id, Company company);

	void deleteOneCompany(int id);

}
