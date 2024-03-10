package com.web.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class SdfcBank {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNo;
	private String name;
	private String password;
	private String confirmPassword;
	private long amount;
	private String address;
	private String mobileNo;
	private long targetAccountNo;
	public SdfcBank() {
	}
	public SdfcBank(long accountNo, String name, String password, String confirmPassword, long amount, String address,
			String mobileNo, long targetAccountNo) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.amount = amount;
		this.address = address;
		this.mobileNo = mobileNo;
		this.targetAccountNo = targetAccountNo;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getTargetAccountNo() {
		return targetAccountNo;
	}
	public void setTargetAccountNo(long targetAccountNo) {
		this.targetAccountNo = targetAccountNo;
	}
	@Override
	public String toString() {
		return "SdfcBank [accountNo=" + accountNo + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", amount=" + amount + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", targetAccountNo=" + targetAccountNo + "]";
	}
	
}
