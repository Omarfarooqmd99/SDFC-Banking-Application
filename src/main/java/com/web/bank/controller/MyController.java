package com.web.bank.controller;

import org.hibernate.metamodel.mapping.internal.MappingModelCreationProcess;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.query.JpqlParser.New_valueContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.bank.model.SdfcBank;
import com.web.bank.services.MyServiceImp;

@Controller
@RequestMapping("/sdfcbank")
public class MyController {
	@Autowired
	private MyServiceImp ms;

	@GetMapping("/")
	public String getHome() {
		return "bank/Home";
	}

	@GetMapping("/create")
	public String getCreate() {
		return "bank/CreateAccount";
	}

	@PostMapping("/create")
	public String createBank(SdfcBank user) {
		ms.insert(user);
		return "bank/Success";
	}
	@GetMapping("/balance")
	public String getBalance(ModelMap model) {
		model.addAttribute("bank", new SdfcBank());
		return "bank/Balance";
	}

	@PostMapping("/balance1")
	public String setBalance(@ModelAttribute("bank") SdfcBank bank, ModelMap model) {
		SdfcBank user1 = ms.checkBal(bank);
		if (user1 != null) {
			model.addAttribute("user", user1);
			return "bank/show";
		} else {
			model.addAttribute("error", "Invalid credentials");
			return "bank/Balance";
		}
	}
	
	@GetMapping("/deposit")
	public String getDepositAmo(ModelMap m) {
		m.addAttribute("depo", new SdfcBank());
		return "bank/Deposit";
	}
	
	@PostMapping("/deposit")
	public String setDepositAmo(@ModelAttribute("depo") SdfcBank sb, ModelMap m) {
		SdfcBank a = ms.depositAmount(sb);
		if(a!=null) {
			m.addAttribute("user", a);
			return "bank/show";
		}
		else {
			m.addAttribute("error", "Invalid credentials");
			return "bank/Deposit";
		}
	}
	
	@GetMapping("/withdraw")
	public String getWithdraw(ModelMap m) {
		m.addAttribute("depo", new SdfcBank());
		return "bank/Withdraw";
	}
	
	@PostMapping("/withdraw")
	public String setWithdraw(@ModelAttribute("depo") SdfcBank sb, ModelMap m) {
		SdfcBank a = ms.withdrawAmount(sb);
		if(a!=null) {
			m.addAttribute("user", a);
			return "bank/show";
		}
		else {
			m.addAttribute("error", "Invalid credentials");
			return "bank/Withdraw";
		}
	}
	
	@GetMapping("/transfer")
	public String getTransfer(ModelMap m) {
		m.addAttribute("tran", new SdfcBank());
		return "bank/Transfer";
	}
	
	@PostMapping("/transfer")
	public String setTransfer(@ModelAttribute("tran") SdfcBank sb, ModelMap m) {
		SdfcBank a = ms.transferAmount(sb);
		if(a!=null) {
			m.addAttribute("user", a);
			return "bank/show";
		}
		else {
			m.addAttribute("error", "Invalid credentials");
			return "bank/Transfer";
		}
	}
	
	@GetMapping("/closeAccount")
	public String getCloseAccount(ModelMap m) {
		m.addAttribute("close", new SdfcBank());
		return "bank/CloseAccount";
	}
	
	@PostMapping("/closeAccount")
	public String setCloseAccount(@ModelAttribute("close") SdfcBank sb, ModelMap m) {
		SdfcBank a = ms.accountClose(sb);
		if(a!=null) {
			m.addAttribute("user", a);
			return "bank/Success";
		}
		else {
			m.addAttribute("error", "Invalid credentials");
			return "bank/CloseAccount";
		}
	}
	
	@GetMapping("/aboutUs")
	public String getAboutUs() {
		return "bank/AboutUs";
	}
}
