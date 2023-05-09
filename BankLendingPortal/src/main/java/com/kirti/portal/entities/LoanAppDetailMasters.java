package com.kirti.portal.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LoanAppDetailMasters {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int loanAppId;
	private int monthNo;
	private int installment;
	private int interestRate;
	private int pOutStandingBeginOfMon;
	private int pRepayment;
	private int prOutStandingEndOfMon;
	private Date lastDateOfinstallPay;
	
	@ManyToOne
	@JoinColumn(name="Fk_Loan_App_Detail_Masters_Loan_Applications")
	private LoanApplications loanApplications;   //

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoanAppId() {
		return loanAppId;
	}

	public void setLoanAppId(int loanAppId) {
		this.loanAppId = loanAppId;
	}

	public int getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}

	public int getInstallment() {
		return installment;
	}

	public void setInstallment(int installment) {
		this.installment = installment;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public int getpOutStandingBeginOfMon() {
		return pOutStandingBeginOfMon;
	}

	public void setpOutStandingBeginOfMon(int pOutStandingBeginOfMon) {
		this.pOutStandingBeginOfMon = pOutStandingBeginOfMon;
	}

	public int getpRepayment() {
		return pRepayment;
	}

	public void setpRepayment(int pRepayment) {
		this.pRepayment = pRepayment;
	}

	public int getPrOutStandingEndOfMon() {
		return prOutStandingEndOfMon;
	}

	public void setPrOutStandingEndOfMon(int prOutStandingEndOfMon) {
		this.prOutStandingEndOfMon = prOutStandingEndOfMon;
	}

	public Date getLastDateOfinstallPay() {
		return lastDateOfinstallPay;
	}

	public void setLastDateOfinstallPay(Date lastDateOfinstallPay) {
		this.lastDateOfinstallPay = lastDateOfinstallPay;
	}

	public LoanApplications getLoanApplications() {
		return loanApplications;
	}

	public void setLoanApplications(LoanApplications loanApplications) {
		this.loanApplications = loanApplications;
	}

	public LoanAppDetailMasters(int id, int loanAppId, int monthNo, int installment, int interestRate,
			int pOutStandingBeginOfMon, int pRepayment, int prOutStandingEndOfMon, Date lastDateOfinstallPay,
			LoanApplications loanApplications) {
		super();
		this.id = id;
		this.loanAppId = loanAppId;
		this.monthNo = monthNo;
		this.installment = installment;
		this.interestRate = interestRate;
		this.pOutStandingBeginOfMon = pOutStandingBeginOfMon;
		this.pRepayment = pRepayment;
		this.prOutStandingEndOfMon = prOutStandingEndOfMon;
		this.lastDateOfinstallPay = lastDateOfinstallPay;
		this.loanApplications = loanApplications;
	}

	public LoanAppDetailMasters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
