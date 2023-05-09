package com.kirti.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirti.portal.entities.CustomerMasters;
import com.kirti.portal.entities.LoanApplications;

public interface LoanApplicationsRepo extends JpaRepository<LoanApplications,String> {
	
	List<LoanApplications> findByCustomerMasters(CustomerMasters user); 
	List<LoanApplications> findByStatus(String status);

}
