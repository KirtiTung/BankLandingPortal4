package com.kirti.portal.services.impl;

import java.time.LocalDate;  

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirti.portal.entities.CustomerMasters;
import com.kirti.portal.entities.LoanApplications;
import com.kirti.portal.exceptions.ResourceNotFoundException;
import com.kirti.portal.payloads.LoanApplicationsDto;
import com.kirti.portal.repositories.CustomerMastersRepo;
import com.kirti.portal.repositories.LoanApplicationsRepo;
import com.kirti.portal.services.LoanApplicationsService;

@Service
public class LoanApplicationsServiceImpl implements LoanApplicationsService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CustomerMastersRepo userRepo;

	@Autowired
	private LoanApplicationsRepo loanAppRepo;

	@Override
	public LoanApplicationsDto createLoanApplication(LoanApplicationsDto loanAppDto, String userId) {
		// TODO Auto-generated method stub.
		CustomerMasters user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
	

		LoanApplications loanApp=this.modelMapper.map(loanAppDto,LoanApplications.class);
		loanApp.setLoan_App_Date(LocalDate.now()); //
		loanApp.setCustomerMasters(user);//
		
		LoanApplications newLoanApp = this.loanAppRepo.save(loanApp);
		
	
		
		return this.modelMapper.map(newLoanApp,LoanApplicationsDto.class);
	}

	@Override
	public LoanApplicationsDto updateLoanApplication(LoanApplicationsDto loanAppDto, String loanAppId) {
		// TODO Auto-generated method stub
		  LoanApplications loanApp=this.loanAppRepo.findById(loanAppId).orElseThrow(()->new ResourceNotFoundException("Loan","id",loanAppId));
		  
		  LoanApplications updatedLoanApp = this.modelMapper.map(loanAppDto,LoanApplications.class);
		  updatedLoanApp.setLoan_App_Date(LocalDate.now());
		  updatedLoanApp.setCustomerMasters(loanApp.getCustomerMasters());
		  
		  LoanApplications save = this.loanAppRepo.save(updatedLoanApp);
		
		return this.modelMapper.map(save,LoanApplicationsDto.class);
	}

	@Override
	public void deleteLoanApplications(String loanAppId) {
		// TODO Auto-generated method stub
		LoanApplications loanApp = this.loanAppRepo.findById(loanAppId).orElseThrow(()->new ResourceNotFoundException("Loan","LoanApplication id",loanAppId));
		this.loanAppRepo.delete(loanApp);
	}

	@Override
	public List<LoanApplicationsDto> getAllLoanApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanApplicationsDto getLoanApplicationById(String loanAppId) {
		LoanApplications loanApp = this.loanAppRepo.findById(loanAppId).orElseThrow(()->new ResourceNotFoundException("LoanApplication","LoanApplication id",loanAppId));
		LoanApplicationsDto loanAppDto = this.modelMapper.map(loanApp,LoanApplicationsDto.class);
		// TODO Auto-generated method stub
		return loanAppDto;
	}

	@Override
	public List<LoanApplicationsDto> getLoanApplicationsByCustomerMaster(String userId) {
		// TODO Auto-generated method stub
		CustomerMasters user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Customer", "CustomerId", userId));
		List<LoanApplications> loanApps=this.loanAppRepo.findByCustomerMasters(user);
		
		List<LoanApplicationsDto> loanAppDtos = loanApps.stream().map((loanApp)->this.modelMapper.map(loanApp,LoanApplicationsDto.class)).collect(Collectors.toList());
		
		return loanAppDtos;
	}

	@Override
	public List<LoanApplicationsDto> searchLoanApplicationsByStatus(String status) {
		// TODO Auto-generated method stub
		List<LoanApplications> loanApps=this.loanAppRepo.findByStatus(status);
		List<LoanApplicationsDto> loanAppDtos = loanApps.stream().map((loanApp)->this.modelMapper.map(loanApp,LoanApplicationsDto.class)).collect(Collectors.toList());
		return loanAppDtos;
	}

	@Override
	public LoanApplicationsDto checkCustomerAcceptanceStatus(String loanAppId) {
		// TODO Auto-generated method stub
		LoanApplications loanApp = this.loanAppRepo.findById(loanAppId).orElseThrow(()->new ResourceNotFoundException("LoanApplication","LoanApplication id",loanAppId));
		
		return this.modelMapper.map(loanApp,LoanApplicationsDto.class);
	}

}
