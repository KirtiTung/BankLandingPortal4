package com.kirti.portal.services;

import java.util.List;

import com.kirti.portal.entities.LoanApplications;
import com.kirti.portal.payloads.LoanApplicationsDto;

public interface LoanApplicationsService {
	//create
	LoanApplicationsDto createLoanApplication(LoanApplicationsDto loanAppDto,String CustomerMasterId);
	
	//update
	LoanApplicationsDto updateLoanApplication(LoanApplicationsDto loanAppDto,String loanAppId);
	
	//delete
	void deleteLoanApplications(String loanAppId);
	//get all loan
	List<LoanApplicationsDto> getAllLoanApplications();

	
	//get all LoanApplication by user
	List<LoanApplicationsDto> getLoanApplicationsByCustomerMaster(String userId);
	
	
	//return a specific loan application
	//Table 6 : Custmer  Management - Endpoint – 5
	List<LoanApplicationsDto> searchLoanApplicationsByStatus(String status);
	
	//Table 9 : Custmer  Management - Endpoint – 8
	//getByLoanId
	LoanApplicationsDto getLoanApplicationById(String loanAppId);
	
	LoanApplicationsDto checkCustomerAcceptanceStatus(String loanAppId);
	
	
	
}

