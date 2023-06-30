package com.cglia.anularsinglepage.repo;

import java.util.List;

import com.cglia.anularsinglepage.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
	
	public List<Company> findByStatusGreaterThan(int status);
}
