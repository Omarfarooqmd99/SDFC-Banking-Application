package com.web.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.bank.model.SdfcBank;
import com.web.bank.repository.SdfcBankRepo;

@Service
public class MyServiceImp implements MyService {

	@Autowired
	private SdfcBankRepo repo;

	@Override
	public SdfcBank insert(SdfcBank user) {
		return repo.save(user);
	}

	/*
	 * public SdfcBank checkBal(SdfcBank u) { long acc = u.getAccountNo(); String
	 * name = u.getName(); String pass = u.getPassword();
	 * 
	 * Optional<SdfcBank> optionalAccount = repo.findById(acc);
	 * 
	 * if (optionalAccount.isPresent()) { SdfcBank oracc = optionalAccount.get(); if
	 * (name.equals(oracc.getName()) && pass.equals(oracc.getPassword())) { return
	 * oracc; } }
	 * 
	 * return null; }
	 */
	public SdfcBank checkBal(SdfcBank u) {
	    long acc = u.getAccountNo();
	    String name = u.getName();
	    String pass = u.getPassword();
	    
	    // Fix 1: Use repo.findById(acc) directly without calling .get(), 
	    // as it will return the entity or null.
	    SdfcBank oracc = repo.findById(acc).orElse(null);
	    
	    // Fix 2: Check if oracc is not null before proceeding with further checks.
	    if (oracc != null && name.equals(oracc.getName()) && pass.equals(oracc.getPassword())) {
	        return oracc;
	    }

	    return null;
	}
	public SdfcBank depositAmount(SdfcBank b) {
		long acc = b.getAccountNo();
	    String name = b.getName();
	    String pass = b.getPassword();
	    long amount = b.getAmount();
	    SdfcBank acc1 = repo.findById(acc).orElse(null);
	    long oramount = acc1.getAmount();
	    if(acc1!=null && acc==acc1.getAccountNo() && name.equals(acc1.getName()) && pass.equals(acc1.getPassword())) {
	    	oramount=oramount+amount;
	    	acc1.setAmount(oramount);
	    	repo.save(acc1);
	    	return acc1;
	    }
		return null;
	}

	
	public SdfcBank withdrawAmount(SdfcBank b) {
		long acc = b.getAccountNo();
	    String name = b.getName();
	    String pass = b.getPassword();
	    long amount = b.getAmount();
	    SdfcBank acc1 = repo.findById(acc).orElse(null);
	    long oramount = acc1.getAmount();
	    if(acc1!=null && acc==acc1.getAccountNo() && name.equals(acc1.getName()) && pass.equals(acc1.getPassword())) {
	    	oramount=oramount-amount;
	    	acc1.setAmount(oramount);
	    	repo.save(acc1);
	    	return acc1;
	    }
		return null;
	}
	
	public SdfcBank transferAmount(SdfcBank b) {
		long acc = b.getAccountNo();
	    String name = b.getName();
	    String pass = b.getPassword();
	    
	    long tAcc = b.getTargetAccountNo();
	    long amount = b.getAmount();
	    
	    SdfcBank acc1 = repo.findById(acc).orElse(null);
	    SdfcBank acc2 = repo.findById(tAcc).orElse(null);
	    
	    long oramount = acc1.getAmount();
	    long oramount1 = acc2.getAmount();
	    
	    if(acc1!=null && acc2!=null && acc==acc1.getAccountNo() && name.equals(acc1.getName()) && pass.equals(acc1.getPassword())) {
	    	oramount=oramount-amount;
	    	oramount1=oramount1+amount;
	    	
	    	acc1.setAmount(oramount);
	    	acc2.setAmount(oramount1);
	    	
	    	repo.save(acc1);
	    	repo.save(acc2);
	    	return acc1;
	    }
		return null;
	}
	
	public SdfcBank accountClose(SdfcBank sb) {
		long acc = sb.getAccountNo();
		String name = sb.getName();
		String pass = sb.getPassword();
		
		SdfcBank oracc = repo.findById(acc).orElse(null);
		
		if(oracc!=null && acc==oracc.getAccountNo() && name.equals(oracc.getName()) && pass.equals(oracc.getPassword())) {
			repo.deleteById(acc);
			return oracc;
		}
		return null;
	}

}
