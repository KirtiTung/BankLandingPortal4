package com.kirti.portal.payloads;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.kirti.portal.entities.CustomerMasters;

public class LoanApplicationsDto {
	
	private String Pk_Loan_Application;
	
	private int loan_Amt;
	private int no_Of_Years;
	private String purpose;
	private String app_Status;
	private String type_Of_Loan;
	private LocalDate loan_App_Date;   //
	private String status;
	private CustomerMastersDto customerMasters;   //
	public String getPk_Loan_Application() {
		return Pk_Loan_Application;
	}
	public void setPk_Loan_Application(String pk_Loan_Application) {
		Pk_Loan_Application = pk_Loan_Application;
	}
	public int getLoan_Amt() {
		return loan_Amt;
	}
	public void setLoan_Amt(int loan_Amt) {
		this.loan_Amt = loan_Amt;
	}
	public int getNo_Of_Years() {
		return no_Of_Years;
	}
	public void setNo_Of_Years(int no_Of_Years) {
		this.no_Of_Years = no_Of_Years;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getApp_Status() {
		return app_Status;
	}
	public void setApp_Status(String app_Status) {
		this.app_Status = app_Status;
	}
	public String getType_Of_Loan() {
		return type_Of_Loan;
	}
	public void setType_Of_Loan(String type_Of_Loan) {
		this.type_Of_Loan = type_Of_Loan;
	}
	public LocalDate getLoan_App_Date() {
		return loan_App_Date;
	}
	public void setLoan_App_Date(LocalDate loan_App_Date) {
		this.loan_App_Date = loan_App_Date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerMastersDto getCustomerMasters() {
		return customerMasters;
	}
	public void setCustomerMasters(CustomerMastersDto customerMasters) {
		this.customerMasters = customerMasters;
	}
	public LoanApplicationsDto(String pk_Loan_Application, int loan_Amt, int no_Of_Years, String purpose,
			String app_Status, String type_Of_Loan, LocalDate loan_App_Date, String status,
			CustomerMastersDto customerMasters) {
		super();
		Pk_Loan_Application = pk_Loan_Application;
		this.loan_Amt = loan_Amt;
		this.no_Of_Years = no_Of_Years;
		this.purpose = purpose;
		this.app_Status = app_Status;
		this.type_Of_Loan = type_Of_Loan;
		this.loan_App_Date = loan_App_Date;
		this.status = status;
		this.customerMasters = customerMasters;
	}
	public LoanApplicationsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
